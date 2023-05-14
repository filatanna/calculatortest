package com.example.calculatortest.service;

import com.example.calculatortest.exception.ZeroException;
import org.springframework.stereotype.Service;

import java.util.zip.ZipError;
import java.util.zip.ZipException;

@Service
public class CalculatorService {
    public double plus(Double num1, Double num2) {
        return num1 + num2;
    }

    public double minus(Double num1, Double num2) {
        return (int) (num1 - num2);
    }

    public double multiply(Double num1, Double num2) {
        return num1 * num2;
    }

    public double divide(Double num1, Double num2) {
         if (num2 == (double) 0) {
         throw new ZeroException();
        }
        return num1 / (double) num2;
    }
}

