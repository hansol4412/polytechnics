package chapter7;
import java.io.*;
public class Test5 {
	// 파일쓰기 미리 맛보기
	public static void main(String[] args) throws Exception{
		FileWriter kopo41_fw = new FileWriter("C:\\Users\\hanso\\OneDrive\\바탕 화면\\kopo41_a.txt",true);
		// 저장하고자 하는 파일이름과 경로
		// true - > 중복시 덮어쓰기 
		BufferedWriter kopo41_bw = new BufferedWriter(kopo41_fw);
		StringBuffer kopo41_sf = new StringBuffer();
		BufferedReader kopo41_br=new BufferedReader(new InputStreamReader(System.in));
		String kopo41_str="";
		while(!(kopo41_str = kopo41_br.readLine()).startsWith("s")) {
			//s로 시작하는 문자가 나올 때까지 입력을 계속한다.
			//s로 시작하는 문자가 나오면 입력을 종료한다.
			kopo41_sf.append(kopo41_str+"\n"); //스프링 버퍼에 한 줄씩 읽어서 기록한다.
		}
		kopo41_br.close();
		kopo41_fw.write(kopo41_sf.toString()); //스프링 버퍼를 스트링 형으로 변환해 기록한다
		kopo41_fw.flush();
		kopo41_fw.close(); //자원 해제
		System.out.println("저장이 완료되었습니다.");
	}
}
