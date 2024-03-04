package com.springboot.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorController {

    @GetMapping("/")
    public String home(){
        String welcome = "Welcome To My First Spring Boot Calculator Project.";
        return welcome;
    }

    @GetMapping("/add")
    public String add(@RequestParam("a") int a, @RequestParam("b") int b){
        int sum = a + b;
        String result = String.format("Addition : %d + %d = %d",a,b,sum);
        return result;
    }

    //Addition, subtraction, multiplication, division

    @GetMapping("/sub")
    public String sub(@RequestParam("a") int a, @RequestParam("b") int b){
        int sub = a - b;
        String result = String.format("Subtraction : %d - %d = %d",a,b,sub);
        return result;
    }

    @GetMapping("/mul")
    public String mul(@RequestParam("a") int a, @RequestParam("b") int b){
        int mul = a * b;
        String result = String.format("Multiplication : %d × %d = %d",a,b,mul);
        return result;
    }


    @GetMapping("/div")
    public String div(@RequestParam("a") int a, @RequestParam("b") int b){
        int div = a / b;
        String result = String.format("Division : %d ÷ %d = %d",a,b,div);
        return result;
    }

}
