package com.example.calculator.calculator.Operations;

import com.example.calculator.calculator.OperationStrategy;
import com.example.calculator.exceptions.DivisionByZeroException;
import org.springframework.stereotype.Component;

@Component
public class DivideOperation implements OperationStrategy {
    @Override
    public Number apply(Number num1, Number num2) {
        if (num2.doubleValue() == 0) {
            throw new DivisionByZeroException();
        }
        return num1.doubleValue() / num2.doubleValue();
    }
}
