package chapter8;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Test1 {
	//무식하게 읽고 쓰기 (최한솔)
	public static void main(String[] args) {
		try { //오류가 일어 날 가능 성이 잇는 코드를 적는 부분
			//경로에 있는 파일 가져오기
			File kopo41_f = new File("C:\\Users\\sol\\Desktop\\kopo41_MyTest.txt"); 
			FileWriter kopo41_fw = new FileWriter(kopo41_f); // 파일을 쓰기위한 FileWriter클래스, 생성자에 파일명을 넣는다
			
			kopo41_fw.write("안녕 파일\n"); //파일쓰기
			kopo41_fw.write("hello 헬로\n"); //파일 쓰기
			
			kopo41_fw.close(); //파일 쓰기 종료
			
			FileReader kopo41_fr = new FileReader(kopo41_f); //파일을 읽기위한 FileReader클래스, 생성자에 파일명을 넣는다
			
			int kopo41_n = -1; //파일 초기에 아무 것도 읽을 것이 없는 상태
			char[] kopo41_ch; //character 배열로 파일을 읽는다.
			
			while(true) {
				kopo41_ch = new char[100]; // 배열 크기 초기 지정
				kopo41_n = kopo41_fr.read(kopo41_ch); //kopo41_fr을 읽어서 kopo41_ch에 넣는다.
				
				if(kopo41_n == -1) break; //n이 음수이면 읽을 게 없다는 것이므로 반복문을 나간다.
				
				for(int kopo41_i=0; kopo41_i<kopo41_n; kopo41_i++) {
					System.out.printf("%c",kopo41_ch[kopo41_i]); // 배열 kopo41_ch에 있는거 하나씩 출력
				}
			}
			
			kopo41_fr.close(); //파일 읽기 종료
			System.out.printf("\n File Read End "); //파일 읽기 종료를 알려주는 구문
			
		} catch(Exception e) { //오류가 일어났을 때 반응하는 부분
			System.out.printf("나 에러[%s]\n",e); //에러의 원인을 알려준다
		}

	}

}
