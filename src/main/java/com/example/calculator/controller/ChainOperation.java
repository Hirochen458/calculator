package com.example.calculator.controller;

import com.example.calculator.calculator.Operation;

public class ChainOperation {
    private Operation operation;
    private Double operand;

    // Constructors

    public ChainOperation() {
    }

    public ChainOperation(Operation operation, Double operand) {
        this.operation = operation;
        this.operand = operand;
    }

    // Getters and Setters

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Double getOperand() {
        return operand;
    }

    public void setOperand(Double operand) {
        this.operand = operand;
    }
}
