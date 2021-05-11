package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Find {
	public static PrintMenu pm = new PrintMenu();
	public static LandData ld = new LandData();
	public static Scanner std = new Scanner(System.in);
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
	private ArrayList<String> apartList = new  ArrayList<String>();
	private ArrayList<String> addressList = new  ArrayList<String>();
	private ArrayList<String> dongList = new  ArrayList<String>();
	
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
			this.price ="999999";
		} else {
			this.price = price;
		}
		
		if(family.equals("*")) {
			this.family ="99999";
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
			try {
				if(ld.getLandData()[i][0].contains(this.gu) && ld.getLandData()[i][0].contains(this.dong) && Double.parseDouble(ld.getLandData()[i][2])<=Double.parseDouble(this.price) 
						&& Double.parseDouble(ld.getLandData()[i][3])<=Double.parseDouble(this.family) 
						&& Double.parseDouble(tempDate[i])>=Double.parseDouble(this.date) 
						&& Double.parseDouble(ld.getLandData()[i][5])<=Double.parseDouble(this.bus) && Double.parseDouble(ld.getLandData()[i][6])<=Double.parseDouble(this.subway) 
						&& Double.parseDouble(ld.getLandData()[i][7])<=Double.parseDouble(this.baby) && Double.parseDouble(ld.getLandData()[i][8])<=Double.parseDouble(this.child)
						&& Double.parseDouble(ld.getLandData()[i][9])<=Double.parseDouble(this.school) && Double.parseDouble(ld.getLandData()[i][10])<=Double.parseDouble(this.mart)) {
					this.apartList.add(ld.getLandData()[i][1]);
					this.addressList.add(ld.getLandData()[i][0]);
					flag=1;
				} 
			}catch(Exception e) {
				System.out.println(i);
				break;
			}
		}
		
		
		
		String[][] dongTemp = new String[this.addressList.size()][];

		for(int i=0; i<this.addressList.size(); i++) {
			String address = this.addressList.get(i);
			dongTemp[i] = address.split(" ");
			this.dongList.add(dongTemp[i][2]);
		}
		
		
		if(flag==0) {
			System.out.println("There is no apartment you want");
		} else {
			for(int i =0; i<apartList.size(); i++) {
				System.out.println(i+1+"."+apartList.get(i)+" ("+this.dongList.get(i)+")");
			}
			while(true) {
				System.out.print("input the number you want to find information ->");
				String findApartInfo = std.next();
				if(findApartInfo=="q") break;
				pm.printLine();
				this.findApartInfo(findApartInfo);
				pm.printLine();
			}
		}
		
	}
	
	public void findApartInfo(String selectnum) {
		try {
			int num = Integer.parseInt(selectnum);
			String dong = this.dongList.get(num-1);
			String apart = this.apartList.get(num-1);
		
		
			for(int i=1; i<ld.getLandData().length; i++) {
				if(ld.getLandData()[i][0].contains(dong) && ld.getLandData()[i][1].contains(apart)) {
					System.out.println("아파트 명: " + ld.getLandData()[i][1]);
					System.out.println("평단가: " + ld.getLandData()[i][2]+"만원");
					System.out.println("세대수: " + ld.getLandData()[i][3]+"세대");
					System.out.println("사용승인일: " + ld.getLandData()[i][4]);
					if(ld.getLandData()[i][5].equals("0") || ld.getLandData()[i][5].equals("")) {
						System.out.println("버스 정류장: 1km이내에 없습니다.");
					} else {
						System.out.println("버스 정류장: " + ld.getLandData()[i][5]+"m");
					}
					
					if(ld.getLandData()[i][6].equals("0") || ld.getLandData()[i][6].equals("")) {
						System.out.println("지하철역: 1km이내에 없습니다.");
					} else {
						System.out.println("지하철역: " + ld.getLandData()[i][6]+"m");
					}
					
					if(ld.getLandData()[i][7].equals("0") || ld.getLandData()[i][7].equals("")) {
						System.out.println("어린이집: 1km이내에 없습니다.");
					} else {
						System.out.println("어린이집: " + ld.getLandData()[i][7]+"m");
					}
					
					if(ld.getLandData()[i][8].equals("0") || ld.getLandData()[i][8].equals("")) {
						System.out.println("유치원: 1km이내에 없습니다.");
					} else {
						System.out.println("유치원: " + ld.getLandData()[i][8]+"m");
					}
					
					if(ld.getLandData()[i][9].equals("0")|| ld.getLandData()[i][9].equals("")) {
						System.out.println("학교: 1km이내에 없습니다.");
					} else {
						System.out.println("학교: " + ld.getLandData()[i][9]+"m");
					}
					
					if(ld.getLandData()[i][10].equals("0")|| ld.getLandData()[i][10].equals("")) {
						System.out.println("마트: 1km이내에 없습니다.");
					} else {
						System.out.println("마트: " + ld.getLandData()[i][10]+"m");
					}
				} 
			}
		}catch(Exception e) {
			System.out.println("# Check number of the apartment #");
		}
	}
	
	
	
}