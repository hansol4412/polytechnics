package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sortEx {
	public static LandData ld = new LandData();
	public static void main(String[] args) throws IOException{
		ArrayList<SortData> list = new ArrayList<SortData>();
		ld.makeLandData();
		ld.getLandData();
		for(int i=1; i<ld.getLandData().length; i++) {
			list.add(new SortData(ld.getLandData()[i][1],Integer.parseInt(ld.getLandData()[i][2]),Integer.parseInt(ld.getLandData()[i][3]),Integer.parseInt(ld.getLandData()[i][6])));
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

        

        for(int i=0; i<list.size(); i++) {
        	System.out.print(list.get(i).getName()+" ");
//        	System.out.print(list.get(i).getPrice()+" ");
//        	System.out.print(list.get(i).getFamily()+" ");
//        	System.out.print(list.get(i).getSubway()+" ");
        	System.out.println();
        }
        System.out.println("============================================");
        Collections.sort(list, sortFamily);
        
        for(int i=0; i<list.size(); i++) {
        	System.out.print(list.get(i).getName()+" ");
//        	System.out.print(list.get(i).getPrice()+" ");
//        	System.out.print(list.get(i).getFamily()+" ");
//        	System.out.print(list.get(i).getSubway()+" ");
        	System.out.println();
        }

	}

}
