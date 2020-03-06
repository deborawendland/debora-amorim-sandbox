package com.deborawendland.tollSpringBoot.vehicle;

public class Beetle implements Vehicle {

    private Double fee;
    private Double price;

    public Beetle() {
        this.fee = 2.11;
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
