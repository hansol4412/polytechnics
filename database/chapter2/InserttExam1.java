package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserttExam1 {
	//examtable3
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('ȿ��', 209901, 95, 100, 95);");
		//Statement ��ü�� execute �޼ҵ带 �̿��� ȿ�ε����� examtable1�� ���� �ֱ�
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('����', 209902, 95, 95, 95);");
		//Statement ��ü�� execute �޼ҵ带 �̿��� ���������� examtable1�� ���� �ֱ�
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('����', 209903, 100, 100, 100);");
		//Statement ��ü�� execute �޼ҵ带 �̿��� ���������� examtable1�� ���� �ֱ�
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('����', 209904, 100, 95, 90);");
		//Statement ��ü�� execute �޼ҵ带 �̿��� ���������� examtable1�� ���� �ֱ�
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('�ҿ�', 209905, 80, 100, 70);");
		//Statement ��ü�� execute �޼ҵ带 �̿��� �ҿ������� examtable1�� ���� �ֱ�
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('ť��', 209906, 100, 100, 70);");
		//Statement ��ü�� execute �޼ҵ带 �̿��� ť�������� examtable1�� ���� �ֱ�
		k41_stmt.execute("insert into examtable1 (name, studentid, kor, eng, mat) values ('ȭ��', 209907, 70, 70, 70);");
		//Statement ��ü�� execute �޼ҵ带 �̿��� ȭ�������� examtable1�� ���� �ֱ�
		k41_stmt.close();//Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
	}

}