package com.deborawendland.tollSpringBoot.exception;

public class IllegalTollPaymentAmount extends RuntimeException {

    public IllegalTollPaymentAmount(String s) {
        super(s);
    }
}
