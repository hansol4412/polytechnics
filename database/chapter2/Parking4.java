package database;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Parking4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		
		double k41_lat = 37.3860521; //경도
		double k41_lng = 127.1214038; //위도
		
		String k41_queryTxt;
		
		k41_queryTxt ="select * from parking;";  //전체 데이터 출력하는 쿼리문
		ResultSet k41_rset = k41_stmt.executeQuery(k41_queryTxt); //쿼리문 적용하기
		
		double k41_Mindist = 1000000000; // 최소거리
		String k41_MinArea=""; //최소거리 명칭
		double k41_MindistW = 0; // 최소 거리 위도
		double k41_MindistK = 0; // 최소 거리 경도
		
		double k41_Maxdist = 0; // 최소거리
		String k41_MaxArea=""; //최소거리 명칭
		double k41_MaxdistW = 0; // 최소 거리 위도
		double k41_MaxdistK = 0; // 최소 거리 경도
		
		int k41_iCnt=0;
		while(k41_rset.next()) {
			System.out.printf("*(%d)*************************************\n",k41_iCnt++);
			System.out.printf("주차장관리번호		: %s\n",k41_rset.getInt(1));
			System.out.printf("주차장명		: %s\n",k41_rset.getString(2));
			System.out.printf("경도			: %s\n",k41_rset.getDouble(3));
			System.out.printf("위도			: %s\n",k41_rset.getDouble(4));
			System.out.printf("주차장구분		: %s\n",k41_rset.getString(5));
			System.out.printf("주차장유형		: %s\n",k41_rset.getString(6));
			System.out.printf("주차장지번주소		: %s\n",k41_rset.getString(7));
			System.out.printf("주차구획수		: %s\n",k41_rset.getInt(8));
			System.out.printf("요금정보		: %s\n",k41_rset.getString(9));
			System.out.printf("관리기관명		: %s\n",k41_rset.getString(10));
			System.out.printf("지역구분		: %s\n",k41_rset.getString(11));
			System.out.printf("지역구분_sub		: %s\n",k41_rset.getString(12));
			System.out.printf("지역 코드		: %s\n",k41_rset.getInt(13));
			System.out.printf("연락처			: %s\n",k41_rset.getString(14));
			System.out.printf("수정일자		: %s\n",k41_rset.getDate(15));
			System.out.printf("****************************************\n");
			
			double k41_dist= Math.sqrt(Math.pow(k41_rset.getDouble(4)-k41_lat, 2)
					+Math.pow(k41_rset.getDouble(3)-k41_lng, 2)); //거리구하기
			if(k41_Mindist>k41_dist) {
				k41_Mindist=k41_dist; // 최소거리
				k41_MinArea = k41_rset.getString(2) +" ("+ k41_rset.getString(7) +")"; //최소거리 명칭
				k41_MindistW = k41_rset.getDouble(4); // 최소 거리 위도
				k41_MindistK = k41_rset.getDouble(3); // 최소 거리 경도
			}
			
			if(k41_Maxdist<k41_dist) {
				k41_Maxdist=k41_dist; // 최소거리
				k41_MaxArea = k41_rset.getString(2) +" ("+ k41_rset.getString(7) +")"; //최소거리 명칭
				k41_MaxdistW = k41_rset.getDouble(4); // 최소 거리 위도
				k41_MaxdistK = k41_rset.getDouble(3); // 최소 거리 경도
			}
	
		}
		
		System.out.printf("현재 지점과의 최소거리 와이파이 장소 => %s : %f   (위도 %f, 경도 %f)\n", 
				k41_MinArea, k41_Mindist,k41_MindistW,k41_MindistK); 
		System.out.printf("현재 지점과의 최대거리 와이파이 장소 => %s : %f   (위도 %f, 경도 %f)\n", 
				k41_MaxArea, k41_Maxdist,k41_MaxdistW,k41_MaxdistK); 
		
		k41_rset.close(); //ResultSet닫기
		k41_stmt.close(); //Statement닫기
		k41_conn.close(); //Connection 연결 끊기
		
	}

}
