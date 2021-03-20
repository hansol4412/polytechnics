package chapter4;

import java.util.Scanner;

public class HW1 {

	public static void main(String[] args) {
		//알파벳 -> 숫자, 숫자 -> 알파벳으로 변환하기
		Scanner stdIn = new Scanner(System.in);
			while(true) {
				System.out.println("#Menu\r\n"
						+ "1. Encoder\r\n"
						+ "2. Decoder\r\n"
						+ "3. Exit");
				System.out.print("select number:");
				int n = stdIn.nextInt();
				
				if(n==1) {
					System.out.print("input:");
					String str = stdIn.next();
					String charStr = "";
					for (int i = 0; i < str.length(); i++) {
					    char ch = str.charAt(i);
					   if(ch>=48 && ch<=57) {
						   int b = (ch+49);
						   charStr += (char)b;
					   }
					}
					System.out.println(charStr);
					
				} else if(n==2) {
					System.out.print("input:");
					String str = stdIn.next();
					String charStr = "";
					for (int i = 0; i < str.length(); i++) {
					    char ch = str.charAt(i);
					   if(ch>=97 && ch<=122) {
						   int a = (ch-49);
						   charStr += (char)a;
					   }
					}
					System.out.println(charStr);
					
				} else if(n==3) {
					break;
				} else {
					System.out.println("select wrong number!!");
				}
		}

	}
}
