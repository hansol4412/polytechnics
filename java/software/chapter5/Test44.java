package chapter5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test44 {

	public static int kopo41_netprice(int kopo41_price, double kopo41_rate) {
		// static�� �̿��ؼ� Ŭ���� ������ kopo41_netprice �޼ҵ带 �����Ӱ� ����� �� �ְ� �Ѵ�.
		// kopo41_price, kopo41_rate �Ű������� ����Ͽ� �Լ��� ȣ���� �� ���� �ҷ��´�
		return (int)(kopo41_price/(1+kopo41_rate)); // ���������� ����ȭ �ؼ� �Ҽ����� ������.
	}
	public static void main(String[] args) {
		SimpleDateFormat kopo41_sdt3 = new SimpleDateFormat("YYYYMMdd"); //��¥�� �ð� ���� �����ϱ�
		//��ǰ 1�� ���� (�̸�, �ڵ�, ����, ����)
		String kopo41_itemname1="ǻ��� aaaa�����ܿ븶��ũ(�ְ����)";
		String kopo41_itemcode1="1031615";
		int price1 = 9000000;
		int amount1 = 10;
		
		//��ǰ 2�� ���� (�̸�, �ڵ�, ����, ����)
		String kopo41_itemname2="�����̵�ĸ���";
		String kopo41_itemcode2="11008152";
		int price2 = 0;
		int amount2 = 1;
		
		//��ǰ 3�� ���� (�̸�, �ڵ�, ����, ����)
		String kopo41_itemname3="�������� ���׸�����ũ(�˷�̴�Ÿ��)";
		String kopo41_itemcode3="1020800";
		int price3 = 0;
		int amount3 = 1;
		
		Calendar kopo41_calt1 = Calendar.getInstance(); //���� �ð� �ҷ�����
		Calendar kopo41_calt2 = Calendar.getInstance(); //���� �ð� �ҷ�����
		SimpleDateFormat kopo41_sdt1 = new SimpleDateFormat("MM��dd��"); //��¥�� �ð� ���� �����ϱ�
		SimpleDateFormat kopo41_sdt2 = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); //��¥�� �ð� ���� �����ϱ�
		DecimalFormat kopo41_df = new DecimalFormat("###,###,###,###,###"); // ���� �޸���� ����
		
		int kopo41_totalSum = price1*amount1 + price2*amount2 + price3*amount3; //��ǰ�� �� ���� (���� * ����)
		int kopo41_netPrice = kopo41_netprice(kopo41_totalSum, 0.1); 
		// �� ���ݰ� ������ �Ű������� �ְ� �����ݾ� ���ϱ� ���� �Լ��� ȣ��
		int kopo41_tax = kopo41_totalSum-kopo41_netPrice; 
		// ������ �Һ��ڰ��ݿ��� ����ȭ�� ���������� ���� ������ ����Ѵ�.
		
		System.out.printf("\n\t   \"���ΰ���, ���̼�\"\n");
		System.out.printf("(��)�Ƽ����̼�_�д缭����\n");
		System.out.printf("��ȭ:031-702-6016\n");
		System.out.printf("����:���� ������ ���μ�ȯ�� 2748 (���)\n");
		System.out.printf("��ǥ:������,��ȣ�� 213-81-52063\n");
		System.out.printf("����:��⵵ ������ �д籸 �д��53���� 11 \n(������)\n");
		System.out.printf("=========================================\n");
		System.out.printf("      �Һ����߽ɰ濵(CCM) �������\n");
		System.out.printf("    ISO 9001 ǰ���濵�ý��� �������\n");
		
		System.out.printf("=========================================\n");
		kopo41_calt1.add(Calendar.DATE, 14); // ���� ���ڿ��� 14���� ���� ��ȯ/ȯ���� ��ȿ�Ⱓ�� ���Ѵ�.
		System.out.printf("      %s(%s)�̳�,\n","��ȯ/ȯ�� 14��" ,kopo41_sdt1.format(kopo41_calt1.getTime())); 
		//��ȯ, ȯ�� ��ȿ�Ⱓ ���˿� ���缭 ����ϱ�
		System.out.printf("     (����)������, ����ī�� ���� �� \n           ���Ը��忡�� ����\n");
		System.out.printf("   ����/���� �� �Ѽս� ��ȯ/ȯ�� �Ұ�\n");
		System.out.printf("     üũī�� ��� �� �ִ� 7�� �ҿ�\n");
		System.out.printf("=========================================\n");
		System.out.printf("[POS 1058231]\t      %s\n",kopo41_sdt2.format(kopo41_calt2.getTime()));
		System.out.printf("=========================================\n");
		//���� �ð� ���˿� ���缭 ����ϱ�
		
		System.out.printf("%s%s %2d %9s\n",kopo41_hanBlankBackword(kopo41_itemname1,17),
				kopo41_hanBlankForeword(kopo41_df.format(price1),10),amount1, 
				kopo41_hanBlankForeword(kopo41_df.format(price1*amount1),10) );
		//��ǰ1�� ���� ���� ��� : ��ǰ�� 14���ڱ����� �������� ���, ���ݰ� �� ������ ���ڿ� �޸��� ����ϱ�
		System.out.printf("[%s]\t\n",kopo41_itemcode1); //��ǰ1�� �ڵ�
		System.out.printf("%s%s %2d %9s\n",kopo41_hanBlankBackword(kopo41_itemname2,17),
				kopo41_hanBlankForeword(kopo41_df.format(price2),10),amount2, 
				kopo41_hanBlankForeword(kopo41_df.format(price2*amount2),10) );
		//��ǰ2�� ���� ���� ��� : ��ǰ�� 14���ڱ����� �������� ���, ���ݰ� �� ������ ���ڿ� �޸��� ����ϱ�
		System.out.printf("[%s]\t\n",kopo41_itemcode2);
		System.out.printf("%s%s %2d %9s\n",kopo41_hanBlankBackword(kopo41_itemname3,17),
				kopo41_hanBlankForeword(kopo41_df.format(price3),10),amount3, 
				kopo41_hanBlankForeword(kopo41_df.format(price3*amount3),10) );

		//��ǰ3�� ���� ���� ��� : ��ǰ�� 14���ڱ����� �������� ���, ���ݰ� �� ������ ���ڿ� �޸��� ����ϱ�
		System.out.printf("[%s]\t\n",kopo41_itemcode3);
		System.out.printf("        �����հ�%s\n", kopo41_hanBlankForeword(kopo41_df.format(kopo41_netPrice),25)); //���� ����
		System.out.printf("\t  �ΰ���%s\n", kopo41_hanBlankForeword(kopo41_df.format(kopo41_tax),25)); //����
		System.out.printf("-----------------------------------------\n");
		System.out.printf("�Ǹ��հ�\t\t       %-10s\n",kopo41_hanBlankForeword(kopo41_df.format(kopo41_totalSum),10)); //���� ����
		System.out.printf("=========================================\n");
		System.out.printf("�ſ�ī��\t\t       %-10s\n",kopo41_hanBlankForeword(kopo41_df.format(kopo41_totalSum),10));
		System.out.printf("-----------------------------------------\n");
		System.out.printf("�츮ī��\t\t 538720**********\n");
		System.out.printf("���ι�ȣ 77982843(0)  ���αݾ� %s\n",kopo41_hanBlankForeword(kopo41_df.format(kopo41_totalSum),10));
		System.out.printf("=========================================\n");
		System.out.printf("    %s  �д缭����\n",kopo41_sdt2.format(kopo41_calt2.getTime())); //���� �ð� ���
		System.out.printf("��ǰ �� ��Ÿ ���� : 1522-4400\n");
		System.out.printf("����� �� �����̼� ���� ���� : 1599-2211\n");
		System.out.printf("\t    2112820610158231\n");
		System.out.printf("-----------------------------------------\n");
		System.out.printf("   �� ���̼� ����� �� �Ǵ� Ȩ�������� \n        �����ϼż� ȸ������ �� \n      �پ��� ������ ����������! ��");
		
	}
	public static String kopo41_hanBlankForeword(String kopo41_str, int kopo41_num) {
		StringBuilder kopo41_sb = new StringBuilder(); 
		  //���ڿ��� ���ϴ� �������� �Ÿ� �Ҵ�� �޸� �������� �߻��ϴ� ��ȿ���� ����
        String kopo41_curChar; // ���ڿ��� �ϳ��� ������ ���� ����
        int kop41_curLen = 0; //�ϳ��� ���� ���ڿ��� �� ����Ʈ ���� ���ϱ� ���� ����
       
        for (int i = 0; i < kopo41_str.length(); i++) //���ڿ� ũ�� ��Ŭ �ݺ����� ������.
        {
      	  kopo41_curChar = kopo41_str.substring(i, i + 1); //���ڿ��� �ϳ��� ������
      	  if (kop41_curLen + kopo41_curChar.getBytes().length > kopo41_num) {
      		  //�־��� ����Ʈ �� �� ���� ����� ����Ʈ ���� Ŀ���� �ݺ��� ������
      		  break;
      	  } else {
          	  kop41_curLen += kopo41_curChar.getBytes().length; //�ϳ��� ���� ���ڿ��� ����Ʈ ���� ���Ѵ�.
          	  kopo41_sb.append(kopo41_curChar); // ���ڿ� ���ϱ�
            } 	  
        }
        String kopo41_strF = kopo41_sb.toString(); //�Ű��������� ���� ���� ������ �Ҵ��ϱ�
        
        String kopo41_ret_str =""; //�ʱ� ���ڿ� ����
        for(int kopo41_i=0; kopo41_i<(kopo41_num-kop41_curLen);kopo41_i++) {
			// ������ ���ڱ��̿��� ����Ʈ �迭�� ���� �� ��ŭ�� ������ ��´�
			kopo41_ret_str=kopo41_ret_str+" ";
        }
        kopo41_ret_str=kopo41_ret_str+kopo41_strF;
        //������ �߰��� �տ� ���ڿ��� ���Ѵ�
        return kopo41_ret_str; //���ڿ� ����
	}
	
	public static String kopo41_hanBlankBackword(String kopo41_str, int kopo41_num) {
		  StringBuilder kopo41_sb = new StringBuilder(); 
		  //���ڿ��� ���ϴ� �������� �Ÿ� �Ҵ�� �޸� �������� �߻��ϴ� ��ȿ���� ����
        String kopo41_curChar; // ���ڿ��� �ϳ��� ������ ���� ����
        int kop41_curLen = 0; //�ϳ��� ���� ���ڿ��� �� ����Ʈ ���� ���ϱ� ���� ����
       
        for (int i = 0; i < kopo41_str.length(); i++) //���ڿ� ũ�� ��Ŭ �ݺ����� ������.
        {
      	  kopo41_curChar = kopo41_str.substring(i, i + 1); //���ڿ��� �ϳ��� ������
      	  if (kop41_curLen + kopo41_curChar.getBytes().length > kopo41_num) {
      		  //�־��� ����Ʈ �� �� ���� ����� ����Ʈ ���� Ŀ���� �ݺ��� ������
      		  break;
      	  } else {
          	  kop41_curLen += kopo41_curChar.getBytes().length; //�ϳ��� ���� ���ڿ��� ����Ʈ ���� ���Ѵ�.
          	  kopo41_sb.append(kopo41_curChar); // ���ڿ� ���ϱ�
            } 	  
        }
        
        String kopo41_strB = kopo41_sb.toString(); //�ڸ� ���ڿ��� ������ ����
        String kopo41_ret_str =""; //�ʱ� ���ڿ� ����
        for(int kopo41_i=0; kopo41_i<(kopo41_num-kop41_curLen);kopo41_i++) {
			// ������ ���ڱ��̿��� ����Ʈ �迭�� ���� �� ��ŭ�� ������ ��´�
			kopo41_ret_str=kopo41_ret_str+" ";
        }
        kopo41_ret_str=kopo41_strB+kopo41_ret_str;
        //������ �߰��� �տ� ���ڿ��� ���Ѵ�
        return kopo41_ret_str; //���ڿ� ����
	}
}
