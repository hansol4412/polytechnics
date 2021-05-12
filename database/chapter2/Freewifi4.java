package database;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Freewifi4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		
		double k41_lat = 37.3860521; //경도
		double k41_lng = 127.1214038; //위도
		
		String k41_queryTxt;
		
		k41_queryTxt ="select * from freewifi;";  //전체 데이터 출력하는 쿼리문
		ResultSet k41_rset = k41_stmt.executeQuery(k41_queryTxt); //쿼리문 적용하기
		
		double k41_Mindist = 1000000000; // 최소거리
		String k41_MinArea=""; //최소거리 명칭
		double k41_MindistW = 0; // 최소 거리 위도
		double k41_MindistK = 0; // 최소 거리 경도
		
		int k41_iCnt=0;
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
			
			double k41_dist= Math.sqrt(Math.pow(k41_rset.getFloat(13)-k41_lat, 2)
					+Math.pow(k41_rset.getFloat(14)-k41_lng, 2)); //거리구하기
			if(k41_Mindist>k41_dist) {
				k41_Mindist=k41_dist; // 최소거리
				k41_MinArea = k41_rset.getString(1) +" "+k41_rset.getString(2) +" ("+ k41_rset.getString(9) +")"; //최소거리 명칭
				k41_MindistW = k41_rset.getDouble(13); // 최소 거리 위도
				k41_MindistK = k41_rset.getDouble(14); // 최소 거리 경도
			}
	
		}
		
		System.out.printf("현재 지점과의 최소거리 와이파이 장소 => %s : %f   (위도 %f, 경도 %f)\n", 
				k41_MinArea, k41_Mindist,k41_MindistW,k41_MindistK); 
		
		k41_rset.close(); //ResultSet닫기
		k41_stmt.close(); //Statement닫기
		k41_conn.close(); //Connection 연결 끊기
		
	}

}
