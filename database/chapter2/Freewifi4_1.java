package database;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Freewifi4_1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스

		String k41_queryTxt; //쿼리문을 일시적 저장하기 위한 문자열 지정
		
		k41_queryTxt ="select * from freewifi where inst_country='강남구';";  //설치 시도명이 강남구 데이터만 출력하는 쿼리문
		ResultSet k41_rset = k41_stmt.executeQuery(k41_queryTxt); //쿼리문 적용하기
		
		int k41_iCnt=0; // 데이터 수 세기
		while(k41_rset.next()) {
			System.out.printf("*(%d)*************************************\n",k41_iCnt++);
			System.out.printf("설치장소명		: %s\n",k41_rset.getString(1));
			System.out.printf("설치장소상세		: %s\n",k41_rset.getString(2));
			System.out.printf("설치시도명		: %s\n",k41_rset.getString(3));
			System.out.printf("설치시군구명		: %s\n",k41_rset.getString(4));
			System.out.printf("설치시설구분		: %s\n",k41_rset.getString(5));
			System.out.printf("서비스제공사명		: %s\n",k41_rset.getString(6));
			System.out.printf("와이파이SSID		: %s\n",k41_rset.getString(7));
			System.out.printf("설치년월		: %s\n",k41_rset.getDate(8));
			System.out.printf("소재지도로명주소	: %s\n",k41_rset.getString(9));
			System.out.printf("소재지지번주소		: %s\n",k41_rset.getString(10));
			System.out.printf("관리기관명		: %s\n",k41_rset.getString(11));
			System.out.printf("관리기관전화번호	: %s\n",k41_rset.getString(12));
			System.out.printf("위도			: %s\n",k41_rset.getDouble(13));
			System.out.printf("경도			: %s\n",k41_rset.getDouble(14));
			System.out.printf("데이터기준날짜		: %s\n",k41_rset.getDate(15));
			System.out.printf("****************************************\n");
		}

		k41_rset.close(); //ResultSet닫기
		k41_stmt.close(); //Statement닫기
		k41_conn.close(); //Connection 연결 끊기
		
	}

}
