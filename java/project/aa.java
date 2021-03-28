package project;

import java.io.IOException;
import java.util.ArrayList;

public class aa {
	public static LandData ld = new LandData();
	public static void main(String[] args) throws IOException {
		

		
		ld.makeLandData();
		
		String[][] temp =new String[ld.getLandData().length][];

		
		for(int i=1; i<ld.getLandData().length; i++) {
			System.out.println(ld.getLandData()[i][4]);
			temp[i-1] = ld.getLandData()[i][4].split("\\.");
		}
		
		for(int i=0; i<ld.getLandData().length-1; i++) {
			System.out.println(temp[i][0]);
		}

	}

}
