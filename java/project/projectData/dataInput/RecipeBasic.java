package dataInput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeBasic {
	public static ArrayList<String> data = new ArrayList<String>();
	public static ArrayList<String> recipeName = new ArrayList<String>();
	public static String[][] dataArray;
	public static void fileReader() throws IOException{
		
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\hanso\\OneDrive\\바탕 화면\\데이터\\레시피_기본정보.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "MS949");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		
		String line;
		int cnt=0;
		
		while((line = reader.readLine()) != null) {
			//System.out.println(line);
			cnt++;
			data.add(line);
		}
		dataArray = new String[data.size()][];
		for(int i=0; i<data.size(); i++) {
			dataArray[i] = data.get(i).split("\t");	
		}
		
		/*
		for(int i=1; i<data.size(); i++) {
			for(int j=0; j<dataArray[i].length-1; j++) {
				System.out.println(dataArray[0][j] +" : "+ dataArray[i][j]);
			}
			System.out.println("------------------------------------------------------");
		}
		*/
		System.out.println("총 "+cnt+"건");
		System.out.println("------------------------------------------------------");
	}
	
	public void listPrint() {
		for(int i=1; i<data.size(); i++) {
			recipeName.add(dataArray[i][1]);
		}
		
		recipeName.sort(null);
		
		for(int i=0; i<recipeName.size(); i++) {
			System.out.println(i+1+". "+recipeName.get(i));
		}
		System.out.println("------------------------------------------------------\n");
		
	}
	
	public String findrecipe(int n) {
		String Recipenum = "";
		
		for(int i=0; i<recipeName.size(); i++) {
			if(recipeName.get(n-1).equals(dataArray[i+1][1])) {
				Recipenum = dataArray[i+1][0];
				for(int j=0; j<dataArray[i+1].length; j++) {
					System.out.println(dataArray[0][j] +" : "+ dataArray[i+1][j]);
				}
			}
		}
		
		return Recipenum;
	}
	
	

}
