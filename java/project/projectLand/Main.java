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
				+"1. ����Ʈ�� ã��\r\n"
				+"2. �˻��������� ã��\r\n"
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
		System.out.print(("���ϴ� ���� �Է��ϼ��� (�� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String findgu = std.next();
		System.out.print(("���ϴ� ���� �Է��ϼ��� (�� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String finddong = std.next();
		System.out.print(("��ܰ� ����(����)�� �Է��ϼ��� (��ܰ� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String findprice = std.next();
		System.out.print(("���ϴ� ���� ���� �ִ��� �Է��ϼ��� (���� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String findfamily = std.next();
		System.out.print(("���ϴ� ���������� ��(yyyy)�� �Է��ϼ��� (�������� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String finddate = std.next();
		System.out.print(("���ϴ� ���������� �Ÿ�(m)�� �Է��ϼ��� (���������� �Ÿ� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String findbus = std.next();
		System.out.print(("���ϴ� ����ö�� �Ÿ�(m)�� �Է��ϼ��� (����ö�� �Ÿ� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String findsubway = std.next();
		System.out.print(("���ϴ� ����� �Ÿ�(m)�� �Է��ϼ��� (����� �Ÿ� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String findbaby = std.next();
		System.out.print(("���ϴ� ��ġ�� �Ÿ�(m)�� �Է��ϼ��� (��ġ�� �Ÿ� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String findchild = std.next();
		System.out.print(("���ϴ� �б� �Ÿ�(m)�� �Է��ϼ��� (�б� �Ÿ� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String findschool = std.next();
		System.out.print(("���ϴ� ��Ʈ �Ÿ�(m)�� �Է��ϼ��� (��Ʈ �Ÿ� ��� ������ '*'�� �Է��ϼ���.) ->"));
		String findmart = std.next();
		print.printLine();
		Find find = new Find(findgu, finddong, findprice, findfamily, finddate, findbus, findsubway, findbaby, findchild, findschool, findmart);
		find.findApartment();
		print.printDot();
		
	}
}

