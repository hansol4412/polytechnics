package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test7_3 {
	//삼성전자의 주가에 대하여 2015년 최대값과 최소값을 구하시오(종가기준)
	public static void main(String[] args) throws IOException{
		File kopo41_f = new File("C:\\Users\\sol\\Desktop\\day_data\\kopo41_stockDailyPrice.csv"); 
		//경로에 있는 파일 가져오기
		BufferedReader kopo41_br = new BufferedReader(new FileReader(kopo41_f));
		//BufferedReader로 파일읽고, 생성자로 BufferedReader객체를 넣는다.
		
		String kopo41_readtxt; // 파일을 읽기 위한 변수 선언
		int kopo41_cnt=0; // 읽은 데이터 갯수 알기 위한 변수 
		int kopo41_scnt=0; // 검색해 처리한 데이터 갯수
		int kopo41_maxPrice=0;
		String kopo41_maxPriceDate="";
		
		int kopo41_minPrice=2000000;
		String kopo41_minPriceDate="";
		
		while((kopo41_readtxt = kopo41_br.readLine())!= null) { 
			StringBuffer kopo41_s = new StringBuffer(); //스트링 버퍼
			String[] kopo41_field = kopo41_readtxt.split(","); //구분자로 필드 구분하기
			
			if(kopo41_field[1].substring(0, 4).equals("2015") && kopo41_field[2].equals("A005930")) {
				// 날짜가 2015년이고 종목 코드가 A005930인 데이터
				kopo41_scnt++;
				System.out.println("종가 : "+kopo41_field[3]); //2015년도 삼성전자 종가 출력
				if(Integer.parseInt(kopo41_field[3])>kopo41_maxPrice) { //최댓값 구하기
					kopo41_maxPrice=Integer.parseInt(kopo41_field[3]);
					kopo41_maxPriceDate=kopo41_field[1];
				}
				if(Integer.parseInt(kopo41_field[3])<kopo41_minPrice) { //최솟값 구하기
					kopo41_minPrice=Integer.parseInt(kopo41_field[3]);
					kopo41_minPriceDate=kopo41_field[1];
				}
			}
			kopo41_cnt++; // 읽은 갯수 더하기
		}
		kopo41_br.close(); // 읽기 끝내기
		System.out.printf("program end[%d][%d] records \n",kopo41_cnt,kopo41_scnt);
		
		System.out.printf("2015년도 삼성전자의 최고가는 %d(%s)입니다.\n",kopo41_maxPrice,kopo41_maxPriceDate);
		System.out.printf("2015년도 삼성전자의 최저가는 %d(%s)입니다.\n",kopo41_minPrice,kopo41_minPriceDate);
	}

}
