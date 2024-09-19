package com.example.calculator.service;

import com.example.calculator.entity.Calculation;
import com.example.calculator.calculator.Operation;
import com.example.calculator.exceptions.CalculationNotFoundException;
import com.example.calculator.repository.CalculationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CalculationServiceTest {
    @Mock
    private CalculationRepository calculationRepository;

    @InjectMocks
    private CalculationService calculationService;

    @Test
    public void testSaveCalculation() {
        Calculation calculation = new Calculation(10.0, 5.0, Operation.SUBTRACT, 5.0);

        when(calculationRepository.save(calculation)).thenReturn(calculation);

        Calculation savedCalculation = calculationService.saveCalculation(calculation);

        assertNotNull(savedCalculation);
        assertEquals(5.0, savedCalculation.getResult());
        verify(calculationRepository, times(1)).save(calculation);
    }

    @Test
    public void testGetCalculationById_Found() {
        Calculation calculation = new Calculation(10.0, 5.0, Operation.SUBTRACT, 5.0);
        calculation.setId(1L);

        when(calculationRepository.findById(1L)).thenReturn(Optional.of(calculation));

        Calculation foundCalculation = calculationService.getCalculationById(1L);

        assertNotNull(foundCalculation);
        assertEquals(1L, foundCalculation.getId());
    }

    @Test
    public void testGetCalculationById_NotFound() {
        when(calculationRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CalculationNotFoundException.class, () -> {
            calculationService.getCalculationById(1L);
        });
    }

    @Test
    public void testDeleteCalculation() {
        when(calculationRepository.existsById(1L)).thenReturn(true);

        calculationService.deleteCalculation(1L);

        verify(calculationRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteCalculation_NotFound() {
        when(calculationRepository.existsById(1L)).thenReturn(false);

        assertThrows(CalculationNotFoundException.class, () -> {
            calculationService.deleteCalculation(1L);
        });
    }
}
