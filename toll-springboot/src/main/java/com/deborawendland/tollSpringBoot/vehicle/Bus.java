package com.deborawendland.tollSpringBoot.vehicle;

public class Bus implements Vehicle {

    private Double fee;
    private Double price;

    public Bus(){
        this.fee = 1.59;
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
