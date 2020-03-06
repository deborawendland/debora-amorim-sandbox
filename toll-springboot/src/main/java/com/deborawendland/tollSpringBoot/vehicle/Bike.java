package com.deborawendland.tollSpringBoot.vehicle;

public class Bike implements Vehicle {

    private Double fee;
    private Double price;

    public Bike() {
        this.fee =  0.49;
    }

    @Override
    public double getFee() {
        return this.fee;
    }

    @Override
    public double getPrice() {
        if (this.price == null){
            this.price = fee;
        }
        return this.price;
    }
}
