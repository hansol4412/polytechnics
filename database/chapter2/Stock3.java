package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock3 {

	public static void main(String[] args)throws ClassNotFoundException, SQLException, IOException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		
		String k41_queryTxt = "insert into stock("
				+ "code, pdate, s_price, h_price, i_price, c_price, quantity, amount)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement k41_pstmt = k41_conn.prepareStatement(k41_queryTxt);
		
		File k41_f = new File("C:\\Users\\sol\\Desktop\\day_data\\kopo41_stockDailyPrice.csv"); //파일 가져오기
		BufferedReader k41_br = new BufferedReader(new FileReader(k41_f)); //BufferedReader로 파일 읽기

		String k41_readtxt; // 파일을 한줄씩 읽기

//		if((k41_readtxt = k41_br.readLine())==null) { //파일을 읽을게 없다면 빈파일
//			System.out.printf("빈 파일 입니다.\n");
//			return;
//		}
		
		int k41_lineCnt =0; // 파일라인 수 세기
		k41_conn.setAutoCommit(false); //오토커밋이 안되게하고
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss"); //날자 형식
		String start = format.format (System.currentTimeMillis());
		long k41_startTime = System.currentTimeMillis();
		
		while((k41_readtxt = k41_br.readLine())!=null) { //파일이 빈칸이 아닐 때까지 읽기
			String[] k41_field = k41_readtxt.split(","); // 콤마로 구분해서 라인을 나눈다.
			k41_pstmt.setString(1, k41_field[2]);
			k41_pstmt.setString(2, k41_field[1]);
			k41_pstmt.setString(3, k41_field[4]);
			k41_pstmt.setString(4, k41_field[5]);
			k41_pstmt.setString(5, k41_field[6]);
			k41_pstmt.setString(6, k41_field[3]);
			k41_pstmt.setString(7, k41_field[10]);
			k41_pstmt.setString(8, k41_field[12]);
			k41_pstmt.addBatch();
			System.out.printf("%d번째 항목 addBatch Ok\n", k41_lineCnt);
			k41_pstmt.clearParameters();
			k41_lineCnt++;
			try {
				if(k41_lineCnt%10000 == 0) {
					k41_pstmt.executeBatch();
					k41_conn.commit();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			k41_pstmt.executeBatch();
		} catch(Exception e) {
			e.printStackTrace();
		}
		k41_conn.commit();
		k41_conn.setAutoCommit(true);
		long k41_endTime = System.currentTimeMillis();
		String finish = format.format (System.currentTimeMillis());

		SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS");

		Date timeInDate = new Date(k41_endTime-k41_startTime); 
		String timeInFormat = sdf2.format(timeInDate);
		
		System.out.println("시작시간: "+start);
		System.out.println("종료시간: "+finish);		
		System.out.println("total: " + k41_lineCnt); // 총 갯수
		System.out.print("time: " + (k41_endTime-k41_startTime)); //걸린시간
		System.out.println(" (" + timeInFormat+")");
		
		k41_br.close(); // 문자 읽기 종료
		k41_pstmt.close(); //Statement닫기
		k41_conn.close(); //Connection 연결 끊기
		
	}
}
