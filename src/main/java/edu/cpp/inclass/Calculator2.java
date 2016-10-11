package edu.cpp.inclass;

public class Calculator2 {

	public int add(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		int counterWrong = 0;

		Calculator2 c = new Calculator2();
		int sum = c.add(50, 30);
		try {
			if (sum == 80) {
				System.out.println("Correct");
			} else {
				//System.out.println("Wrong");
				throw new RuntimeException("Test Failed!");
			}
		} catch (Exception e) {
			counterWrong++;
		}

		try {
			sum = c.add(-50, -30);
			if (sum == -80) {
				System.out.println("Correct");
			} else {
				//System.out.println("Wrong");
				throw new RuntimeException("Test Failed!");
			}	
		} catch (Exception e) {
			counterWrong++;
		}
		
		System.out.println("Total number of failed test cases: "+ counterWrong);
	}
}
