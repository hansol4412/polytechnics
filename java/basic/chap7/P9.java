package chapter7;

import java.util.Scanner;
import java.util.Stack;

public class P9 {

	public static void main(String[] args) {
		// Base N Numbers (Stack)
		Stack<Integer> stk = new Stack<Integer>();
		Scanner std = new Scanner(System.in);
		try {
			System.out.print("N:");
			int n = std.nextInt();
			System.out.print("M:");
			int m = std.nextInt();
			
			while (n > 0) {
				int a = n%m;
				stk.push(a);
				n = n /m;
			}
			
			while(!stk.empty()){
				int s = stk.pop();
				System.out.print(s);
			}
		}catch(Exception e) {
			System.out.println("error");
		}
	}

}
