package kyd;

import java.util.Scanner;

public class Input {
	Scanner stdIn = null;
	
	public Input() {
		stdIn = new Scanner(System.in); //생성자
	}
	
	protected void finalize() {
		stdIn.close();
	}
	
	public int getInput() {
		System.out.print("원화를 입력하세요:");
		return stdIn.nextInt();
	}
	
	public int getChice() {
		System.out.print("환전할 종류 선택 (1: USD, 2:EUR, 3.JPY)?");
		return stdIn.nextInt();
	}
}
