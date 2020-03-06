package com.deborawendland.calculatorRxNetty.service;

import com.deborawendland.calculatorRxNetty.exceptions.InvalidOperatorException;
import com.deborawendland.calculatorRxNetty.operation.*;
import com.deborawendland.cloud.tema08.operation.*;

import java.util.*;

public class Calculator {

    private List<Operation> operationsLog;

    public Calculator(){
        this.operationsLog = new ArrayList();
    }

    public double doOperation(String op, double firstTerm, double secondTerm){
        Operation operation = stringToOperation(op, firstTerm, secondTerm);
        operationsLog.add(operation);
        return operation.doOperation();
    }

    public List<Operation> getOperationsLog() {
        return operationsLog;
    }

    private Operation stringToOperation(String op, double firstTerm, double secondTerm){
        switch (op.toLowerCase()){
            case "sum":
                return new Summation(firstTerm,secondTerm);
            case "sub":
                return new Subtraction(firstTerm,secondTerm);
            case "mul":
                return new Multiplication(firstTerm,secondTerm);
            case "div":
                return new Division(firstTerm,secondTerm);
            case "exp":
                return new Exponentiation(firstTerm,secondTerm);
            default:
                throw new InvalidOperatorException("Invalid Operator. Supported operations: sum, sub, mul, div e exp.");
        }
    }

}

