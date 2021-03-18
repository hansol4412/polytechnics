package chapter3;

import java.util.Scanner;

public class P12 {

	public static void main(String[] args) {
		// 온도 변환기
		Scanner stdIn = new Scanner(System.in);
		System.out.println("1. Celsius -> Fahrenheit");
		System.out.println("2. Fahrenheit -> Celsius");
		System.out.print("select number:");
		int n = stdIn.nextInt();
		System.out.print("input temperature:");
		float input= stdIn.nextFloat();
		float change=0;
		
		switch(n){
		case 1:
			change = (float)(input*1.8)+32;
			System.out.println(input+" C -> "+change+"F");
			break;
		case 2:
			change = (float)((input-32)/1.8);
			System.out.println(input+" F -> "+change+"C");
			break;
		default:
			System.out.println("select wrong number!!");
		}
	}

}
