package com.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.calculator.exception.DivisionByZeroException;

import com.calculator.Service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("")
    public String welcomeMessage() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public ResponseEntity<String> plus(@RequestParam(required = false) Integer num1,
            @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return ResponseEntity.badRequest().body("Ошибка: параметры не переданы");
        }
        return ResponseEntity.ok(num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2));
    }

    @GetMapping("/minus")
    public ResponseEntity<String> minus(@RequestParam(required = false) Integer num1,
            @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return ResponseEntity.badRequest().body("Ошибка: параметры не переданы");
        }
        return ResponseEntity.ok(num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2));
    }

    @GetMapping("/multiply")
    public ResponseEntity<String> multiply(@RequestParam(required = false) Integer num1,
            @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return ResponseEntity.badRequest().body("Ошибка: параметры не переданы");
        }
        return ResponseEntity.ok(num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2));
    }

    @GetMapping("/divide")
    public ResponseEntity<String> divide(@RequestParam(required = false) Integer num1,
            @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return ResponseEntity.badRequest().body("Ошибка: параметры не переданы");
        }
        try {
            int result = calculatorService.divide(num1, num2);
            return ResponseEntity.ok(num1 + " / " + num2 + " = " + result);
        } catch (DivisionByZeroException e) {
            return ResponseEntity.badRequest().body("Ошибка: деление на 0");
        }
    }
}
