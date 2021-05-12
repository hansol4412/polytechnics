package database;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Freewifi4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		
		double k41_lat = 37.3860521; //�浵
		double k41_lng = 127.1214038; //����
		
		String k41_queryTxt;
		
		k41_queryTxt ="select * from freewifi;";  //��ü ������ ����ϴ� ������
		ResultSet k41_rset = k41_stmt.executeQuery(k41_queryTxt); //������ �����ϱ�
		
		double k41_Mindist = 1000000000; // �ּҰŸ�
		String k41_MinArea=""; //�ּҰŸ� ��Ī
		double k41_MindistW = 0; // �ּ� �Ÿ� ����
		double k41_MindistK = 0; // �ּ� �Ÿ� �浵
		
		int k41_iCnt=0;
		while(k41_rset.next()) {
			System.out.printf("*(%d)*************************************\n",k41_iCnt++);
			System.out.printf("��ġ��Ҹ�		: %s\n",k41_rset.getString(1));
			System.out.printf("��ġ��һ�		: %s\n",k41_rset.getString(2));
			System.out.printf("��ġ�õ���		: %s\n",k41_rset.getString(3));
			System.out.printf("��ġ�ñ�����		: %s\n",k41_rset.getString(4));
			System.out.printf("��ġ�ü�����		: %s\n",k41_rset.getString(5));
			System.out.printf("�����������		: %s\n",k41_rset.getString(6));
			System.out.printf("��������SSID		: %s\n",k41_rset.getString(7));
			System.out.printf("��ġ���		: %s\n",k41_rset.getDate(8));
			System.out.printf("���������θ��ּ�	: %s\n",k41_rset.getString(9));
			System.out.printf("�����������ּ�		: %s\n",k41_rset.getString(10));
			System.out.printf("���������		: %s\n",k41_rset.getString(11));
			System.out.printf("���������ȭ��ȣ	: %s\n",k41_rset.getString(12));
			System.out.printf("����			: %s\n",k41_rset.getDouble(13));
			System.out.printf("�浵			: %s\n",k41_rset.getDouble(14));
			System.out.printf("�����ͱ��س�¥		: %s\n",k41_rset.getDate(15));
			System.out.printf("****************************************\n");
			
			double k41_dist= Math.sqrt(Math.pow(k41_rset.getFloat(13)-k41_lat, 2)
					+Math.pow(k41_rset.getFloat(14)-k41_lng, 2)); //�Ÿ����ϱ�
			if(k41_Mindist>k41_dist) {
				k41_Mindist=k41_dist; // �ּҰŸ�
				k41_MinArea = k41_rset.getString(1) +" "+k41_rset.getString(2) +" ("+ k41_rset.getString(9) +")"; //�ּҰŸ� ��Ī
				k41_MindistW = k41_rset.getDouble(13); // �ּ� �Ÿ� ����
				k41_MindistK = k41_rset.getDouble(14); // �ּ� �Ÿ� �浵
			}
	
		}
		
		System.out.printf("���� �������� �ּҰŸ� �������� ��� => %s : %f   (���� %f, �浵 %f)\n", 
				k41_MinArea, k41_Mindist,k41_MindistW,k41_MindistK); 
		
		k41_rset.close(); //ResultSet�ݱ�
		k41_stmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
		
	}

}
