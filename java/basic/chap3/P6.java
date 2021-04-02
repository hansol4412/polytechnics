package chapter3;

import java.util.Calendar;
import java.util.Scanner;

public class P6 {

	public static void main(String[] args) {
		// 달력 출력하기
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		int month = calendar.get(Calendar.MONTH);
		System.out.println(month+1+"월");
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		
		int finish = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(int i=1; i<=finish; i++) {
			calendar.set(Calendar.DAY_OF_MONTH,i);
			int week = calendar.get(Calendar.DAY_OF_WEEK); 
			switch(week) {
				case 1:
					System.out.print(i);
					break;
				case 2:
					System.out.print("\t"+i);
					break;
				case 3:
					System.out.print("\t"+i);
					break;
				case 4:
					System.out.print("\t"+i);
					break;
				case 5:
					System.out.print("\t"+i);
					break;
				case 6:
					System.out.print("\t"+i);
					break;
				default:
					System.out.println("\t"+i);
			}
		}

		
		
		
		
		
	}

}
