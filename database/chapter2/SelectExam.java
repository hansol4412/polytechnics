package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExam {
	//examtable4
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		ResultSet k41_rset = k41_stmt.executeQuery("select * from examtable1;");  //sql문 실행한 결과를 ResultSet에 넣기
		
		System.out.printf("  이름   학번   국어 영어 수학 \n");
		while(k41_rset.next()) {
			System.out.printf("%4s  %6d  %3d  %3d  %3d  \n",
					k41_rset.getString(1),k41_rset.getInt(2),k41_rset.getInt(3),k41_rset.getInt(4),k41_rset.getInt(5));
			//ResultSet의 결과를 컬럼값 하나씩 정해서 출력하기
		}
		
		k41_rset.close(); //ResultSet닫기
		k41_stmt.close();//Statement닫기
		k41_conn.close(); //Connection 연결 끊기
	}

}
