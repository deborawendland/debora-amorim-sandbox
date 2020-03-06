package com.deborawendland.calculatorRxNetty.operation;

import com.deborawendland.calculatorRxNetty.exceptions.DivisionByZeroException;

public class Division implements Operation {

    private double firstTerm;
    private double secondTerm;

    public Division(double firstTerm, double secondTerm) {
        this.firstTerm = firstTerm;
        this.secondTerm = secondTerm;
    }

    @Override
    public double doOperation() {
        if (secondTerm != 0){
            return firstTerm/secondTerm;
        } else {
            throw new DivisionByZeroException("Invalid Operation: dividing by 0");
        }
    }

    @Override
    public String toString(){
        return "{\"" + this.getClass().getSimpleName() + "\": {" +
                "\"terms\": [" + firstTerm + ", " + secondTerm  + "]}}";
    }
}