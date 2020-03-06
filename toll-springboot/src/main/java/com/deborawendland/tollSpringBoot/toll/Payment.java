package com.deborawendland.tollSpringBoot.toll;

import com.deborawendland.tollSpringBoot.exception.IllegalTollPaymentAmount;
import com.deborawendland.tollSpringBoot.vehicle.Vehicle;

import java.time.LocalDate;

public class Payment {

    private Vehicle vehicle;
    private LocalDate date;
    private double paymentMoney;
    private double paymentChange;

    public Payment(Vehicle vehicle, double paymentMoney) {
        this.vehicle = vehicle;
        this.date = LocalDate.now();
        this.paymentMoney = paymentMoney;
    }

    public void calculateChange(){
        this.paymentChange = this.paymentMoney - this.vehicle.getPrice();
        if (this.paymentChange < 0){
            throw new IllegalTollPaymentAmount("Unsufficient payment amount");
        }
    }

    public double getPaymentChange() {
        return paymentChange;
    }

    @Override
    public String toString() {
        return "Vehicle: " + vehicle.getClass().getSimpleName() +
                "\nDate: " + date +
                "\nPrice: " + String.format("%.2f", vehicle.getPrice()) +
                "\nPayment Money: " + String.format("%.2f", paymentMoney) +
                "\nPayment Change:" + String.format("%.2f", paymentChange);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
