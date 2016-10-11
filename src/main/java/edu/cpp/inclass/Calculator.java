package edu.cpp.inclass;

import java.util.Random;
import java.util.Scanner;

public class Calculator {

	private int a;
	private int b;
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int divide(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("divider is 0!");
			//return 0;
		}
		return a / b;
	}
	
	public int add() {
		return getA() + getB();
	}
	
	public Integer generateRandomNumber() {
		Random r = new Random();
		return r.nextInt();
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}	

}
