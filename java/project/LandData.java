package project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class LandData {
	private String[][] landData;
	private HashSet<String> gudong;
	private HashSet<String> gu;
	private HashSet<String> dong;
	
	public String[][] getLandData() {
		return landData;
	}

	public HashSet<String> getGudong() {
		return gudong;
	}

	public HashSet<String> getGu() {
		return gu;
	}

	public HashSet<String> getDong() {
		return dong;
	}

	public void makeLandData() throws IOException{
		ArrayList<String> data = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\솔\\Desktop\\샘플데이터.csv"));
		String line;
		while((line = reader.readLine()) != null) {
			data.add(line);
		}
		
		this.landData = new String[data.size()][];
		
		for(int i=0; i<data.size(); i++) {
			this.landData[i] = data.get(i).split(",");
		}
		
		this.gudong = new HashSet<String>();
		this.gu = new HashSet<String>();
		this.dong = new HashSet<String>();
		
		String[][] address =  new String[this.landData.length][];
		for(int i=1; i<this.landData.length; i++) {
			address[i-1] = this.landData[i][0].split(" ");
		}

		for(int i=0; i<address.length-1; i++) {
			for(int j=0; j<address[i].length; j++) {
				this.gudong.add(address[i][1]+" "+address[i][2]);
				this.gu.add(address[i][1]);
				this.dong.add(address[i][2]);
			}
		}
		reader.close();
	}

}



