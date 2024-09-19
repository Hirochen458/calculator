package com.example.calculator.exceptions;

public class DivisionByZeroException extends CalculationException {
    public DivisionByZeroException() {
        super("Cannot divide by zero.");
    }
}
