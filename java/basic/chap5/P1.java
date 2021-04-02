package chapter5;

import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		// 생성자로 가격 입력받고 출력하기
		Scanner stdIn = new Scanner(System.in);
		while(true) {
			print();
			System.out.print("input number:");
			int n = stdIn.nextInt();
			if(n==5) break;
			get(n);
			System.out.println();
		}
		
	}
	
	public static void print() {
		System.out.println("1. Apple\r\n"
				+ "2. Strawberry\r\n"
				+ "3. Grape\r\n"
				+ "4. Watermelon\r\n"
				+ "5. quit program");
	}
	
	public static void get(int n) {
		P1_Data p1= new P1_Data(1000, 3000, 1000, 8000); //input each price of fruits 
		
		switch(n) {
		case 1:
			System.out.println(p1.applePrice()+"won");
			break;
		case 2:
			System.out.println(p1.strawberryPrice()+"won");
			break;
		case 3:
			System.out.println(p1.grapePrice()+"won");
			break;
		case 4:
			System.out.println(p1.watermelonPrice()+"won");
			break;
		default: 
			System.out.println("select wrong number");
		}
	}

}
