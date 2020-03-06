package com.deborawendland.calculatorRxNetty.app;

import com.deborawendland.calculatorRxNetty.rxNetty.RxNettyHandler;
import com.deborawendland.calculatorRxNetty.config.AppConfig;
import com.deborawendland.calculatorRxNetty.config.HealthCheckConfig;
import com.deborawendland.calculatorRxNetty.rxNetty.HealthCheckResource;
import com.deborawendland.calculatorRxNetty.service.Calculator;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.KaryonBootstrapModule;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.servo.KaryonServoModule;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRunner {

    public static void main(String[] args) {

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext healthCheckContext = new AnnotationConfigApplicationContext(HealthCheckConfig.class);
        HealthCheckResource healthCheck = (HealthCheckResource) healthCheckContext.getBean("healthCheckResource");

        Karyon.forRequestHandler(8080,
                new RxNettyHandler("/healthcheck",
                        new HealthCheckEndpoint(healthCheck),
                        (Calculator) appContext.getBean("calculator")),
                new KaryonBootstrapModule(healthCheck),
                new ArchaiusBootstrapModule("calculator"),
                Karyon.toBootstrapModule(KaryonWebAdminModule.class),
                ShutdownModule.asBootstrapModule(),
                KaryonServoModule.asBootstrapModule()
        ).startAndWaitTillShutdown();
    }

}

