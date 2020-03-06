package com.deborawendland.tollSpringBoot.vehicle;

public class Truck implements Vehicle {

    private Double fee;
    private Double feePerAxle;
    private Integer axleNumber;
    private Double price;

    public Truck (){
        this.fee = 3.95;
        this.feePerAxle = 1.00;
    }

    @Override
    public double getFee() {
        return this.fee;
    }

    @Override
    public double getPrice() {
        if (this.price == null){
            this.price = fee + (feePerAxle * axleNumber);
        }
        return this.price;
    }

    public void setAxleNumber(int axleNumber) {
        this.axleNumber = axleNumber;
    }

    public double getFeePerAxle() {
        return feePerAxle;
    }
}
