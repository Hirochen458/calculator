package com.example.calculator.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChainRequest {
    @JsonProperty("initial_value")
    private Double initialValue;

    private List<ChainOperation> operations;

    // Constructors

    public ChainRequest() {
    }

    public ChainRequest(Double initialValue, List<ChainOperation> operations) {
        this.initialValue = initialValue;
        this.operations = operations;
    }

    // Getters and Setters

    public Double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
    }

    public List<ChainOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<ChainOperation> operations) {
        this.operations = operations;
    }
}
