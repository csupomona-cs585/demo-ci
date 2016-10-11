package edu.cpp.inclass;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest2 {

	@Test
	public void testAdd() {
		Calculator c = new Calculator();
		int sum = c.add(40, 50);
		Assert.assertEquals("The add operation is incorrect.", 90, sum);		
	}
	
	@Test
	public void testAdd2() {
		Calculator c = new Calculator();
		int sum = c.add(40, -50);
		Assert.assertEquals(-10, sum);
		Assert.assertTrue(sum == -10);
		
		//Assert.fail("This is failed");
	}
	
	@Test
	public void testGenerateRandomNumber() {
		Calculator c = new Calculator();
		Integer num = c.generateRandomNumber();
		Assert.assertNotNull(num);
		Assert.assertTrue(num != null);
	}
}
