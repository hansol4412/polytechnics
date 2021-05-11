package project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CriminalData {
	private String[][] criminalData;
	
	public String[][] getCriminalData() {
		return criminalData;
	}

	public void makeCriminalData() throws IOException{
		ArrayList<String> data = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\솔\\Desktop\\최근 3년 범죄건수.csv"));
		String line;
		while((line = reader.readLine()) != null) {
			data.add(line);
		}
		
		this.criminalData = new String[data.size()][];
		
		for(int i=0; i<data.size(); i++) {
			criminalData[i] = data.get(i).split(",");
		}
		
		reader.close();
	}

}
