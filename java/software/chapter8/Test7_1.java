package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test7_1 {
	//삼성전자 (단축코드 A005930) 만 추출하여 A005930.csv파일을 만드시오
	public static void main(String[] args) throws IOException{
		File kopo41_f = new File("C:\\Users\\sol\\Desktop\\day_data\\kopo41_stockDailyPrice.csv"); 
		//경로에 있는 파일 가져오기
		BufferedReader kopo41_br = new BufferedReader(new FileReader(kopo41_f));
		//BufferedReader로 파일읽고, 생성자로 BufferedReader객체를 넣는다.
		
		File kopo41_f1 = new File("C:\\Users\\sol\\Desktop\\day_data\\kopo41_samsung.csv"); 
		//경로에 있는 파일 가져오기 => 파일 만들기
		BufferedWriter kopo41_bw = new BufferedWriter(new FileWriter(kopo41_f1));
		//BufferedWriter로 파일쓰고, 생성자로 BufferedReader객체를 넣는다.
	
		String kopo41_readtxt; // 파일을 읽기 위한 변수 선언
		int kopo41_cnt=0; // 읽은 데이터 갯수 알기 위한 변수 
		int kopo41_wcnt=0; // 쓴 데이터 갯수 알기 위한 변수 
		
		while((kopo41_readtxt = kopo41_br.readLine())!= null) { 
			StringBuffer kopo41_s = new StringBuffer(); //스트링 버퍼
			String[] kopo41_field = kopo41_readtxt.split(","); //구분자로 필드 구분하기
			
			if(kopo41_field[2].equals("A005930")) {
				// 두번 째 인덱스가, 종목 코드가 A005930인 데이터
				kopo41_s.append(kopo41_field[0]);
				//0번째 필드 먼저 넣기 (앞에 ','을 붙이지 않기 위해)
				for (int kopo41_i=1; kopo41_i<kopo41_field.length; kopo41_i++) {
					kopo41_s.append(","+kopo41_field[kopo41_i]);
					//앞에 ','을 붙여 필드를 구분한다.
				}
				kopo41_bw.write(kopo41_s.toString()); //파일 쓰기
				kopo41_bw.newLine(); // 한 줄 넘기기
				kopo41_wcnt++; // 쓴 갯수 더하기
				System.out.printf("write[%d][%d][%s]\n",kopo41_cnt, kopo41_wcnt,kopo41_s.toString());
			}
			kopo41_cnt++; // 읽은 갯수 더하기
		}
		kopo41_br.close(); // 읽기 끝내기
		kopo41_bw.close(); // 쓰기 끝내기
		System.out.printf("program end[%d][%d] records \n",kopo41_cnt, kopo41_wcnt);
	}

}
