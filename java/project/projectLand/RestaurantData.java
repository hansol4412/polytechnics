package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RestaurantData {
	private String[][] restaurantData;

	public String[][] getRestaurantData() {
		return restaurantData;
	}
	
	public void makeRestaurantData() throws IOException{
		ArrayList<String> data = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("¼­¿ï½Ã¸ÀÁý.csv"));
		String line;
		while((line = reader.readLine()) != null) {
			data.add(line);
		}
		
		this.restaurantData = new String[data.size()][];
		
		for(int i=0; i<data.size(); i++) {
			restaurantData[i] = data.get(i).split(",");
		}
		reader.close();
	}
}

