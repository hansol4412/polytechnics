package test;

import java.util.Scanner;

public class A2 implements CalculatorInterface{

	public static void main(String[] args) {
		//메소드 오버로딩, 메소드 오버라이딩 (정수형, 실수형 식으로 받아드려 사측연산 계산하기)
		Scanner std = new Scanner(System.in);
		
		String str = std.nextLine();
		
		String[] temp;
		double input1;
		double input2;
		int input3;
		int input4;
		A2 a = new A2();

		if((a.getOperator(str)+"").equals("+")) {
				temp = str.split("\\"+a.getOperator(str));
				if(temp[0].contains(".") && temp[1].contains(".")) {
					input1 = Double.parseDouble(temp[0]);
					input2 = Double.parseDouble(temp[1]);
					System.out.println(a.calAddition(input1, input2));
				} else if(temp[0].contains(".")) {
					input1 = Double.parseDouble(temp[0]);
					input3 = Integer.parseInt(temp[1]);
					System.out.println(a.calAddition(input1, input3));
				} else if(temp[1].contains(".")) {
					input3 = Integer.parseInt(temp[0]);
					input1 = Double.parseDouble(temp[1]);
					System.out.println(a.calAddition(input3, input1));
				} else {
					input3 = Integer.parseInt(temp[0]);
					input4 = Integer.parseInt(temp[1]);
					System.out.println(a.calAddition(input3, input4));
				}	
			}else if((a.getOperator(str)+"").equals("-")) {
				temp = str.split("\\"+a.getOperator(str));
				if(temp[0].contains(".") && temp[1].contains(".")) {
					input1 = Double.parseDouble(temp[0]);
					input2 = Double.parseDouble(temp[1]);
					System.out.println(a.calSubtraction(input1, input2));
				} else if(temp[0].contains(".")) {
					input1 = Double.parseDouble(temp[0]);
					input3 = Integer.parseInt(temp[1]);
					System.out.println(a.calSubtraction(input1, input3));
				} else if(temp[1].contains(".")) {
					input3 = Integer.parseInt(temp[0]);
					input1 = Double.parseDouble(temp[1]);
					System.out.println(a.calSubtraction(input3, input1));
				} else {
					input3 = Integer.parseInt(temp[0]);
					input4 = Integer.parseInt(temp[1]);
					System.out.println(a.calSubtraction(input3, input4));
				}	
				}else if((a.getOperator(str)+"").equals("*")) {
					temp = str.split("\\"+a.getOperator(str));
					if(temp[0].contains(".") && temp[1].contains(".")) {
						input1 = Double.parseDouble(temp[0]);
						input2 = Double.parseDouble(temp[1]);
						System.out.println(a.calMultiplication(input1, input2));
					} else if(temp[0].contains(".")) {
						input1 = Double.parseDouble(temp[0]);
						input3 = Integer.parseInt(temp[1]);
						System.out.println(a.calMultiplication(input1, input3));
					} else if(temp[1].contains(".")) {
						input3 = Integer.parseInt(temp[0]);
						input1 = Double.parseDouble(temp[1]);
						System.out.println(a.calMultiplication(input3, input1));
					} else {
						input3 = Integer.parseInt(temp[0]);
						input4 = Integer.parseInt(temp[1]);
						System.out.println(a.calMultiplication(input3, input4));
					}	
				}else if((a.getOperator(str)+"").equals("/")) {
					temp = str.split("\\"+a.getOperator(str));
					if(temp[0].contains(".") && temp[1].contains(".")) {
						input1 = Double.parseDouble(temp[0]);
						input2 = Double.parseDouble(temp[1]);
						System.out.println(a.calDivision(input1, input2));
					} else if(temp[0].contains(".")) {
						input1 = Double.parseDouble(temp[0]);
						input3 = Integer.parseInt(temp[1]);
						System.out.println(a.calDivision(input1, input3));
					} else if(temp[1].contains(".")) {
						input3 = Integer.parseInt(temp[0]);
						input1 = Double.parseDouble(temp[1]);
						System.out.println(a.calDivision(input3, input1));
					} else {
						input3 = Integer.parseInt(temp[0]);
						input4 = Integer.parseInt(temp[1]);
						System.out.println(a.calDivision(input3, input4));
					}	
				} else {
					System.out.println("wrong formula");
				} 

	}
	
	@Override
	public double calAddition(double num1, double num2) {
		return num1+num2;
	}
	
	public int calAddition(int num1, int num2) {
		return num1+num2;
	}
	
	public double calAddition(int num1, double num2) {
		return num1+num2;
	}
	
	public double calAddition(double num1, int num2) {
		return num1+num2;
	}
	
	@Override
	public double calSubtraction(double num1, double num2){
		return num1-num2;
	}
	
	public int calSubtraction(int num1, int num2) {
		return num1-num2;
	}
	
	public double calSubtraction(double num1, int num2){
		return num1-num2;
	}
	
	public double calSubtraction(int num1, double num2){
		return num1-num2;
	}
	
	@Override
	public double calMultiplication(double num1, double num2){
		return num1*num2;
	}
	
	public int calMultiplication(int num1, int num2) {
		return num1*num2;
	}
	
	public double calMultiplication(int num1, double num2){
		return num1*num2;
	}
	
	public double calMultiplication(double num1, int num2){
		return num1*num2;
	}
	
	@Override
	public double calDivision(double num1, double num2){
		return num1/num2;
	}
	
	public int calDivision(int num1, int num2) {
		return num1/num2;
	}
	
	public double calDivision(int num1, double num2){
		return num1/num2;
	}
	
	public double calDivision(double num1, int num2){
		return num1/num2;
	}
	
	@Override
	public char getOperator(String formula){
		int a;
		if(formula.contains("+")) {
			a = formula.indexOf("+");	
			return formula.charAt(a);
		} else if(formula.contains("-")) {
			a = formula.indexOf("-");	
			return formula.charAt(a);
		} else if(formula.contains("*")) {
			a = formula.indexOf("*");	
			return formula.charAt(a);
		} else if(formula.contains("/")) {
			a = formula.indexOf("/");	
			return formula.charAt(a);
		} else {
			return 0;
		}
	}
}
