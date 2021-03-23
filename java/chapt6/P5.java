package chapter6;

import java.util.Scanner;

public class P5 {
	public static int [][] a = new int[4][3];
	public static double[] subAvg = new double[3];
	public static int[] subMin = new int[3];
	public static int[] subMax = new int[3];
	public static double[] stuAvg = new double[4];
	public static int[] stuMin = new int[4];
	public static int[] stuMax = new int[4];
	public static void main(String[] args) {
		//과목 평균, 학생 평균
		Scanner std = new Scanner(System.in);
		for(int i=0; i<a.length; i++) {
			String str = std.nextLine();
			String[] temp = str.split(" ");
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		/*
		for(int i=0; i<a.length; i++) {
			System.out.print(i+1+" : ");
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		*/
		
		while(true) {
			System.out.print("#menu#\r\n"
					+ "1. subject statics\r\n"
					+ "2. student statics\r\n"
					+ "0. quit program\r\n"
					+ "->");
			int choice = std.nextInt();
			if(choice==0) break;
			if(choice==1) {
				while(true) {
					System.out.print("#Subject#\r\n"
							+ "1. Average\r\n"
							+ "2. Min\r\n"
							+ "3. Max\r\n"
							+ "0. back to menu\r\n"
							+ "->");
					int sub = std.nextInt();
					if(sub==0) break;
					subject(sub);
				}
				
				
			} else if(choice == 2) {
				while(true) {
					System.out.print("#Student#\r\n"
							+ "1. Average\r\n"
							+ "2. Min\r\n"
							+ "3. Max\r\n"
							+ "0. back to menu\r\n"
							+ "->");
					int stu = std.nextInt();
					if(stu==0) break;
					student(stu);
				}
			} else {
				System.out.println("select wrong menu number ");
			}
		}
	}
	
	public static void subject(int n) {
		if(n==1) {
			for (int i =0; i<3; i++) {
				for(int j= 0; j<4; j++) {
					subAvg[i] = subAvg[i] += a[j][i];
				}
				subAvg[i] = subAvg[i] /4;	
			}
			System.out.println("Average of Korean scores : "+subAvg[0]);
			System.out.println("Average of English scores : "+subAvg[1]);
			System.out.println("Average of Math scores : "+subAvg[2]);
		} else if(n==2) {
			for (int i =0; i<3; i++) {
				int min = 1000;
				for(int j= 0; j<4; j++) {
					if(min>a[j][i]) {
						min =  a[j][i];
					}
				}
				subMin[i]=min;
			}
		
			System.out.println("Min of Korean scores : "+subMin[0]);
			System.out.println("Min of English scores : "+subMin[1]);
			System.out.println("Min of Math scores : "+subMin[2]);
		} else if(n==3) {
			for (int i =0; i<3; i++) {
				int max = 0;
				for(int j= 0; j<4; j++) {
					if(max<a[j][i]) {
						max =  a[j][i];
					}
				}
				subMax[i]=max;
			}
			
			System.out.println("Max of Korean scores : "+subMax[0]);
			System.out.println("Max of English scores : "+subMax[1]);
			System.out.println("Max of Math scores : "+subMax[2]);
		} else {
			System.out.println("wrong number");
		}
	}
	
	public static void student(int n) {
		if(n==1) {
			for (int i =0; i<4; i++) {
				for(int j= 0; j<3; j++) {
					stuAvg[i] = stuAvg[i] += a[i][j];
				}
				stuAvg[i] = stuAvg[i] /3;	
			}
			System.out.println("Average of first student : "+stuAvg[0]);
			System.out.println("Average of second student : "+stuAvg[1]);
			System.out.println("Average of third student : "+stuAvg[2]);
			System.out.println("Average of forth student : "+stuAvg[3]);
		} else if(n==2) {
			for (int i =0; i<4; i++) {
				int min = 1000;
				for(int j= 0; j<3; j++) {
					if(min>a[i][j]) {
						min =  a[i][j];
					}
				}
				stuMin[i]=min;
			}
		
			System.out.println("Min of first student : "+stuMin[0]);
			System.out.println("Min of second student : "+stuMin[1]);
			System.out.println("Min of third student : "+stuMin[2]);
			System.out.println("Min of forth student : "+stuMin[3]);
		} else if(n==3) {
			for (int i =0; i<4; i++) {
				int max = 0;
				for(int j= 0; j<3; j++) {
					if(max<a[i][j]) {
						max =  a[i][j];
					}
				}
				stuMax[i]=max;
			}
			
			System.out.println("Max of first student : "+stuMax[0]);
			System.out.println("Max of second student : "+stuMax[1]);
			System.out.println("Max of third student : "+stuMax[2]);
			System.out.println("Max of forth student  : "+stuMax[3]);
		} else {
			System.out.println("wrong number");
		}
	}

}
