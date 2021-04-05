package chapter9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class P3 {
	// 데이터의 연별 평균 가입건수, 최소 가입건수, 최대 가입건수
	// 데이터의 월별 평균 가입건수, 최소 가입건수, 최대 가입건수
	public static Iterator<String> iterator; 
	public static ArrayList<String> data = new ArrayList<String>(); 
	public static ArrayList<String> yearList = new ArrayList<String>(); 
	public static HashSet<String> yearData = new HashSet<String>(); 
	public static String[][] dataArray; 
	public static String[][] yearArray; 
	public static void main(String[] args) throws IOException{
		Scanner std = new Scanner(System.in); 
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sol\\Desktop\\충청남도_회원가입 월별 건수_20210129.csv"));
		String line;
		while((line = reader.readLine()) != null) {
				//System.out.println(line); 
			data.add(line);
		}

		dataArray = new String[data.size()][2]; 
		for(int i=1; i<data.size(); i++) {
			dataArray[i-1] = data.get(i).split(",");
		}
		/*
		for(int i=0; i<dataArray.length; i++) {
			System.out.println(dataArray[i][0]+""+dataArray[i][1]);
			
		}
		*/
		year(); 
		month();
	}
		public static void year() {
			
		yearArray = new String[dataArray.length][]; 
		for(int i=0; i<dataArray.length-1; i++) {
			yearArray[i] = dataArray[i][0].split("-"); 
			yearData.add(yearArray[i][1]);
		}
		
		iterator = yearData.iterator();
		
		// hashSet to arrayList for sorting 
		while(iterator.hasNext()){
			String a = iterator.next(); 
			yearList.add(a);
		}
		Collections. sort(yearList); 
		//System.out.println(yearList);
		
		ArrayList<ArrayList<Integer>> year = new ArrayList<ArrayList<Integer>>();
		for(int k=0; k<=yearList.size(); k++) {
			year.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<data.size()-1; i++) { 
			for(int j=0; j<yearList.size(); j++){ 
				if(dataArray[i][0].contains (yearList.get(j))) {
					year.get(j).add(Integer.parseInt(dataArray[i][1]));
				}
			}
		}
		
		/*
		// 회원가입 연으로 정리한 것 출력 
		for(int i=0; i<year.size(); i++) { 
			for(int j=0; j<year.get(i).size(); j++){
				System.out.print(year.get(i).get(j)+"--"); 
			}
			System.out.println();
		}
		*/
		
		avgYear(year); 
		printLine(); 
		minYear(year); 
		printLine(); 
		maxYear(year); 
		printLine();
		
		}
		
		public static void avgYear(ArrayList<ArrayList<Integer>> year) {
			for(int i=0; i<year.size()-1; i++) {
				int sum=0; 
				float avg=0; 
				for(int j=0; j<year.get(i).size(); j++) {
					sum+=year.get(i).get(j);
				}
				avg = (float) sum/year.get(i).size(); 
				System.out.printf("20%s년의 평균 가입건수는 %.2f이다.\n", yearList.get(i), avg);
			}
		}
		public static void minYear(ArrayList<ArrayList<Integer>> year) { 
			for(int i=0; i<year.size()-1; i++) {
			int min=1000; 
				for(int j=0; j<year.get(i).size(); j++ ) { 
					if(min>year.get(i).get(j)) {
						min=year.get(i).get(j);
					}
				}
				System.out.printf("20%s년의 최소 가입건수는 %d이다.\n", yearList.get(i),min);
			}
		}
			
		public static void maxYear(ArrayList<ArrayList<Integer>> year) { 
			for(int i=0; i<year.size()-1; i++) {
				int max=0; 
				for(int j=0; j<year.get(i).size(); j++) { 
					if(max<year.get(i).get(j)) {
						max=year.get(i).get(j);
					}
				}	
				System.out.printf("20%s년의 최대 가입건수는 %d이다.\n", yearList.get(i),max);
			}
		}
		
		public static void month() {
			ArrayList<ArrayList<Integer>> month = new ArrayList<ArrayList<Integer>>();
			for(int k=0; k<=13; k++) {
				month.add(new ArrayList<Integer>());
			}
			for(int i=0; i<data.size()-1; i++) { 
				if(dataArray[i][0].contains("Jan")) {
					month.get(1).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains("Feb")) {
						month.get(2).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains("Mar")) {
						month.get(3).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains("Apr")) {
						month.get(4).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains("May")) {
						month.get(5).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains("Jun")) {
						month.get(6).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains ("Jul")) {
						month.get(7).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains ("Aug")) {
						month.get(8).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains ("Sep")) {
						month.get(9).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains("Oct")) {
						month.get(10).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains("Nov")) {
						month.get(11).add(Integer.parseInt(dataArray[i][1])); 
					} else if(dataArray[i][0].contains("Dec")) {
						month.get(12).add(Integer.parseInt(dataArray[i][1]));
				}
			}
			
			avgMonth (month); 
			printLine(); 
			minMonth(month); 
			printLine(); 
			maxMonth(month); 
			printLine();
		}
		
		public static void avgMonth(ArrayList<ArrayList<Integer>> month) { 
			for(int i=1; i<month.size()-1; i++) {
				int sum=0; 
				float avg=0;
				for(int j=0; j<month.get(i).size(); j++) {
					sum+=month.get(i).get(j);
				}
				avg = (float) sum/month.get(i).size(); 
				System.out.printf("%d월의 평균 가입건수는 %.2f이다.\n", i, avg);
			}
		}
			
		public static void minMonth(ArrayList<ArrayList<Integer>> month) {
			for(int i=1; i<month.size()-1; i++) {
				int min=1000; for(int j=0; j<month.get(i).size(); j++) {
					if(min>month.get(i).get(j)) {
						min=month.get(i).get(j);	
					}
				}
				System.out.printf("%d월의 최소 가입건수는 %d이다.\n",i,min);	
			}
		}
			
		public static void maxMonth(ArrayList<ArrayList<Integer>> month) { 
			for(int i=1; i<month.size()-1; i++) {
				int max=0; 
				for(int j=0; j<month.get(i).size(); j++) { 
					if(max<month.get(i).get(j)) {
						max=month.get(i).get(j);
					}
				}
				System.out.printf("%d월의 최대 가입건수는 %d이다.\n",i,max);	
			}
		}
			
		public static void printLine() {
			System.out.println("----------------------------------------------------------");
		}


}

	