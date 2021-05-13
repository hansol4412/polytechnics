package database;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Grade4 {

	public static int kopo41_pageNum =1; //������ ��ȣ
	public static Connection k41_conn;
	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		
		Statement k41_stmt = k41_conn.createStatement(); 
		
		int kopo41_iPerson_page = 30; //�������� ������� ũ��
		int kopo41_iPerson = 1000; //��ü ������� ũ��
		
		String k41_queryTxt;

		k41_queryTxt ="select *, kor+eng+mat, (kor+eng+mat)/3 from grade;";  //��ġ �õ����� ������ �����͸� ����ϴ� ������
		ResultSet k41_rset = k41_stmt.executeQuery(k41_queryTxt); //������ �����ϱ�
		
		for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) {
			//���
			if((kopo41_i)%kopo41_iPerson_page==0) { //30�� ����
				kopo41_HeaderPrint();
				kopo41_pageNum++; //������ ��ȣ ����
			}
			
			if(k41_rset.next()) {
				System.out.printf(" %d\t%7s\t%3d\t%3d\t%3d\t%3d\t%3d \n",
						k41_rset.getInt(1),k41_rset.getString(2),k41_rset.getInt(3),
						k41_rset.getInt(4),k41_rset.getInt(5),k41_rset.getInt(6),k41_rset.getInt(7));
			}
			
			if((kopo41_i)%kopo41_iPerson_page==(kopo41_iPerson_page-1)) { //30�� ���� 
				kopo41_page_info(kopo41_i-(kopo41_iPerson_page-1)+1,kopo41_i+1);
			}
		}
		
		if(kopo41_iPerson%kopo41_iPerson_page!=0) { 
			//���� 30��� �ٿ��� ����, ��� �ѹ� ����ߴٸ� �� �ٽ� ����, ��� ������ ��Ÿ���� �ʾƵ� �ȴ�.
			kopo41_page_info(kopo41_iPerson_page*(kopo41_pageNum-2)+1,kopo41_iPerson);
		}
		
		k41_rset.close(); //ResultSet�ݱ�
		k41_stmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
		
	}
	
	public static void kopo41_HeaderPrint() { //�ش� ���
		Calendar kopo41_calt1 = Calendar.getInstance();
		SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); //��¥�� �ð� ���� �����ϱ�
		System.out.printf("\n\t\t  ���� ����ǥ\n\n");
		System.out.printf("PAGE: %d\t\t  ��� ���� : %s\n",kopo41_pageNum,kopo41_sdt.format(kopo41_calt1.getTime()));
		System.out.printf("=================================================================\n");
		System.out.printf("  %2s\t%4s\t\t%2s\t%2s\t%2s\t%2s\t%2s \n","��ȣ","�̸�","����","����","����","�հ�","���");
		System.out.printf("=================================================================\n");
	}
	
	public static void kopo41_page_info(int kopo41_start, int kopo41_finish) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		Statement k41_stmt1 = k41_conn.createStatement(); 
		Statement k41_stmt2 = k41_conn.createStatement(); 
		String k41_queryTxt1 ="select sum(kor), sum(eng), sum(mat), sum(kor+eng+mat), sum((kor+eng+mat)/3),"
								   + "avg(kor), avg(eng), avg(mat), avg(kor+eng+mat), avg((kor+eng+mat)/3)"
								   + "  from grade where studentid >=  "+ (kopo41_start) + " and studentid <= " + (kopo41_finish) + " ;";  
		ResultSet k41_rset1 = k41_stmt1.executeQuery(k41_queryTxt1); //������ �����ϱ�
		
		String k41_queryTxt2 ="select sum(kor), sum(eng), sum(mat), sum(kor+eng+mat), sum((kor+eng+mat)/3),"
				   + "avg(kor), avg(eng), avg(mat), avg(kor+eng+mat), avg((kor+eng+mat)/3)"
				   + "  from grade where studentid > 0 and studentid <= " + (kopo41_finish) + " ;";  
		ResultSet k41_rset2 = k41_stmt2.executeQuery(k41_queryTxt2); //������ �����ϱ�
		
	
		
		System.out.printf("=================================================================\n");
		System.out.printf("����������\n"); //������ �� ���� ���
		if(k41_rset1.next()) {
			System.out.printf("�հ� :\t\t\t%d\t%d\t%d\t%d\t%d\n",k41_rset1.getInt(1),
				k41_rset1.getInt(2),k41_rset1.getInt(3),k41_rset1.getInt(4),k41_rset1.getInt(5));
			System.out.printf("��� :\t\t\t%d\t%d\t%d\t%d\t%d\n",k41_rset1.getInt(6),
					k41_rset1.getInt(7),k41_rset1.getInt(8),k41_rset1.getInt(9),k41_rset1.getInt(10));
		} // ������ ���� ����, ����, ����, ����, ��� ������ ���հ� ��� ���ϱ�

		
		System.out.printf("=================================================================\n");
		System.out.printf("����������\n"); //���� �� ���� ���
		if(k41_rset2.next()) {
			System.out.printf("�հ� :\t\t\t%d\t%d\t%d\t%d\t%d\n",k41_rset2.getInt(1),
				k41_rset2.getInt(2),k41_rset2.getInt(3),k41_rset2.getInt(4),k41_rset2.getInt(5));
			System.out.printf("��� :\t\t\t%d\t%d\t%d\t%d\t%d\n",k41_rset1.getInt(6),
					k41_rset2.getInt(7),k41_rset2.getInt(8),k41_rset2.getInt(9),k41_rset2.getInt(10));
		} 
		
		k41_rset1.close(); //ResultSet�ݱ�
		k41_rset2.close(); //ResultSet�ݱ�
		k41_stmt1.close(); //Statement�ݱ�
		k41_stmt2.close(); //Statement�ݱ�
		
	}
	

}