package chapter3;

import java.util.Scanner;

public class P13 {

	public static void main(String[] args) {
		//문장에서 단어 뽑기 
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input sentence:");
		String sentence = stdIn.nextLine();
		System.out.print("input word:");
		String word = stdIn.next();
		int[] a = new int[10];
		int[] b = new int[100];
		int[] c = new int[10];
		
		for(int i=0; i<word.length(); i++) {
			a[i]=word.charAt(i);
		}
		for(int i=0; i<sentence.length(); i++) {
			b[i]=sentence.charAt(i);
		}
		
		for(int i=0; i<word.length(); i++) {
			for(int j=0; j<sentence.length(); j++) {
				if(a[i]==b[j]) {
					c[i]++;
				}
			}
		}
		
		int min = 100;
		for (int i =0; i<word.length(); i++) {
			if(min>c[i]) {
				min=c[i];
			}
		}
		System.out.println(min);
	}

}
