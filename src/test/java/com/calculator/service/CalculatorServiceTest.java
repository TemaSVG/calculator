package com.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculator.Service.CalculatorService;
import com.calculator.exception.DivisionByZeroException;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void testPlus1() {
        assertEquals(10, calculatorService.plus(5, 5));

    }

    @Test
    void testPlus2() {
        assertEquals(9, calculatorService.plus(5, 4));
    }

    @Test
    void testDivideByZero() {
        assertThrows(DivisionByZeroException.class, () -> calculatorService.divide(10, 0));
    }

    @Test
    void testMinus1() {
        assertEquals(1, calculatorService.minus(2, 1));
    }

    @Test
    void testMinus2() {
        assertEquals(5, calculatorService.minus(10, 5));
    }

    @Test
    void testMultiply1() {
        assertEquals(10, calculatorService.multiply(2, 5));
    }

    @Test
    void testMultiply2() {
        assertEquals(15, calculatorService.multiply(3, 5));
    }

    @Test
    void testDivide1(){
        assertEquals(3, calculatorService.divide(9, 3));
    }

    @Test
    void testDivide2(){
        assertEquals(10, calculatorService.divide(100, 10));
    }

    @ParameterizedTest
    @MethodSource("providePlusTestData")
    void testPlusParameterized(int a, int b, int expected) {
        assertEquals(expected, calculatorService.plus(a, b));
    }

    static Stream<Arguments> providePlusTestData() {
        return Stream.of(
            Arguments.of(5, 5, 10),
            Arguments.of(5, 4, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMinusTestData")
    void testMinusParameterized(int a, int b, int expected) {
        assertEquals(expected, calculatorService.minus(a, b));
    }

    static Stream<Arguments> provideMinusTestData() {
        return Stream.of(
            Arguments.of(2, 1, 1),
            Arguments.of(10, 5, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMultiplyTestData")
    void testMultiplyParameterized(int a, int b, int expected) {
        assertEquals(expected, calculatorService.multiply(a, b));
    }

    static Stream<Arguments> provideMultiplyTestData() {
        return Stream.of(
            Arguments.of(2, 5, 10),
            Arguments.of(10, 7, 70)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDivideTestData")
    void testDivideParameterized(int a, int b, int expected) {
        assertEquals(expected, calculatorService.divide(a, b));
    }

    static Stream<Arguments> provideDivideTestData() {
        return Stream.of(
            Arguments.of(9, 3, 3),
            Arguments.of(100, 10, 10)
        );
    }

}
