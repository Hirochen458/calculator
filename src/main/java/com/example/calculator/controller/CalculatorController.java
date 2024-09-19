package com.example.calculator.controller;

import com.example.calculator.calculator.Calculator;
import com.example.calculator.calculator.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/calculate")
    public Number calculate(
            @RequestParam Operation operation,
            @RequestParam Double num1,
            @RequestParam Double num2) {
        return calculator.calculate(operation, num1, num2);
    }

    @PostMapping("/chain")
    public Number chainOperations(@RequestBody ChainRequest request) {
        calculator.start(request.getInitialValue());
        for (ChainOperation op : request.getOperations()) {
            calculator.perform(op.getOperation(), op.getOperand());
        }
        return calculator.getResult();
    }

}
