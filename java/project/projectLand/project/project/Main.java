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
	
	public static void find() throws IOException{
		System.out.print(("원하는 구를 입력하세요 (구 상관 없으면 '*'을 입력하세요.) ->"));
		String findgu = std.next();
		System.out.print(("원하는 동을 입력하세요 (동 상관 없으면 '*'을 입력하세요.) ->"));
		String finddong = std.next();
		System.out.print(("평단가 예산(만원)을 입력하세요 (평단가 상관 없으면 '*'을 입력하세요.) ->"));
		String findprice = std.next();
		System.out.print(("원하는 세대 수의 최댓값을 입력하세요 (세대 상관 없으면 '*'을 입력하세요.) ->"));
		String findfamily = std.next();
		System.out.print(("원하는 사용승인일의 년(yyyy)을 입력하세요 (사용승인일 상관 없으면 '*'을 입력하세요.) ->"));
		String finddate = std.next();
		System.out.print(("원하는 버스정류장 거리(m)를 입력하세요 (버스정류장 거리 상관 없으면 '*'을 입력하세요.) ->"));
		String findbus = std.next();
		System.out.print(("원하는 지하철역 거리(m)를 입력하세요 (지하철역 거리 상관 없으면 '*'을 입력하세요.) ->"));
		String findsubway = std.next();
		System.out.print(("원하는 어린이집 거리(m)를 입력하세요 (어린이집 거리 상관 없으면 '*'을 입력하세요.) ->"));
		String findbaby = std.next();
		System.out.print(("원하는 유치원 거리(m)를 입력하세요 (유치원 거리 상관 없으면 '*'을 입력하세요.) ->"));
		String findchild = std.next();
		System.out.print(("원하는 학교 거리(m)를 입력하세요 (학교 거리 상관 없으면 '*'을 입력하세요.) ->"));
		String findschool = std.next();
		System.out.print(("원하는 마트 거리(m)를 입력하세요 (마트 거리 상관 없으면 '*'을 입력하세요.) ->"));
		String findmart = std.next();
		print.printLine();
		Find find = new Find(findgu, finddong, findprice, findfamily, finddate, findbus, findsubway, findbaby, findchild, findschool, findmart);
		find.findApartment();
		print.printDot();
		
	}
}

