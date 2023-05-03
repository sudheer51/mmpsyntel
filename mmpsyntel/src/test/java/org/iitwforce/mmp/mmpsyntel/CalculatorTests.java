package org.iitwforce.mmp.mmpsyntel;

import org.iitwforce.mmp.mmpsyntel.javaprograms.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTests {
	
	@Test
	public void validateAdd()
	{
	 
		int actual = Calculator.add(3, 5);
		int expected = 8 ;
		Assert.assertEquals(actual, expected);
		
	}

	@Test
	public void validateSubtract()
	{
		Calculator calc = new Calculator();
		int actual = calc.subtract(3, 5);
		int expected = 2 ;
		Assert.assertEquals(actual, expected);
		
	}

	@Test
	public void validateMultiply()
	{
		Calculator calc = new Calculator();
		int actual = calc.multiply(3, 5);
		int expected = 15 ;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void validateDivide()
	{
		Calculator calc = new Calculator();
		int actual = calc.divide(15, 5);
		int expected = 3 ;
		Assert.assertEquals(actual, expected);
	}
}
