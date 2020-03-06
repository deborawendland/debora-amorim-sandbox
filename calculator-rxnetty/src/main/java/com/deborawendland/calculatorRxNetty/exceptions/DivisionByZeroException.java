package com.deborawendland.calculatorRxNetty.exceptions;

public class DivisionByZeroException extends RuntimeException {

    public DivisionByZeroException(String message) {
        super(message);
    }
}
