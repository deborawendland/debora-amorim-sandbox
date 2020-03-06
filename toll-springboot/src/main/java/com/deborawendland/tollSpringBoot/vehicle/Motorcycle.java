package com.deborawendland.tollSpringBoot.vehicle;

public class Motorcycle implements Vehicle {

    private Double fee;
    private Double price;

    public Motorcycle (){
        this.fee = 1.00;
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
