package chapter6;

import java.util.Scanner;

public class P7 {

	public static void main(String[] args) {
		// Encryption, Decryption
		String[] original = {"a","b","c","d","e","f","g","h","i","j","k","l",
				"m","n","o","p","q","r","s","t","u","v","x","y","z"};
		String[] encrypted = {"z","y","x","v","u","t","s","r","q","p","o","n","m",
				"l","k","j","i","h","g","f","e","d","c","b","a"};
		
		Scanner std = new Scanner(System.in);
		String input = std.next();
		String[] inputArr = input.split("");
		String[] output = new String[input.length()];
		
		int[] index = new int[input.length()];
		
		for (int k =0; k<input.length(); k++) {
			for(int i =0; i<original.length; i++) {
				if(inputArr[k].equals(original[i])) {
					index[k]=i;
				}
			}
		}
		
		for (int k =0; k<input.length(); k++) {
			System.out.print(encrypted[index[k]]);
		}
		System.out.println();
		//decryption
		for (int k =0; k<input.length(); k++) {
			System.out.print(original[index[k]]);
		}
		

	}

}
