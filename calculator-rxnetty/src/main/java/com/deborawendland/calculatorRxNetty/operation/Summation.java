package com.deborawendland.calculatorRxNetty.operation;

public class Summation implements Operation {

    private double firstTerm;
    private double secondTerm;

    public Summation (double firstTerm, double secondTerm) {
        this.firstTerm = firstTerm;
        this.secondTerm = secondTerm;
    }

    @Override
    public double doOperation() {
        return firstTerm + secondTerm;
    }

    @Override
    public String toString(){
        return "{\"" + this.getClass().getSimpleName() + "\": {" +
                "\"terms\": [" + firstTerm + ", " + secondTerm  + "]}}";
    }
}
