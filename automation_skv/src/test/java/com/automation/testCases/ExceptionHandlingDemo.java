package com.automation.testCases;

public class ExceptionHandlingDemo {
	
	public static void main(String[] args) {
		
		try {
			System.out.println("hello");
			int i = 1/0;
			System.out.println("completed");
		}
		catch(Exception exp) {
			System.out.println("i am inside catch block");
			System.out.println("message is : "+exp.getMessage());
			System.out.println("cause is : "+exp.getCause());
			exp.printStackTrace();
		}
	}

}
