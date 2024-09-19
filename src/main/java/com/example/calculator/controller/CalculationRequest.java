package com.example.calculator.controller;

import com.example.calculator.calculator.Operation;

public class CalculationRequest {
    private Double operand1;
    private Double operand2;
    private Operation operation;

    // Getters and setters

    public Double getOperand1() {
        return operand1;
    }

    public void setOperand1(Double operand1) {
        this.operand1 = operand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public void setOperand2(Double operand2) {
        this.operand2 = operand2;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
