package chapter4;

import java.util.Scanner;

public class P6 {

	public static void main(String[] args) {
		//계산기 (리턴타입 double)
		Scanner std = new Scanner(System.in);
		System.out.print("input:");
		String equation = std.next();
		int a;
		double input1;
		double input2;
		double result;
		
		if(equation.contains("+")) {
			
			a = equation.indexOf("+");
			input1 = Double.parseDouble(equation.substring(0,a));
			input2 = Double.parseDouble(equation.substring(a+1));
			result = addition(input1, input2);
			System.out.println(input1+" + "+input2+" = " + result);
			
		} else if(equation.contains("-")) {
			
			a = equation.indexOf("-");
			input1 = Double.parseDouble(equation.substring(0,a));
			input2 = Double.parseDouble(equation.substring(a+1));
			result = subtraction(input1, input2);
			System.out.println(input1+" - "+input2+" = " + result);
			
		} else if(equation.contains("*")) {
			
			a = equation.indexOf("*");
			input1 = Double.parseDouble(equation.substring(0,a));
			input2 = Double.parseDouble(equation.substring(a+1));
			result = multiplication(input1, input2);
			System.out.println(input1+" * "+input2+" = " + result);
			
		} else if(equation.contains("/")) {
			a = equation.indexOf("/");
			input1 =Double.parseDouble(equation.substring(0,a));
			input2 = Double.parseDouble(equation.substring(a+1));
			result = division(input1, input2);
			System.out.println(input1+" / "+input2+" = " + result);
		} 
		else {
			
			System.out.println("wrong equation");
			
		}
	}
	
	public static double addition(double num1, double num2) {
		return num1 + num2;
		
	}
	
	public static double subtraction(double num1, double num2) {
		return num1 - num2;
	}
	
	public static double multiplication(double num1, double num2) {
		return num1 * num2;
	}
	
	public static double division(double num1, double num2) {
		return num1 / num2;
	}

}
