package com.deborawendland.calculatorRxNetty.rxNetty;

import com.deborawendland.calculatorRxNetty.operation.Operation;
import com.deborawendland.cloud.tema08.operation.*;
import com.deborawendland.calculatorRxNetty.service.Calculator;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import rx.Observable;
import rx.Subscriber;

import java.util.stream.Collectors;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {

    private final String healthCheckUri;
    private final HealthCheckEndpoint healthCheckEndpoint;
    private Calculator calculator;
    private String message;

    private static final String URI_PARAMS_ERROR = "{\"Error\": \"Error reading URI parameter. Please follow the URI's example: /{operator}/{term}/{term}\"}";
    private static final Integer OPERATOR_POSITION = 0;
    private static final Integer FIRST_TERM_POSITION = 1;
    private static final Integer SECOND_TERM_POSITION = 2;


    public RxNettyHandler(String healthCheckUri, HealthCheckEndpoint healthCheckEndpoint, Calculator calculator) {
        this.healthCheckUri = healthCheckUri;
        this.healthCheckEndpoint = healthCheckEndpoint;
        this.calculator = calculator;
    }

    @Override
    public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {

        Subscriber<HttpServerRequest<ByteBuf>> subscriber = new Subscriber<HttpServerRequest<ByteBuf>>() {
            @Override
            public void onCompleted() {
                response.writeString(message);
                response.close(true);
            }

            @Override
            public void onError(Throwable e) {
                response.setStatus(HttpResponseStatus.BAD_REQUEST);
                response.writeString("{\"Error\": \"" + e.getMessage() + "\"}");
                response.close(true);
                Observable.error(e);
            }

            @Override
            public void onNext(HttpServerRequest<ByteBuf> httpServerRequest) {
                String requestUri = httpServerRequest.getUri();
                if (requestUri.startsWith(healthCheckUri)){
                    healthCheckEndpoint.handle(httpServerRequest, response);
                } else if (requestUri.startsWith("/logs")) {
                    message = calculator.getOperationsLog().stream().map(Operation::toString).collect(Collectors.joining(",\n"));
                } else if (requestUri.contains("/")){
                    message = getOperationMessage(request.getPath().substring(1).split("/", 0));
                } else {
                    message = URI_PARAMS_ERROR;
                }
            }
        };

        Observable<HttpServerRequest<ByteBuf>> observable = Observable.just(request);
        observable.subscribe(subscriber);

        return Observable.empty();
    }

    public String getOperationMessage(String[] uriParam){
        if (uriParam.length != 3) {
            return URI_PARAMS_ERROR;
        } else {
            String operation = uriParam[OPERATOR_POSITION];
            double firstTerm = Double.parseDouble(uriParam[FIRST_TERM_POSITION]);
            double secondTerm = Double.parseDouble(uriParam[SECOND_TERM_POSITION]);
            return ("{\"Result\": " + calculator.doOperation(operation, firstTerm, secondTerm) + "}");
        }
    }

}
