package com.deborawendland.calculatorJetty.operation;

public interface Operation extends Cloneable {

    double doOperation();
    void addFirstTerm(double firstTerm);
    void addSecondTerm(double secondTerm);
    double getFirstTerm();
    double getSecondTerm();
    String toString();
}
