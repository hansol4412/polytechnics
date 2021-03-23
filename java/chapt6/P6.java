package chapter6;

import java.util.Scanner;

public class P6 {

	public static void main(String[] args) {
		// Counting a Specified Character
		Scanner std = new Scanner(System.in);
		
		
		System.out.print("sentence:");
		String sentence = std.nextLine();
		System.out.print("word:");
		String word = std.next();
		
		char[] s = new char[sentence.length()];
		for(int i =0; i<sentence.length(); i++) {
			s[i] = sentence.charAt(i);
		}
		
		char[] w = new char[word.length()];
		for(int i =0; i<word.length(); i++) {
			w[i] = word.charAt(i);
		}
		
		int[] a = new int[word.length()];
		
		int cnt=0;
		for(int i =0; i<sentence.length(); i++) {
			for(int j =0; j<word.length(); j++) {
				if(s[i]==w[j]) {
					a[j]++;
				}
			}
		}
		
		int min=100;
		for (int i =0; i<a.length; i++) {
			if(min>a[i]) min=a[i];
		}
		
		System.out.println(min);

	}

}
