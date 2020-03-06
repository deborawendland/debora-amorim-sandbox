package com.deborawendland.tollSpringBoot.rest;

import com.deborawendland.tollSpringBoot.config.AppConfig;
import com.deborawendland.tollSpringBoot.toll.TollService;
import com.deborawendland.cloud.tema05.vehicle.*;
import com.deborawendland.tollSpringBoot.vehicle.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@RestController
@Path("")
public class TollRestController extends Application {

    private Gson gson;
    private ApplicationContext applicationContext;
    private HashMap<String, Vehicle> vehicles;
    private TollService tollService;

    public TollRestController(){
        this.applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.tollService = (TollService) applicationContext.getBean("tollService");
        this.vehicles = new HashMap<>();
        this.gson = new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create();
        setVehicles();
    }

    public void setVehicles(){
        this.vehicles.put("beetle", (Beetle) applicationContext.getBean("beetle"));
        this.vehicles.put("bike", (Bike) applicationContext.getBean("bike"));
        this.vehicles.put("bus", (Bus) applicationContext.getBean("bus"));
        this.vehicles.put("motorcycle", (Motorcycle) applicationContext.getBean("motorcycle"));
        this.vehicles.put("truck", (Truck) applicationContext.getBean("truck"));
    }

    @GET
    @Path("/payment/{vehicle}/{paymentMoney}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doPayment(@PathParam("vehicle") String vehicle, @PathParam("paymentMoney") double paymentMoney){
        if (vehicles.containsKey(vehicle)){
            return Response.ok(gson.toJson(tollService.doPayment(vehicles.get(vehicle.toLowerCase()), paymentMoney))).build();
        } else {
            return Response.status(400, "Illegal Vehicle Type").build();
        }
    }

    @GET
    @Path("/payment/{vehicle}/{paymentMoney}/{numberAxle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doPayment(@PathParam("vehicle") String vehicle, @PathParam("paymentMoney") double paymentMoney, @PathParam("numberAxle") int numberAxle){
        if (vehicle.equalsIgnoreCase("truck")){
            Truck truck = (Truck) vehicles.get(vehicle.toLowerCase());
            truck.setAxleNumber(numberAxle);
            return Response.ok(gson.toJson(tollService.doPayment(vehicles.get(vehicle.toLowerCase()), paymentMoney))).build();
        } else {
            return Response.status(400, "Illegal Vehicle Type").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFees (){
        gson.toJson(vehicles.get("beetle"), Vehicle.class);
        return Response.ok(gson.toJson(vehicles)).build();
    }
}

