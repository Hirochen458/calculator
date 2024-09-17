package com.example.calculator.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Calculator {

    private final Map<Operation, OperationStrategy> operationStrategies;
    private Number currentValue;

    public Calculator(Map<Operation, OperationStrategy> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    public Number calculate(Operation op, Number num1, Number num2) {
        OperationStrategy strategy = operationStrategies.get(op);
        if (strategy == null) {
            throw new UnsupportedOperationException("Operation not supported: " + op);
        }
        return strategy.apply(num1, num2);
    }

    public Calculator start(Number initialValue) {
        this.currentValue = initialValue;
        return this;
    }

    public Calculator perform(Operation op, Number num) {
        if (this.currentValue == null) {
            throw new IllegalStateException("Calculator not started. Call start() with an initial value.");
        }
        this.currentValue = calculate(op, this.currentValue, num);
        return this; // Enable chaining
    }

    public Number getResult() {
        return this.currentValue;
    }
}