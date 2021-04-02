package chapter7;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class P6 {

	public static void main(String[] args) {
		//Numbering(Stack)
		Stack<Integer> stk = new Stack<Integer>();
		Scanner std = new Scanner(System.in);
		try {
			System.out.print("input:");
			String str = std.nextLine();
			
			System.out.print("input number:");
			int num = std.nextInt();
			
			String[] temp = str.split(" ");
			
			for(int i=0; i<temp.length; i++) {
				stk.push(Integer.parseInt(temp[i]));
			}
			
			int cnt=0;
			int n;
			while(!stk.empty()) {
				n=stk.pop();
				cnt++;
				if(n==num) {
					break;
				}
			}
			System.out.println(cnt);
		} catch(Exception e) {
			System.out.println("error");
		}
	}

}
