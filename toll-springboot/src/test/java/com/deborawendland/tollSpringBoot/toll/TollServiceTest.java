package com.deborawendland.tollSpringBoot.toll;

import com.deborawendland.tollSpringBoot.exception.IllegalTollPaymentAmount;
import com.deborawendland.tollSpringBoot.config.AppConfig;
import com.deborawendland.cloud.tema05.vehicle.*;
import com.deborawendland.tollSpringBoot.vehicle.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TollServiceTest {

    @Autowired
    private TollService tollService;

    @Autowired
    private Beetle beetle;

    @Autowired
    private Bike bike;

    @Autowired
    private Bus bus;

    @Autowired
    private Motorcycle motorcycle;

    @Autowired
    private Truck truck;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void pathTest(){
        Assert.assertNotNull(tollService);
    }

    @Test
    public void doValidBikePaymentTest() {
        Assert.assertTrue(tollService.doPayment(bike, 1).getPaymentChange() >= 0);
    }

    @Test
    public void doValidBusPaymentTest() {
        Assert.assertTrue(tollService.doPayment(bus, 2).getPaymentChange() >= 0);
    }

    @Test
    public void doValidBeetlePaymentTest() {
        Assert.assertTrue(tollService.doPayment(beetle, 2.50).getPaymentChange() >= 0);
    }

    @Test
    public void doValidTruckWithoutAxlePaymentTest() {
        this.truck.setAxleNumber(0);
        Assert.assertTrue(tollService.doPayment(truck, 4).getPaymentChange() >= 0);
    }

    @Test
    public void doValidTruckWithTwoAxlePaymentTest() {
        this.truck.setAxleNumber(2);
        Assert.assertTrue(tollService.doPayment(truck, 6).getPaymentChange() >= 0);
    }

    @Test
    public void doInvalidBikePaymentTest() {
        thrown.expect(IllegalTollPaymentAmount.class);
        thrown.expectMessage("Unsufficient payment amount");
        tollService.doPayment(bike, 0.30);
    }

}