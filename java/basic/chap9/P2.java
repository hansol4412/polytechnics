package chapter9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class P2 {
	// 데이터 파일 불러와 특정 열과 행을 출력하기
	public static ArrayList<String> data = new ArrayList<String>();
	public static void main(String[] args) throws IOException{
		Scanner std = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\솔\\Desktop\\경기도 성남시_스마트도서관_현황_20210129.csv"));
		String line;
		while((line = reader.readLine()) != null) {
			//System.out.println(line);
			data.add(line);
		}
		try{
			System.out.print("input row number that you want to find:");
			int r = std.nextInt();
			System.out.print("input column number that you want to find:");
			int c = std.nextInt();
			getData(r,c);
		} catch(Exception e) {
			System.out.println("please input number, not String");
		}
	}
	public static void getData(int r, int c) {
		try {
			String[][] data1 = new String[data.size()][];
			for(int i=0; i<data.size(); i++) {
				data1[i] = data.get(i).split(",");
			}
			/*
			for(int i=0; i<data1.length; i++) {
				for(int j=0; j<data1[i].length; j++) {
					System.out.print(" "+data1[i][j]+" ");
				}
				System.out.println();
			}
			*/
			System.out.println(data1[r][c]);
		}catch(Exception e) {
			System.out.println("input number is out of array index");
		}
	}

}
