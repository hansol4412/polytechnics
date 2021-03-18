package chapter3;

import java.util.Scanner;

public class HW2 {

	public static void main(String[] args) {
		//학점계산기
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input number:");
		int n = stdIn.nextInt();
		float sum = 0.0f;
		for(int i =0; i<n; i++) {
			System.out.print("input grade:");
			String grade = stdIn.next();
			float score;
			if(grade.equals("A+")||grade.equals("4.5")) {
				score = 4.5f;
			} else if(grade.equals("A")||grade.equals("A0")||grade.equals("4.0")||grade.equals("4")) {
				score = 4.0f;
			} else if(grade.equals("B+")||grade.equals("3.5")) {
				score = 3.5f;
			} else if(grade.equals("B")||grade.equals("B0")||grade.equals("3.0")||grade.equals("3")) {
				score = 3.0f;
			} else if(grade.equals("C+")||grade.equals("2.5")) {
				score = 2.5f;
			} else if(grade.equals("C")||grade.equals("C0")||grade.equals("2.0")||grade.equals("2")) {
				score = 2.0f;
			} else if(grade.equals("D+")||grade.equals("1.5")) {
				score = 1.5f;
			} else if(grade.equals("D")||grade.equals("D0")||grade.equals("1.0")||grade.equals("1")) {
				score = 1.0f;
			} else {
				score = 0.0f;
			}
			sum+=score;
		}
		float average = (float)sum/n;
		System.out.println(average);
	}

}
