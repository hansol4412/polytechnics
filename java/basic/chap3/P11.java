package chapter3;

import java.util.Scanner;

public class P11 {

	public static void main(String[] args) {
		// 화폐 변환기
		Scanner stdIn = new Scanner(System.in);
		System.out.println("1. South Korean won -> United States Dollar");
		System.out.println("2. United States Dollar -> South Korean won");
		System.out.println("3. South Korean won -> Europe Euro");
		System.out.println("4. Europe Euro -> South Korean won");
		System.out.print("select number:");
		int n= stdIn.nextInt();
		System.out.print("input money:");
		int input = stdIn.nextInt();
		float rate = 0.0f;
		float exchange = 0.0f;
		switch(n){
			case 1:
				rate = 1132.40f;
				exchange = input/rate;
				System.out.println(input+" won -> " + exchange+" doller");
				break;
			case 2:
				rate = 1132.40f;
				exchange = input * rate;
				System.out.println(input+" doller -> " + exchange+" won");
				break;
			case 3:
				rate = 1347.43f;
				exchange = input/rate;
				System.out.println(input+" won -> " + exchange+" euro");
				break;
			case 4:
				rate = 1347.43f;
				exchange = input * rate;
				System.out.println(input+" euro -> " + exchange+" won");
				break;
			default:
				System.out.println("select wrong number!!");
		}
	}

}
