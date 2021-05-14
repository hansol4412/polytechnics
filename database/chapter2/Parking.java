package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Parking {
	//parking1
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		
		//���̺� ����
		k41_stmt.execute("create table parking(" // parking table �����
				+ "paking_code	int not null primary key," 		// �����������ȣ, �⺻Ű ����
				+ "parking_name	varchar(50)," 		// �������
				+ "longtitude	double,"			// �浵
				+ "latitude		double,"			// ����
				+ "paking_division		varchar(50),"   // �����屸��
				+ "paking_type		varchar(50),"   // ����������
				+ "addr			varchar(200),"  // �����������ּ�
				+ "parking_count	int,"  // ������ȹ��
				+ "parking_fee	varchar(50),"  // �������
				+ "inst_city	varchar(50)," //���������
				+ "inst_country	varchar(50)," //��������
				+ "inst_place_flag	varchar(50)," //��������_sub
				+ "inst_code		int," //���� �ڵ�
				+ "telephone	varchar(50)," //����ó
				+ "write_date	date" //��������
				+ ") DEFAULT CHARSET=utf8;"); 
		//ResultSet �ʿ���� => ���� ������ �ϱ� ������ ������ �����ϴ� Statement�� ���
		
		k41_stmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
	}
}