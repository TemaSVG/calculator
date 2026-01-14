package com.calculator.Service;

import org.springframework.stereotype.Service;

import com.calculator.exception.DivisionByZeroException;

@Service
public class CalculatorService {

    public int plus (int a, int b) {
        return a + b;
    }

    public int minus (int a, int b) {
        return a - b;
    }

    public int multiply (int a, int b) {
        return a * b;
    }

    public int divide (int a, int b) {
        if (b == 0) {
            throw new DivisionByZeroException("Деление на ноль невозможно");
        }
       return a / b;
        
    }
}
