package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test6 {
	// 파일 정제 (최한솔)
	public static void main(String[] args) throws IOException{
		File kopo41_f = new File("C:\\Users\\sol\\Desktop\\day_data\\THTSKS010H00.dat"); 
		//경로에 있는 파일 가져오기
		BufferedReader kopo41_br = new BufferedReader(new FileReader(kopo41_f));
		//BufferedReader로 파일읽고, 생성자로 BufferedReader객체를 넣는다.
		
		File kopo41_f1 = new File("C:\\Users\\sol\\Desktop\\day_data\\kopo41_stockDailyPrice.csv"); 
		//경로에 있는 파일 가져오기 => 파일 만들기
		BufferedWriter kopo41_bw = new BufferedWriter(new FileWriter(kopo41_f1));
		//BufferedWriter로 파일쓰고, 생성자로 BufferedReader객체를 넣는다.
		
		String kopo41_readtxt; // 파일을 읽기 위한 변수 선언
		int kopo41_cnt=0; // 읽은 데이터 갯수 알기 위한 변수 
		int kopo41_wcnt=0; // 쓴 데이터 갯수 알기 위한 변수 
		
		while((kopo41_readtxt = kopo41_br.readLine())!= null) { 
			StringBuffer kopo41_s = new StringBuffer(); //스트링 버퍼
			String[] kopo41_field = kopo41_readtxt.split("%_%"); //구분자로 필드 구분하기
			
			if(kopo41_field.length>2 && kopo41_field[2].replace("^", "").trim().substring(0,1).equals("A")) {
				// kopo41_field의 길이가 2보다 크고 kopo41_field의 2번째 필드에서 ^을 빈칸으로 바꾸고 공백을 없애고 처음이 A일 때
				kopo41_s.append(kopo41_field[0].replace("^", "").trim());
				//kopo41_field의 0번째 필드에서 ^을 빈칸으로 바꾸고 공백을 없앤다.
				for (int kopo41_i=1; kopo41_i<kopo41_field.length; kopo41_i++) {
					kopo41_s.append(","+kopo41_field[kopo41_i].replace("^", "").trim());
					//kopo41_s에 kopo41_field[kopo41_i]을 ^을 공백으로 바꾸고 빈칸을 없앤후 더한다.
				}
				kopo41_bw.write(kopo41_s.toString()); //파일 쓰기
				kopo41_bw.newLine(); // 빈 한줄 쓰기
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
