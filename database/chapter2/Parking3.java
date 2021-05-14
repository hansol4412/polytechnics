package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Parking3 {
	//주차장 데이터 채우기
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		
		File k41_f = new File("C:\\Users\\sol\\Desktop\\한국교통안전공단_전국공영주차장정보.txt"); //파일 가져오기
		BufferedReader k41_br = new BufferedReader(new FileReader(k41_f)); //BufferedReader로 파일 읽기
		
		String k41_readtxt; // 파일을 한줄씩 읽기
		
		if((k41_readtxt = k41_br.readLine())==null) { //파일을 읽을게 없다면 빈파일
			System.out.printf("빈 파일 입니다.\n");
			return;
		}
		String[] field_name = k41_readtxt.split("\t");
		int k41_lineCnt =0; // 파일라인 수 세기
		
		while((k41_readtxt = k41_br.readLine())!=null) { //파일이 빈칸이 아닐 때까지 읽기
			String[] k41_field = k41_readtxt.split("\t"); //tab키로 구분해서 라인을 나눈다.

			String k41_queryTxt; //쿼리문 문자열에 일시적 저장
			
			try {
			k41_queryTxt = String.format("insert into parking("
					+ "paking_code, parking_name, longtitude, latitude, paking_division,"
					+ "paking_type, addr, parking_count, parking_fee, inst_city,"
					+ "inst_country, inst_place_flag, inst_code, telephone, write_date)"
					+ "values ("
					+ "'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
					k41_field[0], k41_field[1], k41_field[2], k41_field[3], k41_field[4], k41_field[5], k41_field[6],
					k41_field[7], k41_field[8], k41_field[9], k41_field[10], k41_field[11], k41_field[12], k41_field[13], k41_field[14]); //데이터를 삽입하는 쿼리문
			
				k41_stmt.execute(k41_queryTxt); //저장한 문자열을 이용해 쿼리를 적용한다.
				System.out.printf("%d번째 항목 Insert OK [%s]\n", k41_lineCnt, k41_queryTxt); // 쿼리 진행상황을 알기위함
			} catch(java.sql.SQLIntegrityConstraintViolationException e) {
				continue;
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				continue;
			}
			k41_lineCnt++; //라인 수 증가
		}
		k41_br.close(); // 문자 읽기 종료
		k41_stmt.close(); //Statement닫기
		k41_conn.close(); //Connection 연결 끊기
	}

}