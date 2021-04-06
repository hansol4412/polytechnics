package totaltest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TTest {
	public static ArrayList<String> data = new ArrayList<String>();
	public static String[][] dataArray;
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\솔\\Desktop\\충청북도_농가경영종합관리시스템_농가 지역별 날씨정보-날씨(원본)_20200203.csv"));
		String line;
		while((line = reader.readLine()) != null) {
			//System.out.println(line);
			data.add(line);
		}
		
		dataArray = new String[data.size()][];
		for(int i=1; i<data.size(); i++) {
			dataArray[i-1] = data.get(i).split(",");	
		}
		
		month();
	}
	
	public static void month() {
		ArrayList<ArrayList<Double>> month = new ArrayList<ArrayList<Double>>();
		
		for(int k=0; k<=13; k++) {
			month.add(new ArrayList<Double>());
		}
		
		for(int i=0; i<data.size()-1; i++) {
			if(dataArray[i][0].contains("2017-01") || dataArray[i][0].contains("2018-01-")) {
				month.get(1).add( Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-02") || dataArray[i][0].contains("2018-02")) {
				month.get(2).add(Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-03") || dataArray[i][0].contains("2018-03")) {
				month.get(3).add(Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-04") || dataArray[i][0].contains("2018-04")) {
				month.get(4).add(Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-05") || dataArray[i][0].contains("2018-05")) {
				month.get(5).add(Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-06") || dataArray[i][0].contains("2018-06")) {
				month.get(6).add(Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-07") || dataArray[i][0].contains("2018-07")) {
				month.get(7).add(Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-08") || dataArray[i][0].contains("2018-08")) {
				month.get(8).add(Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-09") || dataArray[i][0].contains("2018-09")) {
				month.get(9).add(Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-10") || dataArray[i][0].contains("2018-10")) {
				month.get(10).add(Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-11") || dataArray[i][0].contains("2018-11")) {
				month.get(11).add(Double.parseDouble(dataArray[i][4]));
			} else if(dataArray[i][0].contains("2017-12") || dataArray[i][0].contains("2018-12")) {
				month.get(12).add(Double.parseDouble(dataArray[i][4]));
			} 
		}

		avgMonth(month);
		printLine();
		minMonth(month);
		printLine();
		maxMonth(month);
		printLine();

	}
	
	public static void avgMonth(ArrayList<ArrayList<Double>> month) {
		for(int i=1; i<month.size()-1; i++) {
			double sum=0;
			double avg=0;
			for(int j=0; j<month.get(i).size(); j++ ) {
				sum+=month.get(i).get(j);
			}
			avg = sum/month.get(i).size();
			System.out.println(i+"월의 평균 기온은 "+avg+"이다.");
		}
	}
	
	public static void minMonth(ArrayList<ArrayList<Double>> month) {
		for(int i=1; i<month.size()-1; i++) {
			double min=1000;
			for(int j=0; j<month.get(i).size(); j++ ) {
				if(month.get(i).get(j)==0) continue;
				if(min>month.get(i).get(j)) {
					min=month.get(i).get(j);
				}
			}
			System.out.println(i+"월의 최소 기온은 "+min+"이다.");
		}
	}
	
	public static void maxMonth(ArrayList<ArrayList<Double>> month) {
		for(int i=1; i<month.size()-1; i++) {
			double max=0;
			for(int j=0; j<month.get(i).size(); j++ ) {
				if(max<month.get(i).get(j)) {
					max=month.get(i).get(j);
				}
			}
			System.out.println(i+"월의 최대 기온은 "+max+"이다.");
		}
	}
	
	public static void printLine() {
		System.out.println("-----------------------------------------------");
	}

}
