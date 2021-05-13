package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Grade3 {

		public static void main(String[] args) throws ClassNotFoundException, SQLException{
			Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
			Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
			// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
			Statement k41_stmt = k41_conn.createStatement(); 
			//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
			
			int k41_lineCnt =0; // 파일라인 수 세기
			
			for(int kopo41_i=0; kopo41_i<1000; kopo41_i++) {
				String kopo41_name = String.format("홍길%02d", kopo41_i+1); //이름만들기
				int kopo41_kor = (int)(Math.random()*100); //국어점수 만들기
				int kopo41_eng = (int)(Math.random()*100); //영어점수 만들기
				int kopo41_mat = (int)(Math.random()*100); //수학점수 만들기
				
				String k41_queryTxt; //쿼리문 문자열에 일시적 저장
				k41_queryTxt = String.format("insert into grade("
						+ "studentid, name, kor, eng, mat)"
						+ "values ("
						+ "'%s', '%s', '%s', '%s', '%s');",
						kopo41_i+1, kopo41_name, kopo41_kor, kopo41_eng,  kopo41_mat); //데이터를 삽입하는 쿼리문
				
					k41_stmt.execute(k41_queryTxt); //저장한 문자열을 이용해 쿼리를 적용한다.
					System.out.printf("%d번째 항목 Insert OK [%s]\n", k41_lineCnt, k41_queryTxt); // 쿼리 진행상황을 알기위함
					k41_lineCnt++; //라인 수 증가
			}

			k41_stmt.close(); //Statement닫기
			k41_conn.close(); //Connection 연결 끊기
		}
	}