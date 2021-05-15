package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Stock1 {

	public static void main(String[] args)throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		
		//���̺� ����
		k41_stmt.execute("create table stock(" // stock table �����
				+ "code		varchar(20) not null," 		// �����ڵ�
				+ "pdate	date not null,"			// ����
				+ "s_price	int," 		// �ð�
				+ "h_price	int," 		// ��
				+ "i_price	int," 		// ����
				+ "c_price	int," 		// ����
				+ "quantity	int," 		// �ŷ���
				+ "amount	bigint,"	//�ŷ����
				+ "PRIMARY KEY(code, pdate)" 		// �⺻ ����Ű ����
				+ ") DEFAULT CHARSET=utf8;"); 
		//ResultSet �ʿ���� => ���� ������ �ϱ� ������ ������ �����ϴ� Statement�� ���
		
		k41_stmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
	}
}