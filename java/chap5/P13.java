package chapter5;

import java.util.Scanner;

public class P13 {

	public static void main(String[] args) {
		//Unit Converter
		Scanner std = new Scanner(System.in);
		while(true) {
			printMenu();
			int in = std.nextInt();
			int out = std.nextInt();
			double num = std.nextDouble();
			P13_Data converter = new P13_Data(in,out,num);
			//double a = converter.convertM(converter.input, converter.number);
			double b = converter.convertO(converter.output,  converter.convertM(converter.input, converter.number));
			System.out.println(num +name(in)+ " => " +b+name(out));
		}
	}
	public static void printMenu() {
		System.out.print("# Unit\r\n"
				+ "1. cm\r\n"
				+ "2. m\r\n"
				+ "3. mm\r\n"
				+ "4. km\r\n"
				+ "5. mile\r\n");
	}
	public static String name(int code) {
		if(code ==1) {
			return "cm";
		} else if (code==2) {
			return "m";
		} else if (code==3) {
			return "mm";
		} else if (code==4) {
			return "km";
		} else if (code==5) {
			return "mile";
		} else {
			return "No";
		}
	}
}

