package chapter5;

import java.util.Scanner;

public class P7 {
	public static int s=0;
	public static P7_Data[] p = new P7_Data[10];
	public static void main(String[] args) {
		//점수 계산하기
		while(true) {
			Scanner std = new Scanner(System.in);
			printMenu();
			System.out.print("input number:");
			int n = std.nextInt();
			if(n==4) break;
			
			if(n==1) {
				System.out.print("input name, Korean, English, Math:");
				String str = std.next();
				String[] temp = str.split(",");
				String a = temp[0];
				int b = Integer.parseInt(temp[1]);
				int c = Integer.parseInt(temp[2]);
				int d = Integer.parseInt(temp[3]);
				p[s] = new P7_Data(a,b,c,d);
				s++;
			} else if(n==2) {
				int minK = 100;  int maxK =0;   int sumK = 0;  float avgK;
				int minE = 100;  int maxE =0;   int sumE = 0;  float avgE;
				int minM = 100;  int maxM =0;   int sumM = 0;  float avgM;
				
				//Korean
				for (int i =0; i<s; i++) {
					sumK+= p[i].korean;
					if(p[i].korean>maxK) maxK = p[i].korean;
					if(p[i].korean<minK) minK = p[i].korean;
				}
				avgK = (float)sumK/s;
				System.out.println("Korean(Avg, Min, Max) : "+avgK+", "+minK+", "+maxK+", ");
				
				//English
				for (int i =0; i<s; i++) {
					sumE+= p[i].english;
					if(p[i].english>maxE) maxE = p[i].english;
					if(p[i].english<minE) minE = p[i].english;
				}
				avgE = (float)sumE/s;
				System.out.println("english(Avg, Min, Max) : "+avgE+", "+minE+", "+maxE+", ");
				
				//Math
				for (int i =0; i<s; i++) {
					sumM+= p[i].math;
					if(p[i].math>maxM) maxM = p[i].math;
					if(p[i].math<minM) minM = p[i].math;
				}
				avgM = (float)sumM/s;
				System.out.println("Math(Avg, Min, Max) : "+avgM+", "+minM+", "+maxM+", ");
				
			} else if(n==3) {
				
				for(int i=0; i<s; i++) {
					
					System.out.println(p[i].name +" => Korean: "+p[i].korean+" English: "+p[i].english
							+" Math: " + p[i].math); 
					}
				
			}else {
					
				System.out.println("select wrong number");
			}
			
		}

	}
	
	public static void printMenu() {
		System.out.println("#Menu\r\n"
				+ "1. Input a record\r\n"
				+ "2. Make descriptive statistics\r\n"
				+ "3. Print all the records\r\n"
				+ "4. Stop the roop");
	}

}
