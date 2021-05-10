package project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class LandData {
	private String[][] landData;
	private HashSet<String> gudong;
	private HashSet<String> gu;
	private HashSet<String> dong;
	private ArrayList<String> gudongA;
	private ArrayList<String> guA;
	private ArrayList<String> dongA;

	public String[][] getLandData() {
		return landData;
	}
	public ArrayList<String> getGudongA() {
		return gudongA;
	}

	public ArrayList<String> getGuA() {
		return guA;
	}

	public ArrayList<String> getDongA() {
		return dongA;
	}

	public void makeLandData() throws IOException{
		ArrayList<String> data = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("프로젝트 데이터.csv"));
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
				this.gudong.add(address[i][1]+" "+address[i][2]);
				this.gu.add(address[i][1]);
				this.dong.add(address[i][2]);
		}
		/*
		for(int i=1; i<landData.length-1; i++) {
			if(landData[i][2].contains(" ")) {
				landData[i][2]=landData[i][2].replace(" ", "");
			}
			if(landData[i][2].equals("")) {
				landData[i][2] = "0";
			}
			if(landData[i][3].equals("")) {
				landData[i][3] = "0";
			}
			if(landData[i][5].equals("")) {
				landData[i][5] = "0";
			}
			if(landData[i][6].equals("")) {
				landData[i][6] = "0";
			}
			if(landData[i][7].equals("")) {
				landData[i][7] = "0";
			}
			if(landData[i][8].equals("")) {
				landData[i][8] = "0";
			}
			if(landData[i][9].equals("")) {
				landData[i][9] = "0";
			}
			if(landData[i][10].equals("")) {
				landData[i][10] = "0";
			}
		}
	*/
	
		
		
		// hashSet to arrayList
		this.gudongA = new ArrayList<String>(this.gudong);
		Collections.sort(this.gudongA);
		
		this.guA = new ArrayList<String>(this.gu);
		Collections.sort(this.guA);
		
		this.dongA = new ArrayList<String>(this.dong);
		Collections.sort(this.dongA);
		
		reader.close();
	}

}



