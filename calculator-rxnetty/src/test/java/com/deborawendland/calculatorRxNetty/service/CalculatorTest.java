package com.deborawendland.calculatorRxNetty.service;

import com.deborawendland.calculatorRxNetty.exceptions.InvalidOperatorException;
import com.deborawendland.calculatorRxNetty.operation.Multiplication;
import com.deborawendland.calculatorRxNetty.operation.Subtraction;
import com.deborawendland.calculatorRxNetty.config.AppConfig;
import com.deborawendland.calculatorRxNetty.exceptions.DivisionByZeroException;
import com.deborawendland.calculatorRxNetty.operation.Summation;
import com.deborawendland.cloud.tema08.operation.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculatorTest {

    private Calculator calculator;
    private ApplicationContext applicationContext;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init(){
        this.applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.calculator = (Calculator) applicationContext.getBean("calculator");
    }

    @Test
    public void pathTest(){
        Assert.assertNotNull(calculator);
    }

    @Test
    public void doOperationSummationTest() {
        Assert.assertEquals(6, calculator.doOperation("sum", 2, 4), 0.01);
    }

    @Test
    public void doOperationSubtractionTest() {
        Assert.assertEquals(-4, calculator.doOperation("sub", 3, 7), 0.01);
    }

    @Test
    public void doOperationMultiplicationTest() {
        Assert.assertEquals(6, calculator.doOperation("mul", 2, 3), 0.01);
    }

    @Test
    public void doOperationExponentiationTest() {
        Assert.assertEquals(1, calculator.doOperation("exp", 6, 0), 0.01);
    }

    @Test
    public void doOperationValidDivisionTest() {
        Assert.assertEquals(0.5, calculator.doOperation("div", 2,4 ), 0.01);
    }

    @Test
    public void doOperationInvalidDivisionTest() {
        thrown.expect(DivisionByZeroException.class);
        thrown.expectMessage("Invalid Operation: dividing by 0");
        System.out.println(calculator.doOperation("div", 8, 0));
    }

    @Test
    public void doOperationInvalidOperator() {
        thrown.expect(InvalidOperatorException.class);
        thrown.expectMessage("Invalid Operator. Supported operations: sum, sub, mul, div e exp.");
        System.out.println(calculator.doOperation("sen", 8, 0));
    }

    @Test
    public void operationsLogTest(){
        calculator.getOperationsLog().clear();
        calculator.doOperation("sub", 2, 5);
        calculator.doOperation("mul", 6, 4);
        calculator.doOperation("sum", 5, 2);

        Assert.assertTrue(calculator.getOperationsLog().size() == 3);

        Assert.assertTrue(calculator.getOperationsLog().get(0) instanceof Subtraction);

        Assert.assertTrue(calculator.getOperationsLog().get(1) instanceof Multiplication);

        Assert.assertTrue(calculator.getOperationsLog().get(2) instanceof Summation);
    }

}