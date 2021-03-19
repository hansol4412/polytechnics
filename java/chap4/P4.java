package chapter4;

import java.util.Scanner;

public class P4 {

	public static void main(String[] args) {
		// 계산기 (리턴타입 void)
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
			addition(input1, input2);
			
		}
		
		else if(equation.contains("-")) {
			a = equation.indexOf("-");
			input1 = Double.parseDouble(equation.substring(0,a));
			input2 = Double.parseDouble(equation.substring(a+1));
			subtraction(input1, input2);
			
		}
		
		else if(equation.contains("*")) {
			a = equation.indexOf("*");
			input1 = Double.parseDouble(equation.substring(0,a));
			input2 = Double.parseDouble(equation.substring(a+1));
			multiplication(input1, input2);
		}
		
		else if(equation.contains("/")) {
			a = equation.indexOf("/");
			input1 =Double.parseDouble(equation.substring(0,a));
			input2 = Double.parseDouble(equation.substring(a+1));
			division(input1, input2);
		}
		else {
			System.out.println("wrong equation");
		}
	}
	
	public static void addition(double num1, double num2) {
		double result = num1 + num2;
		System.out.println(num1+" + "+num2+" = " + result);
		
	}
	public static void subtraction(double num1, double num2) {
		double result =num1 - num2;
		System.out.println(num1+" - "+num2+" = " + result);
	}
	
	public static void multiplication(double num1, double num2) {
		double result =num1 * num2;
		System.out.println(num1+" * "+num2+" = " + result);
	}
	
	public static void division(double num1, double num2) {
		double result = num1 / num2;
		System.out.println(num1+" / "+num2+" = " + result);
	}
}
