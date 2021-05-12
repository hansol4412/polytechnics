package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Freewifi3 {
	///freewifi3
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		
		File k41_f = new File("C:\\Users\\sol\\Desktop\\무료와이파이정보.txt"); //파일 가져오기
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
			
			if(k41_field[8].contains("Jan")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"01"+"-01";
			} else if(k41_field[8].contains("Feb")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"02"+"-01";
			} else if(k41_field[8].contains("Mar")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"03"+"-01";
			} else if(k41_field[8].contains("Apr")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"04"+"-01";
			} else if(k41_field[8].contains("May")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"05"+"-01";
			} else if(k41_field[8].contains("Jun")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"06"+"-01";
			} else if(k41_field[8].contains("Jul")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"07"+"-01";
			} else if(k41_field[8].contains("Aug")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"08"+"-01";
			} else if(k41_field[8].contains("Sep")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"09"+"-01";
			} else if(k41_field[8].contains("Oct")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"10"+"-01";
			} else if(k41_field[8].contains("Nov")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"11"+"-01";
			} else if(k41_field[8].contains("Dec")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"12"+"-01";
			} else {
				k41_field[8] = "1900-12-31";
			}

			String k41_queryTxt; //쿼리문 문자열에 일시적 저장
			k41_queryTxt = String.format("insert into freewifi("
					+ "inst_place, inst_place_datail, inst_city, inst_country, inst_place_flag,"
					+ "service_provider, wifi_ssid, inst_date, place_addr_road, place_addr_land,"
					+ "manage_office, manage_office_phone, latitude, longtitude, write_date)"
					+ "values ("
					+ "'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
					k41_field[1], k41_field[2], k41_field[3], k41_field[4], k41_field[5], k41_field[6],
					k41_field[7], k41_field[8], k41_field[9], k41_field[10], k41_field[11], k41_field[12], k41_field[13],
					k41_field[14], k41_field[15]); //데이터를 삽입하는 쿼리문
			try {
				k41_stmt.execute(k41_queryTxt); //저장한 문자열을 이용해 쿼리를 적용한다.
				System.out.printf("%d번째 항목 Insert OK [%s]\n", k41_lineCnt, k41_queryTxt); // 쿼리 진행상황을 알기위함
			} catch(java.sql.SQLIntegrityConstraintViolationException e) {
				continue;
			}
			k41_lineCnt++; //라인 수 증가
		}
		k41_br.close(); // 문자 읽기 종료
		k41_stmt.close(); //Statement닫기
		k41_conn.close(); //Connection 연결 끊기
	}

}