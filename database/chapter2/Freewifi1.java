package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Freewifi1 {
	//freewifi1
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		
		//���̺� ����
		k41_stmt.execute("create table freewifi("
				+ "inst_place	varchar(50),"
				+ "inst_place_datail	varchar(200) ,"
				+ "inst_city	varchar(50),"
				+ "inst_country	varchar(50),"
				+ "inst_place_flag	varchar(50),"
				+ "service_provider		varchar(50),"
				+ "wifi_ssid	varchar(50),"
				+ "inst_date	date,"
				+ "place_addr_road 	varchar(200),"
				+ "place_addr_land	varchar(200),"
				+ "manage_office	varchar(50),"
				+ "manage_office_phone	varchar(50),"
				+ "latitude		double,"
				+ "longtitude	double,"
				+ "write_date	date"
				+ ") DEFAULT CHARSET=utf8;"); 
		//ResultSet �ʿ���� => ���� ������ �ϱ� ������ ������ �����ϴ� Statement�� ���
		
		k41_stmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
	}
}