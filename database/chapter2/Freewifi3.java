package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Freewifi3 {
	///freewifi3
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		
		File k41_f = new File("C:\\Users\\sol\\Desktop\\���������������.txt"); //���� ��������
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
			
			if(k41_field[8].contains("Jan")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"01"+"-01";
			} else if(k41_field[8].contains("Feb")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"02"+"-01";
			} else if(k41_field[8].contains("Mar")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"03"+"-01";
			} else if(k41_field[8].contains("Apr")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"04"+"-01";
			} else if(k41_field[8].contains("May")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"05"+"-01";
			} else if(k41_field[8].contains("Jun")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"06"+"-01";
			} else if(k41_field[8].contains("Jul")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"07"+"-01";
			} else if(k41_field[8].contains("Aug")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"08"+"-01";
			} else if(k41_field[8].contains("Sep")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"09"+"-01";
			} else if(k41_field[8].contains("Oct")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"10"+"-01";
			} else if(k41_field[8].contains("Nov")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"11"+"-01";
			} else if(k41_field[8].contains("Dec")) {
				k41_field[8] = "20"+k41_field[8].substring(4)+"-"+"12"+"-01";
			} else {
				k41_field[8] = "1900-12-31";
			}

			String k41_queryTxt; //������ ���ڿ��� �Ͻ��� ����
			k41_queryTxt = String.format("insert into freewifi("
					+ "inst_place, inst_place_datail, inst_city, inst_country, inst_place_flag,"
					+ "service_provider, wifi_ssid, inst_date, place_addr_road, place_addr_land,"
					+ "manage_office, manage_office_phone, latitude, longtitude, write_date)"
					+ "values ("
					+ "'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
					k41_field[1], k41_field[2], k41_field[3], k41_field[4], k41_field[5], k41_field[6],
					k41_field[7], k41_field[8], k41_field[9], k41_field[10], k41_field[11], k41_field[12], k41_field[13],
					k41_field[14], k41_field[15]); //�����͸� �����ϴ� ������
			try {
				k41_stmt.execute(k41_queryTxt); //������ ���ڿ��� �̿��� ������ �����Ѵ�.
				System.out.printf("%d��° �׸� Insert OK [%s]\n", k41_lineCnt, k41_queryTxt); // ���� �����Ȳ�� �˱�����
			} catch(java.sql.SQLIntegrityConstraintViolationException e) {
				continue;
			}
			k41_lineCnt++; //���� �� ����
		}
		k41_br.close(); // ���� �б� ����
		k41_stmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
	}

}