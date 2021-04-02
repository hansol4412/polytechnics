package chapter7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P5 {

	public static void main(String[] args) {
		//Numbering(Queue)
		Queue<Integer> que = new LinkedList<Integer>();
		Scanner std = new Scanner(System.in);
		
		try {
		System.out.print("input:");
		String str = std.nextLine();
		
		System.out.print("input number:");
		int num = std.nextInt();
		
		String[] temp = str.split(" ");
		
		for(int i=0; i<temp.length; i++) {
			que.offer(Integer.parseInt(temp[i]));
		}
		
		int cnt=0;
		int n;
		while(!que.isEmpty()) {
			n=que.poll();
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
