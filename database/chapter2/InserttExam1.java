package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserttExam1 {
	//examtable3
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스 종류 선택
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// 데이터베이스 종류, 접속연결 주소:포트번호/데이터 베이스명, 사용자명, 비밀번호 입력 => 연결하기
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB와 연결되는 Connection객체와의 의사소통을 위해 DB에게 명령을 내릴 때 그것을 던져주는 역활을 하는 인터페이스
		
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('효민', 209901, 95, 100, 95);");
		//Statement 객체의 execute 메소드를 이용해 효민데이터 examtable1에 집어 넣기
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('보람', 209902, 95, 95, 95);");
		//Statement 객체의 execute 메소드를 이용해 보람데이터 examtable1에 집어 넣기
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('은정', 209903, 100, 100, 100);");
		//Statement 객체의 execute 메소드를 이용해 은정데이터 examtable1에 집어 넣기
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('지연', 209904, 100, 95, 90);");
		//Statement 객체의 execute 메소드를 이용해 지연데이터 examtable1에 집어 넣기
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('소연', 209905, 80, 100, 70);");
		//Statement 객체의 execute 메소드를 이용해 소연데이터 examtable1에 집어 넣기
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('큐리', 209906, 100, 100, 70);");
		//Statement 객체의 execute 메소드를 이용해 큐리데이터 examtable1에 집어 넣기
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('화영', 209907, 70, 70, 70);");
		//Statement 객체의 execute 메소드를 이용해 화영데이터 examtable1에 집어 넣기
		k41_stmt.close();//Statement닫기
		k41_conn.close(); //Connection 연결 끊기
	}

}