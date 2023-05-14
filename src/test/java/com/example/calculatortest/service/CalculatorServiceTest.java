package com.example.calculatortest.service;

import com.example.calculatortest.exception.ZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.DigestException;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();
    @Test
    public void plusTest(){
        Number actual = calculatorService.plus(1.0,2.0);
        Number expected = 3.0;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.plus(-1.5,2.5);
        expected = 1.0;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void minusTest(){
        Number actual = calculatorService.minus(1.0,2.0);
        Number expected = -1.0;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.minus(-1.5,2.5);
        expected = -4.0;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void multiplyTest(){
        Number actual = calculatorService.multiply(1.0,2.0);
        Number expected = 2.0;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.multiply(-1.5,2.5);
        expected = -3.75;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void divideTest(){
        Number actual = calculatorService.divide(1.0,2.0);
        Number expected = 0.5;
        Assertions.assertEquals(expected, actual);

        actual = calculatorService.divide(-1.5,2.5);
        expected = -0.6;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void divideNegativeTest(){
        Assertions.assertThrows(ZeroException.class, ()-> calculatorService.divide(1.0, 0.0));
        Assertions.assertThrows(ZeroException.class, ()-> calculatorService.divide(-1.0, 0.0));
    }
}
