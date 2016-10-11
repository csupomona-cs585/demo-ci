package edu.cpp.inclass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculatorTest {

//	@Rule
//	public Timeout timeoutRule = new Timeout(2, TimeUnit.SECONDS);
	
	private Calculator c;

	@BeforeClass
	public static void setupNetworkConnection() {
		System.out.println("BeforeClass");
	}

	private File tmpFile;
	
	@Before
	public void setupTest() {
		System.out.println("Before test!");
		c = new Calculator();
		c.setA(40);
		c.setB(50);
		tmpFile = new File("test.txt");
		FileWriter fileWrite;
		try {
			fileWrite = new FileWriter(tmpFile);
			fileWrite.write("test");
			fileWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@After
	public void cleanup() {
		System.out.println("After test!");
		tmpFile.delete();
	}

	//@Test
	public void testAdd() {		
		int sum = c.add();
		Assert.assertTrue(!tmpFile.exists());
		Assert.assertEquals("The add operation is incorrect.", 90, sum);		
	}

//	@Test(timeout = 6000)
	public void testAdd2() {
		Calculator c = new Calculator();
		int sum = c.add(40, -50);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(-10, sum);
		Assert.assertTrue(sum == -10);

		//Assert.fail("This is failed");
	}

	//	@Test
	//	public void testAdd3() {
	//		Calculator c = new Calculator();
	//		Integer sum = c.add();
	//		Assert.assertNotNull(sum);
	//	}

	@Test
	public void testGenerateRandomNumber() {
		Calculator c = new Calculator();
		Integer num = c.generateRandomNumber();
		Assert.assertNotNull(num);
		Assert.assertTrue(num != null);
	}

	@Test
	public void testDivide() {
		Calculator c = new Calculator();
		int res = c.divide(50, 5);
		Assert.assertEquals(10, res);
	}

	@Test(expected = IllegalArgumentException.class)
	@Ignore("Temporary for verification.")
	public void testDivideWithException() {
		Calculator c = new Calculator();
		int res = c.divide(50, 0);
	}

	private List<String> testData = new ArrayList<String>();
	
	@Test
	public void testDivideWithExceptionWithAssumption() {
		Assume.assumeTrue(testData.size() > 100);
		try {
			Calculator c = new Calculator();
			int res = c.divide(50, 0);
			Assert.fail("Expect to see the exception");
		} catch(Exception e) {
			Assert.assertEquals(e.getClass().getName(), IllegalArgumentException.class.getName());
		}
	}
}
