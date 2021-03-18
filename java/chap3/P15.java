package chapter3;

import java.util.Scanner;

public class P15 {

	public static void main(String[] args) {
		// 문자열에서 식 뽑기
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input:");
		String equation = stdIn.next();
		int a=0;
		int input1;
		int input2;
		int result;
		if(equation.contains("+")) {
			a = equation.indexOf("+");
			input1 = Integer.parseInt(equation.substring(0,a));
			input2 = Integer.parseInt(equation.substring(a+1));
			result = input1 + input2;
			System.out.println(input1+" + "+input2+" = " + result);
		}
		
		else if(equation.contains("-")) {
			a = equation.indexOf("-");
			input1 = Integer.parseInt(equation.substring(0,a));
			input2 = Integer.parseInt(equation.substring(a+1));
			result = input1 - input2;
			System.out.println(input1+" - "+input2+" = " + result);
		}
		
		else if(equation.contains("*")) {
			a = equation.indexOf("*");
			input1 = Integer.parseInt(equation.substring(0,a));
			input2 = Integer.parseInt(equation.substring(a+1));
			result = input1 * input2;
			System.out.println(input1+" * "+input2+" = " + result);
		}
		
		else if(equation.contains("/")) {
			a = equation.indexOf("/");
			input1 = Integer.parseInt(equation.substring(0,a));
			input2 = Integer.parseInt(equation.substring(a+1));
			result = input1 / input2;
			System.out.println(input1+" / "+input2+" = " + result);
		}
		else {
			System.out.println("wrong equation");
		}
		

	}

}
