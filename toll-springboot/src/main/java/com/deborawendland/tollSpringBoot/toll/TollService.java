package com.deborawendland.tollSpringBoot.toll;

import com.deborawendland.tollSpringBoot.vehicle.Vehicle;

public class TollService {

    public TollService() {}

    public Payment doPayment(Vehicle vehicle, double paymentMoney){
        Payment payment = new Payment(vehicle, paymentMoney);
        payment.calculateChange();
        return payment;
    }

}
