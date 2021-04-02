package chapter5;

import java.util.Scanner;

public class P12 {

	public static void main(String[] args) {
		// Finding the Nearest Number
		Scanner std = new Scanner(System.in);
		String input = std.nextLine();
		String[] list = input.split(" ");
		float number = std.nextFloat();
		float numberA = absoluteValue(number);
		float min = 1000;
		float minG = 1000;
		for(int i=0; i<list.length; i++) {
			float a = Float.parseFloat(list[i]);
			float b = absoluteValue(a);
			float gap = gap(numberA, b);
			if(gap==0.0f) continue;
			if(gap<minG) {
				minG = gap;
				min = a;
			}
		}
		System.out.println(min);
	}
	
	public static float absoluteValue(float num) {
		if(num<0) {
			return num*(-1);
		} else{
			return num;
		}
	}
	
	public static float gap(float number, float b) {
		return absoluteValue(b-number);
	}

}
