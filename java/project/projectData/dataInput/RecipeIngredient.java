package dataInput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecipeIngredient {
	public static ArrayList<String> data = new ArrayList<String>();
	public static String[][] dataArray;
	public static void fileReader() throws IOException{
		
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\hanso\\OneDrive\\바탕 화면\\데이터\\레시피_재료정보.csv");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "MS949");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		
		String line;
		while((line = reader.readLine()) != null) {
			//System.out.println(line);
			data.add(line);
		}
		dataArray = new String[data.size()][];
		for(int i=0; i<data.size(); i++) {
			dataArray[i] = data.get(i).split(",");	
		}

	}
	
	public void printIngredient(String in) {
		System.out.print("재료 : ");
		for(int i=1; i<data.size(); i++) {
			if(in.equals(dataArray[i][0])) {
				System.out.print(dataArray[i][2]+"("+dataArray[i][3]+"), ");
			}
		}
		System.out.println("\n");
	}

}
