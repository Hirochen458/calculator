package com.example.calculator.service;

import com.example.calculator.entity.Calculation;
import com.example.calculator.repository.CalculationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.calculator.exceptions.CalculationNotFoundException;


import java.util.List;
import java.util.Optional;
@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;

    public CalculationService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    @Transactional
    public Calculation saveCalculation(Calculation calculation) {
        return calculationRepository.save(calculation);
    }

    @Transactional(readOnly = true)
    public List<Calculation> getAllCalculations() {
        return calculationRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Calculation getCalculationById(Long id) {
        return calculationRepository.findById(id)
                .orElseThrow(() -> new CalculationNotFoundException(id));
    }

    @Transactional
    public Calculation updateCalculation(Long id, Calculation calculation) {
        if (!calculationRepository.existsById(id)) {
            throw new CalculationNotFoundException(id);
        }
        calculation.setId(id);
        return calculationRepository.save(calculation);
    }

    @Transactional
    public void deleteCalculation(Long id) {
        if (!calculationRepository.existsById(id)) {
            throw new CalculationNotFoundException(id);
        }
        calculationRepository.deleteById(id);
    }
}
