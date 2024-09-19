package com.example.calculator.service;

import com.example.calculator.calculator.Calculator;
import com.example.calculator.calculator.Operation;
import com.example.calculator.controller.CalculationController;
import com.example.calculator.controller.CalculationRequest;
import com.example.calculator.entity.Calculation;
import com.example.calculator.service.CalculationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class CalculationControllerTest {
    @Mock
    private CalculationService calculationService;

    @Mock
    private Calculator calculator;

    @InjectMocks
    private CalculationController calculationController;

    @Test
    public void testCreateCalculation() {
        CalculationRequest request = new CalculationRequest();
        request.setOperand1(10.0);
        request.setOperand2(5.0);
        request.setOperation(Operation.SUBTRACT);

        when(calculator.calculate(Operation.SUBTRACT, 10.0, 5.0)).thenReturn(5.0);

        Calculation calculation = new Calculation(10.0, 5.0, Operation.SUBTRACT, 5.0);
        when(calculationService.saveCalculation(any(Calculation.class))).thenReturn(calculation);

        ResponseEntity<Calculation> response = calculationController.createCalculation(request);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(5.0, response.getBody().getResult());
    }
}
