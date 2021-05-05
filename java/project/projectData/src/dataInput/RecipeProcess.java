package dataInput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecipeProcess {
	public static ArrayList<String> data = new ArrayList<String>();
	public static String[][] dataArray;
	public static void fileReader() throws IOException{
		
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\hanso\\OneDrive\\바탕 화면\\데이터\\레시피_과정정보.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "MS949");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		
		String line;
		while((line = reader.readLine()) != null) {
			//System.out.println(line);
			data.add(line);
		}
		dataArray = new String[data.size()][];
		for(int i=0; i<data.size(); i++) {
			dataArray[i] = data.get(i).split("\t");	
		}
		
		for(int i=1; i<data.size(); i++) {
			for(int j=0; j<dataArray[i].length-1; j++) {
				System.out.println(dataArray[0][j] +" : "+ dataArray[i][j]);
			}
			System.out.println("------------------------------------------------------");
		}

	}
}
