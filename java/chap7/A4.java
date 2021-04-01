package test;

import java.util.HashSet;

public class A4 {

	public static void main(String[] args) {
		game();
	}
	
	
	public static void game() {
		HashSet<Integer> num = new HashSet<Integer>();
		int cnt=0;
		while(true) {
			if(num.size()==10) {
				System.out.println("Total number of trials : "+cnt);
				break;
			}
			cnt++;
			int n = (int)(Math.random()*10)+1;
			System.out.println("#"+cnt+"-"+n);
			num.add(n);		
		}
	}

}
