package chapter8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test5 {
	// 파일 훝어보고 감잡기 (최한솔)
	public static void main(String[] args) throws IOException{
		File kopo41_f = new File("C:\\Users\\sol\\Desktop\\day_data\\THTSKS010H00.dat"); 
		//경로에 있는 파일 가져오기
		BufferedReader kopo41_br = new BufferedReader(new FileReader(kopo41_f));
		//BufferedReader로 파일읽고, 생성자로 BufferedReader객체를 넣는다.
		
		String kopo41_readtxt; // 파일을 읽기 위한 변수 선언
		int kopo41_LineCnt = 0; // 데이터 갯수 알기 위한 변수 
		int kopo41_n = -1; //파일 초기에 아무 것도 읽을 것이 없는 상태
		
		StringBuffer kopo41_s = new StringBuffer(); //스트링 버퍼
		
		while(true) { // 무한 반복
			char[] kopo41_ch = new char[1000]; //character 배열로 파일을 읽는다.
			kopo41_n = kopo41_br.read(kopo41_ch); // kopo41_ch에 한줄씩 읽은 데이터 넣기
			if(kopo41_n==-1) break; //n이 음수이면 읽을 게 없다는 것이므로 반복문을 나간다.
			
			for(char kopo41_c : kopo41_ch) { //char 배열 만큼 반복
				if(kopo41_c == '\n') { // 개행 문자라면
					System.out.printf("[%s]***\n",kopo41_s.toString()); // 출력
					kopo41_s.delete(0, kopo41_s.length()); //하나 읽으면 다시 스트링 버퍼 비워주기
				} else { // 개행 문자가 아니라면
					kopo41_s.append(kopo41_c); //스트링 문자에 더하기
				}
			}
			kopo41_LineCnt++; // 읽은 갯수 처리
		}
		System.out.printf("[%s]***\n",kopo41_s.toString()); //출력
		kopo41_br.close(); //버퍼 닫기
	}

}
