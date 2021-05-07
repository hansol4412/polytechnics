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
		ArrayList<String> ingredient = new ArrayList<String>(); 
		
		System.out.print("재료 : ");
		for(int i=1; i<data.size(); i++) {
			if(in.equals(dataArray[i][0])) {
				ingredient.add(dataArray[i][2]+"("+dataArray[i][3]+")");
			}
		}
		
		for(int i=0; i<ingredient.size(); i++) { //맨 마지막 항목에 콤마 제거
			if(i == (ingredient.size()-1)) {
				System.out.println(ingredient.get(i));
			} else {
				System.out.print(ingredient.get(i)+", ");
			}
		}
	}

}
