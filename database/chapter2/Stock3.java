package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock3 {

	public static void main(String[] args)throws ClassNotFoundException, SQLException, IOException{
		Class.forName("com.mysql.cj.jdbc.Driver"); //�����ͺ��̽� ���� ����
		Connection k41_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.79:3306/kopo41","root","kopo41");
		// �����ͺ��̽� ����, ���ӿ��� �ּ�:��Ʈ��ȣ/������ ���̽���, ����ڸ�, ��й�ȣ �Է� => �����ϱ�
		
		String k41_queryTxt = "insert into stock("
				+ "code, pdate, s_price, h_price, i_price, c_price, quantity, amount)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement k41_pstmt = k41_conn.prepareStatement(k41_queryTxt);
		
		File k41_f = new File("C:\\Users\\sol\\Desktop\\day_data\\kopo41_stockDailyPrice.csv"); //���� ��������
		BufferedReader k41_br = new BufferedReader(new FileReader(k41_f)); //BufferedReader�� ���� �б�

		String k41_readtxt; // ������ ���پ� �б�

//		if((k41_readtxt = k41_br.readLine())==null) { //������ ������ ���ٸ� ������
//			System.out.printf("�� ���� �Դϴ�.\n");
//			return;
//		}
		
		int k41_lineCnt =0; // ���϶��� �� ����
		k41_conn.setAutoCommit(false); //����Ŀ���� �ȵǰ��ϰ�
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss"); //���� ����
		String start = format.format (System.currentTimeMillis());
		long k41_startTime = System.currentTimeMillis();
		
		while((k41_readtxt = k41_br.readLine())!=null) { //������ ��ĭ�� �ƴ� ������ �б�
			String[] k41_field = k41_readtxt.split(","); // �޸��� �����ؼ� ������ ������.
			k41_pstmt.setString(1, k41_field[2]);
			k41_pstmt.setString(2, k41_field[1]);
			k41_pstmt.setString(3, k41_field[4]);
			k41_pstmt.setString(4, k41_field[5]);
			k41_pstmt.setString(5, k41_field[6]);
			k41_pstmt.setString(6, k41_field[3]);
			k41_pstmt.setString(7, k41_field[10]);
			k41_pstmt.setString(8, k41_field[12]);
			k41_pstmt.addBatch();
			System.out.printf("%d��° �׸� addBatch Ok\n", k41_lineCnt);
			k41_pstmt.clearParameters();
			k41_lineCnt++;
			try {
				if(k41_lineCnt%10000 == 0) {
					k41_pstmt.executeBatch();
					k41_conn.commit();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			k41_pstmt.executeBatch();
		} catch(Exception e) {
			e.printStackTrace();
		}
		k41_conn.commit();
		k41_conn.setAutoCommit(true);
		long k41_endTime = System.currentTimeMillis();
		String finish = format.format (System.currentTimeMillis());

		SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS");

		Date timeInDate = new Date(k41_endTime-k41_startTime); 
		String timeInFormat = sdf2.format(timeInDate);
		
		System.out.println("���۽ð�: "+start);
		System.out.println("����ð�: "+finish);		
		System.out.println("total: " + k41_lineCnt); // �� ����
		System.out.print("time: " + (k41_endTime-k41_startTime)); //�ɸ��ð�
		System.out.println(" (" + timeInFormat+")");
		
		k41_br.close(); // ���� �б� ����
		k41_pstmt.close(); //Statement�ݱ�
		k41_conn.close(); //Connection ���� ����
		
	}
}
