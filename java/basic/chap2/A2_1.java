package test;

import java.util.Scanner;

public class A2_1 {

	public static void main(String[] args) {
		int a=6;
		System.out.println(++a);
		System.out.println(a++);
		
		Scanner std = new Scanner(System.in);
		String str = std.next();
		String[] temp = str.split("");
		
		for(int i=0; i<temp.length; i++) {
			if(Integer.parseInt(temp[i])==1) {
				System.out.print("a");
			} else if(Integer.parseInt(temp[i])==2) {
				System.out.print("b");
			} else if(Integer.parseInt(temp[i])==3) {
				System.out.print("c");
			} else if(Integer.parseInt(temp[i])==4) {
				System.out.print("d");
			} else if(Integer.parseInt(temp[i])==5) {
				System.out.print("e");
			} else if(Integer.parseInt(temp[i])==6) {
				System.out.print("f");
			} else if(Integer.parseInt(temp[i])==7) {
				System.out.print("g");
			} else if(Integer.parseInt(temp[i])==8) {
				System.out.print("h");
			} else if(Integer.parseInt(temp[i])==9) {
				System.out.print("i");
			} else if(Integer.parseInt(temp[i])==0) {
				System.out.print("j");
			}
		}

	}

}
