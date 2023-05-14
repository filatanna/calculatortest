package com.example.calculatortest.service;

import com.example.calculatortest.exception.ZeroException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceParametrTest {
    private final CalculatorService calculatorService = new CalculatorService();
    public static Stream <Arguments> plusTestParams(){
        return Stream.of(
                Arguments.of(1.5, 2.5, 4.0),
                Arguments.of(-1.5, 2.5, 1.0),
                Arguments.of(0.0, 0.0, 0.0)
        );
    }
    public static Stream <Arguments> minusTestParams(){
        return Stream.of(
                Arguments.of(1.5, 2.5, -1.0),
                Arguments.of(-1.5, 2.5, -4.0),
                Arguments.of(0.0, 0.0, 0.0)
        );
    }
    public static Stream <Arguments> multiplyTestParams(){
        return Stream.of(
                Arguments.of(1.5, 2.5, 3.75),
                Arguments.of(-1.5, 2.5, -3.75),
                Arguments.of(0.0, 0.0, 0.0)
        );
    }
    public static Stream <Arguments> divideTestParams(){
        return Stream.of(
                Arguments.of(1.5, 2.5, 0.6),
                Arguments.of(-1.5, 2.5, -0.6),
                Arguments.of(0.0, 0.1, 0.0)
        );
    }
    public static Stream <Arguments> divideNegativeTestParams(){
        return Stream.of(
                Arguments.of(1.0, 0.0 ),
                Arguments.of(-1.0, 0.0 )
        );
    }
    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void plusTest(double num1, double num2, double expected){
        Assertions.assertThat(calculatorService.plus(num1, num2))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void minusTest(double num1, double num2, double expected){
        Assertions.assertThat(calculatorService.minus(num1, num2))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void multiplyTest(double num1, double num2, double expected){
        Assertions.assertThat(calculatorService.multiply(num1, num2))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void divideTest(double num1, double num2, double expected){
        Assertions.assertThat(calculatorService.divide(num1, num2))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("divideNegativeTestParams")
    public void divideNegativeTest(double num1, double num2){
        Assertions.assertThatExceptionOfType(ZeroException.class);
    }
}
