package hacking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseGongi {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:3306/kopo41","root","kopo41");
		Statement stmt = conn.createStatement();
		
		//���̺� ����
		stmt.execute("drop table if exists gongjiP;"); 
		
		//���̺� ����
		stmt.execute("create table gongjiP("
				+ "campus	varchar(50),"
				+ "title	text,"
				+ "writer	text,"
				+ "date		date,"
				+ "url		text"
				+ ") DEFAULT CHARSET=utf8;"); 
		
		File f = new File("gongji.csv"); 
		BufferedReader br = new BufferedReader(new FileReader(f)); 
		
		String readtxt; 
		
		if((readtxt = br.readLine())==null) {
			System.out.printf("�� ���� �Դϴ�.\n");
			return;
		}
		
		int lineCnt =0; // ���϶��� �� ����
		
		while((readtxt = br.readLine())!=null) { 
			String[] field = readtxt.split(","); 
			

			String queryTxt; 
			
			if(field[1].contains("'")) {
				field[1] = field[1].replaceAll("'", "");
			}
			
			if(field[4].contains("'")) {
				field[4] = field[1].replaceAll("'", "");
			}
			
			if(field[4].contains(")")) {
				field[4] = field[1].replaceAll("\\)", "");
			}
			
			queryTxt = String.format("insert into gongjiP("
					+ "campus, title, writer, date, url )"
					+ "values ("
					+ "'%s', '%s', '%s', '%s', '%s');",
					field[0], field[1], field[2], field[3], field[4]); 
			try {
				stmt.execute(queryTxt); //������ ���ڿ��� �̿��� ������ �����Ѵ�.
				//System.out.printf("%d Insert OK %s\n", lineCnt, field[4]); // ���� �����Ȳ�� �˱�����
			} catch(java.sql.SQLIntegrityConstraintViolationException e) {
				System.out.println( field[4]);
				continue;
			} catch(java.sql.SQLSyntaxErrorException e) {
				System.out.println( field[4]);
				continue;
			} 
			lineCnt++; //���� �� ����
		}
		System.out.println(lineCnt);
		br.close(); // ���� �б� ����
		
		stmt.close(); //Statement�ݱ�
		conn.close(); //Connection ���� ����
	}
}
