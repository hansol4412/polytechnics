package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Grade3 {

		public static void main(String[] args) throws ClassNotFoundException, SQLException{
			Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
			Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
			// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
			Statement k41_stmt = k41_conn.createStatement(); 
			//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
			
			int k41_lineCnt =0; // ���϶��� �� ����
			
			for(int kopo41_i=0; kopo41_i<1000; kopo41_i++) {
				String kopo41_name = String.format("ȫ��%02d", kopo41_i+1); //�̸������
				int kopo41_kor = (int)(Math.random()*100); //�������� �����
				int kopo41_eng = (int)(Math.random()*100); //�������� �����
				int kopo41_mat = (int)(Math.random()*100); //�������� �����
				
				String k41_queryTxt; //������ ���ڿ��� �Ͻ��� ����
				k41_queryTxt = String.format("insert into grade("
						+ "studentid, name, kor, eng, mat)"
						+ "values ("
						+ "'%s', '%s', '%s', '%s', '%s');",
						kopo41_i+1, kopo41_name, kopo41_kor, kopo41_eng,  kopo41_mat); //�����͸� �����ϴ� ������
				
					k41_stmt.execute(k41_queryTxt); //������ ���ڿ��� �̿��� ������ �����Ѵ�.
					System.out.printf("%d��° �׸� Insert OK [%s]\n", k41_lineCnt, k41_queryTxt); // ���� �����Ȳ�� �˱�����
					k41_lineCnt++; //���� �� ����
			}

			k41_stmt.close(); //Statement�ݱ�
			k41_conn.close(); //Connection ���� ����
		}
	}