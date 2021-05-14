package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Parking {
	//parking1
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		
		//테이블 생성
		k41_stmt.execute("create table parking(" // parking table 만들기
				+ "paking_code	int not null primary key," 		// 주차장관리번호, 기본키 적용
				+ "parking_name	varchar(50)," 		// 주차장명
				+ "longtitude	double,"			// 경도
				+ "latitude		double,"			// 위도
				+ "paking_division		varchar(50),"   // 주차장구분
				+ "paking_type		varchar(50),"   // 주차장유형
				+ "addr			varchar(200),"  // 주차장지번주소
				+ "parking_count	int,"  // 주차구획수
				+ "parking_fee	varchar(50),"  // 요금정보
				+ "inst_city	varchar(50)," //관리기관명
				+ "inst_country	varchar(50)," //지역구분
				+ "inst_place_flag	varchar(50)," //지역구분_sub
				+ "inst_code		int," //지역 코드
				+ "telephone	varchar(50)," //연락처
				+ "write_date	date" //수정일자
				+ ") DEFAULT CHARSET=utf8;"); 
		//ResultSet 필요없음 => 단지 생성만 하기 때문에 쿼리를 전달하는 Statement만 사용
		
		k41_stmt.close(); //Statement닫기
		k41_conn.close(); //Connection 연결 끊기
	}
}