package chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class P4 {

	public static void main(String[] args) {
		// 두 문자 사이에 같은 알파벳이 있는가?
		Scanner std = new Scanner(System.in);
		try {
		System.out.print("word1:");
		String input1 = std.next();
		System.out.print("word2:");
		String input2 = std.next();
		String[] a1 = new String[input1.length()];
		String[] a2 = new String[input2.length()];
		
		
		String[] st1 = input1.split("");
		for(int i=0; i<st1.length; i++) {
			a1[i]=st1[i];
		}
		System.out.println("1:"+a1.length);
		
		String[] st2 = input2.split("");
		for(int i=0; i<st2.length; i++) {
			a2[i]=st2[i];
		}
		System.out.println("2:"+a2.length);
		
		int cnt1=0;
		String temp ="";
		for(int i=0; i<st1.length; i++) {
			if(temp.contains(st1[i])) continue;
			temp = temp + st1[i];
		}
		
		String[] s = temp.split("");
		
		int cnt=0;
		for(int i=0; i<s.length; i++) {
			for(int j=0; j<a2.length; j++) {
				if(s[i].equals(a2[j])) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println("3:"+cnt);
		}catch(Exception e) {
			System.out.println("error");
		}
	}

}
