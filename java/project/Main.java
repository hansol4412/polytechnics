package project;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static Scanner std = new Scanner(System.in);
	public static PrintMenu print = new PrintMenu();
	public static void main(String[] args) throws IOException{
		printMenu();
		String select = std.next();
		if(select.equals("1")) {
			list();
		} else if(select.equals("2")) {
			find();
		} else {
			System.out.println("Select wrong input");
		}
	}
	
	
	public static void printMenu() {
		System.out.print("# MENU\r\n"
				+"1. 리스트로 찾기\r\n"
				+"2. 검색조건으로 찾기\r\n"
				+ "->");
	}
	
	public static void list() throws IOException{
		print.printGu();
		String selectGu = std.next();
		print.printLine();
		print.printInformationGu(selectGu);
		print.printDot();
		print.printDong(selectGu);
		String selectdong = std.next();
		print.printLine();
		print.printApartment(selectdong);
		String selectapartment = std.next();
		print.printLine();
		print.printInformationApart(selectdong, selectapartment);
	}
	
	public static void find() {
		
	}
}

