package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AttractionData {
	private String[][] AttractionData;

	public String[][] getAttractionData() {
		return AttractionData;
	}
	
	public void makeAttractionData() throws IOException{
		ArrayList<String> data = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("서울시명소.csv"));
		String line;
		while((line = reader.readLine()) != null) {
			data.add(line);
		}
		
		this.AttractionData = new String[data.size()][];
		
		for(int i=0; i<data.size(); i++) {
			AttractionData[i] = data.get(i).split(",");
		}
		reader.close();
	}
}