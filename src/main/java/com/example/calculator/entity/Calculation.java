package com.example.calculator.entity;

import com.example.calculator.calculator.Operation;
import jakarta.persistence.*;

@Entity
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double operand1;

    private Double operand2;

    @Enumerated(EnumType.STRING)
    private Operation operation;

    private Double result;

    // Default constructor required by JPA
    public Calculation() {
    }

    // Parameterized constructor
    public Calculation(Double operand1, Double operand2, Operation operation, Double result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.result = result;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    // No setter for 'id' as it is auto-generated
    // If needed, you can uncomment the setter
     public void setId(Long id) {
         this.id = id;
     }

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

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    // Optional: Override toString() for better logging and debugging
    @Override
    public String toString() {
        return "Calculation{" +
                "id=" + id +
                ", operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operation=" + operation +
                ", result=" + result +
                '}';
    }

//    public void setId(Long id) {
//    }
}
