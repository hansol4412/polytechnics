package project;

import java.io.IOException;

public class Find {
	public static LandData ld = new LandData();
	
	private String gu;
	private String dong;
	private String price;
	private String family;
	private String date;
	private String bus;
	private String subway;
	private String baby;
	private String child;
	private String school;
	private String mart;
	
	public Find(String gu, String dong, String price, String family, String date, String bus, String subway,
			String baby, String child, String school, String mart) {
		if(gu.equals("*")) {
			this.gu = "";
		} else {
			this.gu = gu;
		}
		
		if(dong.equals("*")) {
			this.dong ="";
		} else {
			this.dong = dong;
		}
		
		if(price.equals("*")) {
			this.price ="99999";
		} else {
			this.price = price;
		}
		
		if(family.equals("*")) {
			this.family ="9999";
		} else {
			this.family = family;
		}
		
		if(date.equals("*")) {
			this.date ="1900";
		} else {
			this.date = date;
		}
		
		if(bus.equals("*")) {
			this.bus ="1000";
		} else {
			this.bus = bus;
		}
		
		if(subway.equals("*")) {
			this.subway ="1000";
		} else {
			this.subway = subway;
		}
		
		if(baby.equals("*")) {
			this.baby ="1000";
		} else {
			this.baby = baby;
		}
		
		if(child.equals("*")) {
			this.child ="1000";
		} else {
			this.child = child;
		}
		if(school.equals("*")) {
			this.school ="1000";
		} else {
			this.school = school;
		}
		if(mart.equals("*")) {
			this.mart ="1000";
		} else {
			this.mart = mart;
		}
	}
	
	public void findApartment() throws IOException{
		ld.makeLandData();
		String[][] temp = new String[ld.getLandData().length][];
		String[] tempDate = new String[ld.getLandData().length];
		int flag =0;

		
		for(int i=1; i<ld.getLandData().length; i++) {
			temp[i] = ld.getLandData()[i][4].split("\\.");
			tempDate[i] = temp[i][0];
		}
				
		for(int i=1; i<ld.getLandData().length; i++) {
			if(ld.getLandData()[i][0].contains(this.gu) && ld.getLandData()[i][0].contains(this.dong) && Double.parseDouble(ld.getLandData()[i][2])<=Double.parseDouble(this.price) 
					&& Double.parseDouble(ld.getLandData()[i][3])<=Double.parseDouble(this.family) && Double.parseDouble(tempDate[i])>=Double.parseDouble(this.date) 
					&& Double.parseDouble(ld.getLandData()[i][5])<=Double.parseDouble(this.bus) && Double.parseDouble(ld.getLandData()[i][6])<=Double.parseDouble(this.subway) 
					&& Double.parseDouble(ld.getLandData()[i][7])<=Double.parseDouble(this.baby) && Double.parseDouble(ld.getLandData()[i][8])<=Double.parseDouble(this.child)
					&& Double.parseDouble(ld.getLandData()[i][9])<=Double.parseDouble(this.school) && Double.parseDouble(ld.getLandData()[i][10])<=Double.parseDouble(this.mart)) {
				System.out.println(ld.getLandData()[i][1]);
				flag=1;
			} 
		}
		
		if(flag==0) {
			System.out.println("There is no apartment you want");
		}
		
	}
	
	
	
}
