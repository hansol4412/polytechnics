package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Test2 {
	//Buffered로 읽고 쓰기 (최한솔)
	public static void kopo41_FileWrite() throws IOException{ //파일을 쓰는 함수
		//경로에 있는 파일 가져오기
		File kopo41_f = new File("C:\\Users\\sol\\Desktop\\kopo41_MyTest.txt"); 
		//BufferedWriter로 파일쓰고, 생성자로 FileWriter객체를 넣는다.
		BufferedWriter kopo41_bw = new BufferedWriter(new FileWriter(kopo41_f));
		
		kopo41_bw.write("안녕 파일\n"); //파일쓰기
		kopo41_bw.newLine(); //한줄 띄기
		kopo41_bw.write("hello 헬로\n"); //파일 쓰기
		kopo41_bw.newLine(); //한줄 띄기
		
		kopo41_bw.close(); // 파일 쓰기 닫기
		
	}
	
	public static void kopo41_FileRead()throws IOException{ //파일을 읽는 함수
		//경로에 있는 파일 가져오기
		File kopo41_f = new File("C:\\Users\\sol\\Desktop\\kopo41_MyTest.txt"); 
		BufferedReader kopo41_br = new BufferedReader(new FileReader(kopo41_f));
		//BufferedReader로 파일읽고, 생성자로 BufferedReader객체를 넣는다.
		String kopo41_readtxt;
		
		while((kopo41_readtxt = kopo41_br.readLine())!= null) { 
			//kopo41_br.readLine()으로 파일을 한 줄씩 읽는다. 
			//더 이상 읽을 게 없으면 null을 리턴하여 반복문을 멈춘다
			System.out.printf("%s\n", kopo41_readtxt);
			//읽은 파일 출력
		}
		kopo41_br.close(); //파일 읽기 종료
	}
	public static void main(String[] args) throws IOException{
		kopo41_FileWrite(); //파일 쓰는 함수 호출
		kopo41_FileRead(); //파일 읽는 함수 호출
	}

}
