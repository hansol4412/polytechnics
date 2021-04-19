package chapter5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Test33 {
	//������ ���1 ���Ѽ�
		public static int kopo41_netprice(int kopo41_price, double kopo41_rate) {
			// static�� �̿��ؼ� Ŭ���� ������ kopo41_netprice �޼ҵ带 �����Ӱ� ����� �� �ְ� �Ѵ�.
			// kopo41_price, kopo41_rate �Ű������� ����Ͽ� �Լ��� ȣ���� �� ���� �ҷ��´�
			if(kopo41_price<=10) {
				return (int)(kopo41_price/(1+kopo41_rate));
			}
			return (int)(kopo41_price/(1+kopo41_rate))+1; // ���������� ����ȭ �ؼ� �Ҽ����� ������ 1�� ���Ѵ�.
		}
		public static void main(String[] args) {
			Calendar kopo41_calt = Calendar.getInstance(); //���� �ð� �ҷ�����
			SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); //��¥�� �ð� ���� �����ϱ�
			DecimalFormat kopo41_df = new DecimalFormat("###,###,###,###,###"); // ���� �޸���� ����
			
			int kopo41_iPrice =9; //�Һ��ڰ� ���� �����ϴ� ����, ���İ���
			double kopo41_tax_rate = 0.1; // ����
			int kopo41_netPrice = kopo41_netprice(kopo41_iPrice, kopo41_tax_rate); 
			//�Һ��ڰ��� ������ �Ű������� �ؼ� ���������� ���Ѵ�.
			int kopo41_tax = kopo41_iPrice-kopo41_netPrice; 
			// ������ �Һ��ڰ��ݿ��� ����ȭ�� ���������� ���� ������ ����Ѵ�.
		
			System.out.printf("\n�ſ���� \n");
			System.out.printf("�ܸ��� : 2N68665898     ��ǥ��ȣ : 041218\n");
			System.out.printf("������ : �Ѿ��ġ�\n");
			System.out.printf("��  �� : ��� ������ �д籸 Ȳ�����351�� \n�� 10 ,1�� \n");
			System.out.printf("��ǥ�� : ��â��\n");
			System.out.printf("����� : 752-53-00558\t    TEL : 7055695\n");
			System.out.println("- - - - - - - - - - - - - - - - - - - - -");
			System.out.printf("��  ��  \t\t   %12s ��\n",kopo41_df.format(kopo41_netPrice)); //���ڿ� �޸� ��� ���� ��������, ������ ����
			System.out.printf("�ΰ���  \t\t   %12s ��\n",kopo41_df.format(kopo41_tax)); //���ڿ� �޸� ��� ���� ��������, ������ ����
			System.out.printf("��  ��  \t\t   %12s ��\n",kopo41_df.format(kopo41_iPrice)); //���ڿ� �޸� ��� ���� ��������, ������ ����
			System.out.println("- - - - - - - - - - - - - - - - - - - - -");
			System.out.printf("�츮ī�� \n");
			System.out.printf("ī���ȣ : 5387-20**-****-4613(S)  �Ͻú�\n");
			System.out.printf("�ŷ��Ͻ� : %s\n", kopo41_sdt.format(kopo41_calt.getTime())); //��¥�� ���˿� ���缭 ���
			System.out.printf("���ι�ȣ : 70404427\n");
			System.out.printf("�ŷ���ȣ : 357734873739\n");
			System.out.printf("���� : ��ī���       ���� : 720068568\n");
			System.out.printf("�˸� : EDC����ǥ\n");
			System.out.printf("���� : TEL)1544-4700\n");
			System.out.println("- - - - - - - - - - - - - - - - - - - - -");
			System.out.printf("\t     * �����մϴ� * \n");
			System.out.printf("\t\t       ǥ��V2.08_20200212\n");
		}
}




