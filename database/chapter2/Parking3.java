package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Parking3 {
	//������ ������ ä���
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		
		File k41_f = new File("C:\\Users\\sol\\Desktop\\�ѱ������������_������������������.txt"); //���� ��������
		BufferedReader k41_br = new BufferedReader(new FileReader(k41_f)); //BufferedReader�� ���� �б�
		
		String k41_readtxt; // ������ ���پ� �б�
		
		if((k41_readtxt = k41_br.readLine())==null) { //������ ������ ���ٸ� ������
			System.out.printf("�� ���� �Դϴ�.\n");
			return;
		}
		String[] field_name = k41_readtxt.split("\t");
		int k41_lineCnt =0; // ���϶��� �� ����
		
		while((k41_readtxt = k41_br.readLine())!=null) { //������ ��ĭ�� �ƴ� ������ �б�
			String[] k41_field = k41_readtxt.split("\t"); //tabŰ�� �����ؼ� ������ ������.

			String k41_queryTxt; //������ ���ڿ��� �Ͻ��� ����
			
			try {
			k41_queryTxt = String.format("insert into parking("
					+ "paking_code, parking_name, longtitude, latitude, paking_division,"
					+ "paking_type, addr, parking_count, parking_fee, inst_city,"
					+ "inst_country, inst_place_flag, inst_code, telephone, write_date)"
					+ "values ("
					+ "'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
					k41_field[0], k41_field[1], k41_field[2], k41_field[3], k41_field[4], k41_field[5], k41_field[6],
					k41_field[7], k41_field[8], k41_field[9], k41_field[10], k41_field[11], k41_field[12], k41_field[13], k41_field[14]); //�����͸� �����ϴ� ������
			
				k41_stmt.execute(k41_queryTxt); //������ ���ڿ��� �̿��� ������ �����Ѵ�.
				System.out.printf("%d��° �׸� Insert OK [%s]\n", k41_lineCnt, k41_queryTxt); // ���� �����Ȳ�� �˱�����
			} catch(java.sql.SQLIntegrityConstraintViolationException e) {
				continue;
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				continue;
			}
			k41_lineCnt++; //���� �� ����
		}
		k41_br.close(); // ���� �б� ����
		k41_stmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
	}

}