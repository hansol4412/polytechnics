package chapter3;

import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		// 대소문자 변환
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input sentence:");
		String str = stdIn.nextLine();
		
		for (int i = 0; i < str.length(); i++) {
		   char ch = str.charAt(i);
		   if(ch>=97 && ch<=122) {
			   int a = (ch-32);
			   System.out.print((char)a);
		   }
		   if(ch>=65 && ch<=90) {
			   int b = (ch+32);
			   System.out.print((char)b);
		   }
		   if(ch==32) {
			   int c = ch;
			   System.out.print((char)c);
		   }
		}
	}

}
