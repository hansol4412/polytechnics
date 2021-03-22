package chapter5;

import java.util.Scanner;

public class P9 {

	public static void main(String[] args) {
		//과목 등록하기
		Scanner std = new Scanner(System.in);
		P9_Data myCource = new P9_Data("Kim",false, true, false, true, false);
		while(true) {
			printMenu();
			int menu = std.nextInt();
			if(menu==1) {
				while(true) {
					printCourseList();
					int list = std.nextInt();
					if(list ==1) {
						if(myCource.korean == true) {
							System.out.println("Korean is registered");
						} 
					} else if(list ==2) {
						if(myCource.math == true) {
							System.out.println("Math is registered");
						} 
					} else if(list ==3) {
						if(myCource.english == true) {
							System.out.println("English is registered");
						} 
					} else if(list ==4) {
						if(myCource.social_studies == true) {
							System.out.println("Social Studies is registered");
						} 
					} else if(list ==5) {
						if(myCource.science == true) {
							System.out.println("Science is registered");
						} 
					} else if(list ==0) {
						break;
					} else {
						System.out.println("select wrong list number!!");
					}
				}
			} else if(menu == 2) {
				System.out.println("MY Course");
				int num=0;
				while(true){
					if(myCource.korean == true) {
						num++;
						System.out.println(num+". Korean");
					} 
					
					if(myCource.math == true) {
						num++;
						System.out.println(num+". Math");
					} 
					
					if(myCource.english == true) {
						num++;
						System.out.println(num+". English");
					} 
					
					if(myCource.social_studies == true) {
						num++;
						System.out.println(num+". Social Studies");
					} 
					
					if(myCource.science == true) {
						num++;
						System.out.println(num+". Science");
					} 
					System.out.println("- End -");
					break;
				}
			} else if(menu == 0) {
				break;
			}else {
				System.out.println("select wrong menu number!!");
			} 
		}

	}
	
	public static void printMenu(){
		System.out.print("▸ Menu\r\n"
				+ "1. Course List\r\n"
				+ "2. My Course\r\n"
				+ "0. quit the program\r\n"
				+ "->");
	}
	
	public static void printCourseList() {
		System.out.print(" Course List\r\n"
				+ "1. Korean\r\n"
				+ "2. Math\r\n"
				+ "3. English\r\n"
				+ "4. Social Studies\r\n"
				+ "5. Science\r\n"
				+ "0. Back to Main\r\n"
				+ "->");
	}
	

}
