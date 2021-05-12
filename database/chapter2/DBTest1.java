package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest1 {
	//examtable1
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		
		k41_stmt.execute("create table examtable1("+ //���̺� ����
				"name varchar(20),"+ //�̸� ���������� ����
				"studentid int not null primary key," //�й� ������, ��ĭ �Ұ�, �⺻Ű ����
				+ "kor int," //�������� ������ ó��
				+ "eng int," //�������� ������ ó��
				+ "mat int)" //�������� ������ ó��
				+ "DEFAULT CHARSET=utf8;");
		//ResultSet �ʿ���� => ���� ������ �ϱ� ������ ������ �����ϴ� Statement�� ���
		
		k41_stmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
		
	}

}

