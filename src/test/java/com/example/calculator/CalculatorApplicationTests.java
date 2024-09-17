package com.example.calculator;

import com.example.calculator.calculator.Calculator;
import com.example.calculator.calculator.Operation;
import com.example.calculator.calculator.OperationStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.calculator.calculator.strategies.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorApplicationTests {

	private Calculator calculator;

	@BeforeEach
	public void setup() {
		Map<Operation, OperationStrategy> strategies = new EnumMap<>(Operation.class);
		strategies.put(Operation.ADD, new AddOperation());
		strategies.put(Operation.SUBTRACT, new SubtractOperation());
		strategies.put(Operation.MULTIPLY, new MultiplyOperation());
		strategies.put(Operation.DIVIDE, new DivideOperation());
		calculator = new Calculator(strategies);
	}

	@Test
	public void testAddition() {
		Number result = calculator.calculate(Operation.ADD, 2, 3);
		assertEquals(5.0, result.doubleValue(), 0.001);
	}

	@Test
	public void testSubtraction() {
		Number result = calculator.calculate(Operation.SUBTRACT, 5, 2);
		assertEquals(3.0, result.doubleValue(), 0.001);
	}

	@Test
	public void testMultiplication() {
		Number result = calculator.calculate(Operation.MULTIPLY, 4, 2.5);
		assertEquals(10.0, result.doubleValue(), 0.001);
	}

	@Test
	public void testDivision() {
		Number result = calculator.calculate(Operation.DIVIDE, 10, 2);
		assertEquals(5.0, result.doubleValue(), 0.001);
	}

	@Test
	public void testDivisionByZero() {
		assertThrows(ArithmeticException.class, () -> {
			calculator.calculate(Operation.DIVIDE, 10, 0);
		});
	}

	@Test
	public void testUnsupportedOperation() {
		assertThrows(UnsupportedOperationException.class, () -> {
			calculator.calculate(null, 1, 1);
		});
	}

	@Test
	public void testChainingOperations() {
		Number result = calculator.start(5)
				.perform(Operation.ADD, 3)
				.perform(Operation.MULTIPLY, 2)
				.getResult();
		assertEquals(16.0, result.doubleValue(), 0.001);
	}

	@Test
	public void testChainingWithoutStart() {
		assertThrows(IllegalStateException.class, () -> {
			calculator.perform(Operation.ADD, 3);
		});
	}
}
