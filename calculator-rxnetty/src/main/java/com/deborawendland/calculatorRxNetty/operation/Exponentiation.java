package com.deborawendland.calculatorRxNetty.operation;

public class Exponentiation implements Operation {

    private double firstTerm;
    private double secondTerm;

    public Exponentiation(double firstTerm, double secondTerm) {
        this.firstTerm = firstTerm;
        this.secondTerm = secondTerm;
    }

    @Override
    public double doOperation() {
        return Math.pow(firstTerm, secondTerm);
    }

    @Override
    public String toString(){
        return "{\"" + this.getClass().getSimpleName() + "\": {" +
                "\"terms\": [" + firstTerm + ", " + secondTerm  + "]}}";
    }
}
