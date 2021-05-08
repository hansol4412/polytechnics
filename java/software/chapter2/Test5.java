package chapter2;

import java.util.Scanner;

public class Test5 {
	// 문자열 받아드리기
	public static void main(String[] args) {
		Scanner kopo41_scanner = new Scanner(System.in); //Scanner객체를 이용해 문자를 받아드는 준비
		System.out.print("두자리 정수를 하나 입력해주세요.>"); // 압력을 알려주기 위한 출력
		
		String kopo41_input = kopo41_scanner.nextLine(); // 문자열 형태로 숫자를 받아드린다
		int kopo41_num = Integer.parseInt(kopo41_input); // 문자열 형태를 정수형으로 바꾼다.
		
		System.out.println("입력내용"+kopo41_input); // 정수로 바꾸기 전의 문자열의 형태를 받아드린다.
		System.out.printf("num=%d%n",kopo41_num ); //문자열을 정수로 바꿔 출력
		
	}

}
