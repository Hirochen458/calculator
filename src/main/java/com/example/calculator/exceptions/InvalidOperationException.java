package com.example.calculator.exceptions;
import com.example.calculator.calculator.Operation;
public class InvalidOperationException extends CalculationException {
    public InvalidOperationException(Operation operation) {
        super("Operation not supported: " + operation);
    }
}
