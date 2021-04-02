package test;

import java.util.Scanner;

public class A1 {

	public static void main(String[] args) {
		//메소드 오버로딩 (정수형, 실수형 식으로 받아드려 계산하기)
		Scanner std = new Scanner(System.in);
		
		String str = std.nextLine();

		double input1;
		double input2;
		int input3;
		int input4;

		if(str.contains("*")) {
			String[] temp = str.split("\\*");
			if(temp[0].contains(".") && temp[1].contains(".")) {
				input1 = Double.parseDouble(temp[0]);
				input2 = Double.parseDouble(temp[1]);
				System.out.println(mul(input1, input2));
			} else if(temp[0].contains(".")) {
				input1 = Double.parseDouble(temp[0]);
				input3 = Integer.parseInt(temp[1]);
				System.out.println(mul(input1, input3));
			} else if(temp[1].contains(".")) {
				input3 = Integer.parseInt(temp[0]);
				input1 = Double.parseDouble(temp[1]);
				System.out.println(mul(input3, input1));
			} else {
				input3 = Integer.parseInt(temp[0]);
				input4 = Integer.parseInt(temp[1]);
				System.out.println(mul(input3, input4));
			}
			
		}

	}
	
	public static double mul(double num1, double num2) {
		return num1*num2;
	}
	
	public static double mul(int num1, double num2) {
		return num1*num2;
	}
	
	public static double mul(double num1, int num2) {
		return num1*num2;
	}

	public static int mul(int num1, int num2) {
		return num1*num2;
	}


}
