package chapter3;

import java.util.Scanner;

public class P14 {

	public static void main(String[] args) {
		//영어 a, an 맞춤법 검사
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input:");
		String input = stdIn.nextLine();
		int position;
		if(input.contains("a ")) {
			position = input.indexOf("a ");
			if (input.substring(position+2, position+3).contains("a") || 
				input.substring(position+2, position+3).contains("o") || 
				input.substring(position+2, position+3).contains("i") ||
				input.substring(position+2, position+3).contains("u") ||
				input.substring(position+2, position+3).contains("e")) {
				System.out.println(input.substring(0,position)+"an " +input.substring(position+2));
			}
			else {
				System.out.println(input);
			}
			
		}else if(input.contains("an ")) {
			position = input.indexOf("an ");
			if (input.substring(position+3, position+4).contains("a") || 
					input.substring(position+3, position+4).contains("o") || 
					input.substring(position+3, position+4).contains("i") ||
					input.substring(position+3, position+4).contains("u") ||
					input.substring(position+3, position+4).contains("e")) {
					System.out.println(input);
				}
				else {
					System.out.println(input.substring(0,position)+"a " +input.substring(position+3));
				}
			
		}
		else {
			System.out.println("There is no 'a' or 'an'");
		}
	}

}
