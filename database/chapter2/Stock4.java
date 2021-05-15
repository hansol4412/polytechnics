package database;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		Statement k41_stmt = k41_conn.createStatement(); 
		//DB�� ����Ǵ� Connection��ü���� �ǻ������ ���� DB���� ����� ���� �� �װ��� �����ִ� ��Ȱ�� �ϴ� �������̽�
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss"); //���� ����
		String start = format.format (System.currentTimeMillis());
		
		long k41_startTime = System.currentTimeMillis(); //���۽ð�
		String k41_queryTxt;
		
		k41_queryTxt ="select * from stock where code = 'A005930';";  //��ü ������ ����ϴ� ������
		ResultSet k41_rset = k41_stmt.executeQuery(k41_queryTxt); //������ �����ϱ�
		
		int k41_iCnt=0;
		while(k41_rset.next()) {
			System.out.printf("*(%d)*************************************\n",k41_iCnt++);
			System.out.printf("�����ڵ�	: %s\n",k41_rset.getString(1));
			System.out.printf("����		: %s\n",k41_rset.getString(2));
			System.out.printf("�ð�		: %s\n",k41_rset.getInt(3));
			System.out.printf("��		: %s\n",k41_rset.getInt(4));
			System.out.printf("����		: %s\n",k41_rset.getInt(5));
			System.out.printf("����		: %s\n",k41_rset.getInt(6));
			System.out.printf("�ŷ���		: %s\n",k41_rset.getInt(7));
			System.out.printf("�ŷ����	: %s\n",k41_rset.getBigDecimal(8));
			System.out.printf("****************************************\n");

		}
		
		long k41_endTime = System.currentTimeMillis(); //���ð�
		String finish = format.format (System.currentTimeMillis());

		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss.SSS");

		Date timeInDate = new Date(k41_endTime-k41_startTime); 
		String timeInFormat = sdf2.format(timeInDate);

		System.out.println("���۽ð�: "+start);
		System.out.println("����ð�: "+finish);		
		System.out.println("total: " + k41_iCnt); // �� ����
		System.out.print("time: " + (k41_endTime-k41_startTime)); //�ɸ��ð�
		System.out.println(" (" + timeInFormat+")");
		
		k41_rset.close(); //ResultSet�ݱ�
		k41_stmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
		
	}

}
