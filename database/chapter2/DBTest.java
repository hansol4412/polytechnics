package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	//JDBC �⺻���α׷�
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		ResultSet k41_rset = k41_stmt.executeQuery("show databases;");  //sql�� ������ ����� ResultSet�� �ֱ�
		
		while(k41_rset.next()) { //ResultSet�� �ִ� ������ ����ϱ�
			System.out.println("��: "+k41_rset.getString(1)); // ResultSet�� �ִ� �������� ù��° �� ����ϱ�
		}
		k41_rset.close(); //ResultSet�ݱ�
		k41_stmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
		
	}

}
