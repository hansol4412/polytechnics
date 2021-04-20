package chapter8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test3 {
	// 실제 파일에 응용 (최한솔)
	public static void main(String[] args) throws IOException{
		File kopo41_f = new File("C:\\Users\\sol\\Desktop\\12_04_07_E_무료와이파이정보.csv"); 
		//경로에 있는 파일 가져오기
		BufferedReader kopo41_br = new BufferedReader(new FileReader(kopo41_f));
		//BufferedReader로 파일읽고, 생성자로 BufferedReader객체를 넣는다.
		
		String kopo41_readtxt; // 파일을 읽기 위한 변수 선언
		
		if((kopo41_readtxt = kopo41_br.readLine())== null) {
			//빈 파일 일 경우
			System.out.printf("빈 파일 입니다.\n");
			return;
		}
		String[] kopo41_fieldName = kopo41_readtxt.split(",");
		//파일을 한 줄씩 읽고 ","로 구분해서 배열에 집어 넣기 (필드명)
		
		int kopo41_LineCnt = 0; // 데이터 갯수 알기 위한 변수 
		
		while((kopo41_readtxt = kopo41_br.readLine())!= null) { 
			//kopo41_br.readLine()으로 파일을 한 줄씩 읽는다. 
			//더 이상 읽을 게 없으면 null을 리턴하여 반복문을 멈춘다
			String[] kopo41_field = kopo41_readtxt.split(",");
			//파일을 한 줄씩 읽고 ","로 구분해서 배열에 집어 넣기 (내용)
			System.out.printf("**[%d번째 항목]*********************\n",kopo41_LineCnt );
			for(int kopo41_i=0; kopo41_i<kopo41_fieldName.length; kopo41_i++) {
				System.out.printf("%s : %s\n", kopo41_fieldName[kopo41_i],kopo41_field[kopo41_i]); 
				//필드 명과 필드 내용 출력
			}
			System.out.printf("*************************************\n");
			if(kopo41_LineCnt==100) break; // 데이터 갯수가 100개가 되면 반복문 빠져나가기
			kopo41_LineCnt++; // 데이터 갯수를 알기 위한 변수
		}
		kopo41_br.close(); //파일 읽기 종료
	}

}
