package com.deborawendland.calculatorRxNetty.operation;

public interface Operation extends Cloneable {

    double doOperation();
    String toString();
}
