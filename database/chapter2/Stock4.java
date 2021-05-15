package database;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss"); //날자 형식
		String start = format.format (System.currentTimeMillis());
		
		long k41_startTime = System.currentTimeMillis(); //시작시간
		String k41_queryTxt;
		
		k41_queryTxt ="select * from stock where code = 'A005930';";  //전체 데이터 출력하는 쿼리문
		ResultSet k41_rset = k41_stmt.executeQuery(k41_queryTxt); //쿼리문 적용하기
		
		int k41_iCnt=0;
		while(k41_rset.next()) {
			System.out.printf("*(%d)*************************************\n",k41_iCnt++);
			System.out.printf("단축코드	: %s\n",k41_rset.getString(1));
			System.out.printf("일자		: %s\n",k41_rset.getString(2));
			System.out.printf("시가		: %s\n",k41_rset.getInt(3));
			System.out.printf("고가		: %s\n",k41_rset.getInt(4));
			System.out.printf("저가		: %s\n",k41_rset.getInt(5));
			System.out.printf("종가		: %s\n",k41_rset.getInt(6));
			System.out.printf("거래량		: %s\n",k41_rset.getInt(7));
			System.out.printf("거래대금	: %s\n",k41_rset.getBigDecimal(8));
			System.out.printf("****************************************\n");

		}
		
		long k41_endTime = System.currentTimeMillis(); //끝시간
		String finish = format.format (System.currentTimeMillis());

		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss.SSS");

		Date timeInDate = new Date(k41_endTime-k41_startTime); 
		String timeInFormat = sdf2.format(timeInDate);

		System.out.println("시작시간: "+start);
		System.out.println("종료시간: "+finish);		
		System.out.println("total: " + k41_iCnt); // 총 갯수
		System.out.print("time: " + (k41_endTime-k41_startTime)); //걸린시간
		System.out.println(" (" + timeInFormat+")");
		
		k41_rset.close(); //ResultSet닫기
		k41_stmt.close(); //Statement닫기
		k41_conn.close(); //Connection 연결 끊기
		
	}

}
