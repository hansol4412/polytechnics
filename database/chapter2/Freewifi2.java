package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Freewifi2 {
	//freewifi2
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		
		k41_stmt.execute("drop table freewifi;"); //테이블 삭제
		//ResultSet 필요없음 => 단지 생성만 하기 때문에 쿼리를 전달하는 Statement만 사용
		
		k41_stmt.close(); //Statement닫기
		k41_conn.close(); //Connection 연결 끊기
	}

}