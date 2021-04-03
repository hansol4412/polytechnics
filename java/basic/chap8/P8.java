package chapter8;

import java.util.Scanner;

public class P8 {
	// 컴퓨터와 가위, 바위, 보 하기
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		while(true) {
			System.out.print("r-rock, p-papper, s-scissor, q-quit\r\n->");
			String mine = std.next();
			if(mine.equals("q")) break;
			String computer = rpsResult();
			System.out.println(battle(mine, computer));
		}
	}
	
	public static String rpsResult() {
		String ret ="";
		int random = (int)(Math.random()*3);
		if(random == 0) {
			ret = "r";
		} else if(random == 1) {
			ret = "p";
		} else {
			ret = "s";
		}
		return ret;
	}
	
	public static String battle(String in1, String in2) {
		String result;
		if(in1.equals(in2)) {
			result = "draw";
		} else if(in1.equals("r") && in2.equals("s")) {
			result = "I win";
		} else if(in1.equals("p") && in2.equals("r")) {
			result = "I win";
		} else if(in1.equals("s") && in2.equals("p")) {
			result = "I win";
		} else if(in1.equals("r") && in2.equals("p")) {
			result = "Computer wins";
		} else if(in1.equals("p") && in2.equals("s")) {
			result = "Computer wins";
		} else if(in1.equals("s") && in2.equals("r")) {
			result = "Computer wins";
		} else {
			result = "I don't konw";
		}
		return result;
	}

}
