package com.example.calculatortest.controller;

import com.example.calculatortest.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CalculatorController {
    private final CalculatorService calculatorService;
    public CalculatorController (CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping(path = "/calculator")
    public String hello(){
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping("/calculator/plus")
    public String addition(@RequestParam(value = "num1") Double num1, @RequestParam(value = "num2") Double num2){
        if (num1==null||num2 ==null){
            return "Не передан параметр";
        }
        return num1 + " + " + num2 + " = " + calculatorService.plus( num1, num2);
    }

    @GetMapping("/calculator/minus")
    public String subtraction(@RequestParam(value = "num1", required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2){
        if (num1==null||num2 ==null){
            return "Не передан параметр";
        }
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }
    @GetMapping("/calculator/multiply")
    public String multiplication(@RequestParam(value = "num1", required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2){
        if (num1==null||num2 ==null){
            return "Не передан параметр";
        }
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1,num2);
    }
    @GetMapping("/calculator/divide")
    public String division(@RequestParam(value = "num1", required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2){
        if (num1==null||num2 ==null){
            return "Не передан параметр";
        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }
}
