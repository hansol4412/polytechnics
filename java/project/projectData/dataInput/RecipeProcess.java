package dataInput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		/*
		for(int i=1; i<data.size(); i++) {
			for(int j=0; j<dataArray[i].length-1; j++) {
				System.out.println(dataArray[0][j] +" : "+ dataArray[i][j]);
			}
			System.out.println("------------------------------------------------------");
		}
		*/

	}
	
	public void printProcess(String pn) {
		ArrayList<String> process = new ArrayList<String>(); 
		// 과정 순서가 맞지 않아서 리스트에 넣고 정렬
		
		for(int i=1; i<data.size(); i++) {
			if(pn.equals(dataArray[i][0])) {
				process.add(dataArray[i][1]+". "+dataArray[i][2]);
			}
		}
		process.sort(null);
		
		for(int i=0; i<process.size(); i++) {
			String str = this.erase(process.get(i));
			System.out.println(str);
			//정렬된 레시피 순서 출력
		}
	}
	
	public String erase(String str) { 
		//레시피 순서에서 쌍따옴표 제거하는 함수
		String originalStr = "";
		
		Pattern pattern = Pattern.compile("[\"](.*?)[\"]");
		Matcher matcher = pattern.matcher(str);
		
		int num = str.indexOf(".", 0);
		
		if(matcher.find()) {
			originalStr =  str.substring(0, num+1)+" "+matcher.group(1);
		} else {
			originalStr = str;
		}
		
		return originalStr;
	}
}
