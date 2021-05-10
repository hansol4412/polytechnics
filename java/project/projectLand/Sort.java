package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
	private ArrayList<SortData> list;
	
	public ArrayList<SortData> getList() {
		return list;
	}
	
	public static LandData ld = new LandData();
	public void sort(String dong, String s) throws IOException{
		PrintMenu print = new PrintMenu();
		this.list = new ArrayList<SortData>();
		ld.makeLandData();
		
		for(int i=1; i<ld.getLandData().length; i++) {
			if(ld.getLandData()[i][0].contains(dong)) {
				if(ld.getLandData()[i][2].contains(" ")) {
					ld.getLandData()[i][2]=ld.getLandData()[i][2].replace(" ", "");
				}
				if(ld.getLandData()[i][3].equals("")) {
					ld.getLandData()[i][3] = "0";
				}
				if(ld.getLandData()[i][6].equals("")) {
					ld.getLandData()[i][6] = "0";
				}
				list.add(new SortData(ld.getLandData()[i][1],Integer.parseInt(ld.getLandData()[i][2]),Integer.parseInt(ld.getLandData()[i][3]),Integer.parseInt(ld.getLandData()[i][6])));
			} else {
				continue;
			}
		}	
		
		Comparator<SortData> sortPrice = new Comparator<SortData>() {
            public int compare(SortData o1, SortData o2){
                return o1.getPrice() > o2.getPrice() ? 1: -1;
            }
        };
        
        Comparator<SortData> sortPriceR = new Comparator<SortData>() {
            public int compare(SortData o1, SortData o2){
                return o1.getPrice() < o2.getPrice() ? 1: -1;
            }
        };
        
        Comparator<SortData> sortFamily = new Comparator<SortData>() {
            public int compare(SortData o1, SortData o2){
                return o1.getFamily() > o2.getFamily() ? 1: -1;
            }
        };
        
        Comparator<SortData> sortFamilyR = new Comparator<SortData>() {
            public int compare(SortData o1, SortData o2){
                return o1.getFamily() < o2.getFamily() ? 1: -1;
            }
        };
        
        Comparator<SortData> sortSubway = new Comparator<SortData>() {
            public int compare(SortData o1, SortData o2){
                return o1.getSubway() > o2.getSubway() ? 1: -1;
            }
        };
        
		if(s.equals("1")) {
			Collections.sort(list, sortPrice);
		} else if(s.equals("2")) {
			Collections.sort(list, sortPriceR);
		} else if(s.equals("3")) {
			Collections.sort(list, sortFamily);
		} else if(s.equals("4")) {
			Collections.sort(list, sortFamilyR);
		} else if(s.equals("5")) {
			Collections.sort(list, sortSubway);
		} else {
			System.out.println("select wrong number");
		}
		
		for(int i=0; i<list.size(); i++) {
        	System.out.println(i+1+". "+list.get(i).getName());
        }
		
		print.printLine();

	}
	
}
