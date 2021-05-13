package database;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Grade4 {

	public static int kopo41_pageNum =1; //페이지 번호
	public static Connection k41_conn;
	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		
		Statement k41_stmt = k41_conn.createStatement(); 
		
		int kopo41_iPerson_page = 30; //페이지당 저장소의 크기
		int kopo41_iPerson = 1000; //전체 저장소의 크기
		
		String k41_queryTxt;

		k41_queryTxt ="select *, kor+eng+mat, (kor+eng+mat)/3 from grade;";  //설치 시도명이 강남구 데이터만 출력하는 쿼리문
		ResultSet k41_rset = k41_stmt.executeQuery(k41_queryTxt); //쿼리문 적용하기
		
		for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) {
			//출력
			if((kopo41_i)%kopo41_iPerson_page==0) { //30줄 마다
				kopo41_HeaderPrint();
				kopo41_pageNum++; //페이지 번호 증가
			}
			
			if(k41_rset.next()) {
				System.out.printf(" %d\t%7s\t%3d\t%3d\t%3d\t%3d\t%3d \n",
						k41_rset.getInt(1),k41_rset.getString(2),k41_rset.getInt(3),
						k41_rset.getInt(4),k41_rset.getInt(5),k41_rset.getInt(6),k41_rset.getInt(7));
			}
			
			if((kopo41_i)%kopo41_iPerson_page==(kopo41_iPerson_page-1)) { //30줄 마다 
				kopo41_page_info(kopo41_i-(kopo41_iPerson_page-1)+1,kopo41_i+1);
			}
		}
		
		if(kopo41_iPerson%kopo41_iPerson_page!=0) { 
			//만약 30배수 줄에서 총합, 평균 한번 출력했다면 또 다시 총합, 평균 정보를 나타내지 않아도 된다.
			kopo41_page_info(kopo41_iPerson_page*(kopo41_pageNum-2)+1,kopo41_iPerson);
		}
		
		k41_rset.close(); //ResultSet닫기
		k41_stmt.close(); //Statement닫기
		k41_conn.close(); //Connection 연결 끊기
		
	}
	
	public static void kopo41_HeaderPrint() { //해더 출력
		Calendar kopo41_calt1 = Calendar.getInstance();
		SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); //날짜와 시간 형식 지정하기
		System.out.printf("\n\t\t  성적 집계표\n\n");
		System.out.printf("PAGE: %d\t\t  출력 일자 : %s\n",kopo41_pageNum,kopo41_sdt.format(kopo41_calt1.getTime()));
		System.out.printf("=================================================================\n");
		System.out.printf("  %2s\t%4s\t\t%2s\t%2s\t%2s\t%2s\t%2s \n","번호","이름","국어","영어","수학","합계","평균");
		System.out.printf("=================================================================\n");
	}
	
	public static void kopo41_page_info(int kopo41_start, int kopo41_finish) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		Statement k41_stmt1 = k41_conn.createStatement(); 
		Statement k41_stmt2 = k41_conn.createStatement(); 
		String k41_queryTxt1 ="select sum(kor), sum(eng), sum(mat), sum(kor+eng+mat), sum((kor+eng+mat)/3),"
								   + "avg(kor), avg(eng), avg(mat), avg(kor+eng+mat), avg((kor+eng+mat)/3)"
								   + "  from grade where studentid >=  "+ (kopo41_start) + " and studentid <= " + (kopo41_finish) + " ;";  
		ResultSet k41_rset1 = k41_stmt1.executeQuery(k41_queryTxt1); //쿼리문 적용하기
		
		String k41_queryTxt2 ="select sum(kor), sum(eng), sum(mat), sum(kor+eng+mat), sum((kor+eng+mat)/3),"
				   + "avg(kor), avg(eng), avg(mat), avg(kor+eng+mat), avg((kor+eng+mat)/3)"
				   + "  from grade where studentid > 0 and studentid <= " + (kopo41_finish) + " ;";  
		ResultSet k41_rset2 = k41_stmt2.executeQuery(k41_queryTxt2); //쿼리문 적용하기
		
	
		
		System.out.printf("=================================================================\n");
		System.out.printf("현재페이지\n"); //페이지 당 정보 출력
		if(k41_rset1.next()) {
			System.out.printf("합계 :\t\t\t%d\t%d\t%d\t%d\t%d\n",k41_rset1.getInt(1),
				k41_rset1.getInt(2),k41_rset1.getInt(3),k41_rset1.getInt(4),k41_rset1.getInt(5));
			System.out.printf("평균 :\t\t\t%d\t%d\t%d\t%d\t%d\n",k41_rset1.getInt(6),
					k41_rset1.getInt(7),k41_rset1.getInt(8),k41_rset1.getInt(9),k41_rset1.getInt(10));
		} // 페이지 마다 국어, 영어, 수학, 총합, 평균 점수의 총합과 평균 구하기

		
		System.out.printf("=================================================================\n");
		System.out.printf("누적페이지\n"); //누적 된 정보 출력
		if(k41_rset2.next()) {
			System.out.printf("합계 :\t\t\t%d\t%d\t%d\t%d\t%d\n",k41_rset2.getInt(1),
				k41_rset2.getInt(2),k41_rset2.getInt(3),k41_rset2.getInt(4),k41_rset2.getInt(5));
			System.out.printf("평균 :\t\t\t%d\t%d\t%d\t%d\t%d\n",k41_rset1.getInt(6),
					k41_rset2.getInt(7),k41_rset2.getInt(8),k41_rset2.getInt(9),k41_rset2.getInt(10));
		} 
		
		k41_rset1.close(); //ResultSet닫기
		k41_rset2.close(); //ResultSet닫기
		k41_stmt1.close(); //Statement닫기
		k41_stmt2.close(); //Statement닫기
		
	}
	

}