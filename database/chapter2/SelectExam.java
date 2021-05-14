package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExam {
	//examtable4
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		ResultSet k41_rset = k41_stmt.executeQuery("select * from examtable1;");  //sql�� ������ ����� ResultSet�� �ֱ�
		
		System.out.printf("  �̸�   �й�   ���� ���� ���� \n");
		while(k41_rset.next()) {
			System.out.printf("%4s  %6d  %3d  %3d  %3d  \n",
					k41_rset.getString(1),k41_rset.getInt(2),k41_rset.getInt(3),k41_rset.getInt(4),k41_rset.getInt(5));
			//ResultSet�� ����� �÷��� �ϳ��� ���ؼ� ����ϱ�
		}
		
		k41_rset.close(); //ResultSet�ݱ�
		k41_stmt.close();//Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
	}

}
