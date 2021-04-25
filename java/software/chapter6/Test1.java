package chapter6;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test1 {
			//������ ��� �Լ��� ������ (���Ѽ�)
			public static DecimalFormat kopo41_df = new DecimalFormat("###,###,###,###,###"); // ���� �޸���� ����
			public static Calendar kopo41_calt1 = Calendar.getInstance(); //���� �ð� �ҷ�����
			public static String[] kopo41_itemname= {"����Ȩ aaa�ڵ�ũ��","���� ����ȭ��","��������E","���� ���Ϸ� �� ��","����Ȩ �ڵ����","��� �Ŷ��",
					"���������","���ѱ� ������� 156g", "GAP ������ 6��", "�� ����� �ٳ���","����ũ ����̿���","���� ���ִ� ����GT",
					"���������÷�10��", "����� ����(��)65g*6","�ɶ�ý� ���� Ʈ��Ʈ��Ʈ","Ǫ���� �̼��������","���ϰ�������500g","CJ ����Ĩ",
					"����ũ ������500","����� ���� ��ũƼ","1+ ��޶� 10���� Ư","������ݺ���", "��ĵ�� ����Ʈ", "������Ʈ 3������",
					"����)����500ML","�㽬���ڹ�","��ȣ��","�������","aaaaaaaaaaaaaasssaaaaaaaaa","��ɴߴٸ��ʰ�"}; //��ǰ��
			public static int[] kopo41_price= {1000000,6900,5980,3300,5500,3380,6610,2750,10800,4980,3980,4480,
			         4980,3210,6950,2980,1990,1980000,3980,4480,3480,7980,700,1000,
			         1600,4000,1360,1180,3180,9990000}; //��ǰ���� 
			public static int[] kopo41_num= {99,10,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,3,1,2,1,1,1,2}; //��ǰ ���� ǰ�� ��
			public static boolean[] kopo41_tax= {true,true,true,true,true,true,false,true,false,false,true,false,
					true,true,true,true,true,true,true,true,true,true,true,true,
					true,true,false,false,true,true}; //�鼼�̸� false, �鼼 �ƴϸ� true
				
			public static int kopo41_netprice(int kopo41_price, double kopo41_rate) {
				// �Һ��� ����, ������ �Ű������� ����Ͽ� �Լ��� ȣ���� �� ���� �ҷ��´�
				return (int)(kopo41_price/(1+kopo41_rate)); // ���������� ����ȭ �ؼ� �Ҽ����� ������.
			}
				
			public static void main(String[] args) {
				int kopo41_itemCount = 30; // ���� �׸� ��
				
				kopo41_TitlePrint(); // ������ �� �� Ÿ��Ʋ �μ�
				kopo41_TimeStamp();  // ��½ð� �μ�
				kopo41_headerPrint(); // �ش�(��ǰ��, �ܰ�, ����, �ݾ�) �μ�
					
				for(int kopo41_i=0; kopo41_i<kopo41_itemCount; kopo41_i++) {
					kopo41_itemPrint(kopo41_i); // �׸� ������ŭ �׸� �μ�	
					}
				
				kopo41_totalPrint(); //�հ� ���� ���� �μ�
				}
				
				public static void kopo41_TitlePrint() { // ������ �� �� Ÿ��Ʋ �μ�
					System.out.printf("\n            �̸�Ʈ ������ (031)888-1234\n");
					System.out.printf("   emart    206-86-50913 ����\n");
					System.out.printf("\t    ���� ������ ������� 552\n\n");
					System.out.printf("������ �������� ��ȯ/ȯ�� �Ұ�\n");
					System.out.printf("�����ǰ�� ����, 30�� �̳�(�ż� 7��)\n");
					System.out.printf("���Ϻ� �귣����� ����(���� ����������)\n");
					System.out.printf("��ȯ/ȯ�� ���������� ����(����ī�� ����)\n\n");
				}
				
				public static void kopo41_TimeStamp() { // ��½ð� �μ�
					SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm"); //��¥�� �ð� ���� �����ϱ�
					System.out.printf("[�� ��]%s     POS:0011-9861\n",kopo41_sdt.format(kopo41_calt1.getTime())); //���� �ð����
				}
				
				public static void kopo41_headerPrint() { // �ش�(��ǰ��, �ܰ�, ����, �ݾ�) �μ�
					System.out.printf("-----------------------------------------\n");
					System.out.printf(" �� ǰ ��          �� ��  ����      �� ��\n");
					System.out.printf("-----------------------------------------\n");
				}
				
				public static void kopo41_itemPrint(int kopo41_i) { //���� �迭 �ε��� �޾� ��ǰ ���� ����ϱ�
					if(kopo41_tax[kopo41_i]==false){ // �鼼�� �̸�
						System.out.print("*"); // �����
					} else {
						System.out.print(" "); //��鼼 �׸��̸� ��ĭ ���
					}

					System.out.printf("%s%s %2d %s\n", // ���� ��ǰ ���� ���
							 kopo41_hanBlankBackword(kopo41_itemname[kopo41_i],16),
							 kopo41_hanBlankForeword(kopo41_df.format(kopo41_price[kopo41_i]),10),
							 kopo41_num[kopo41_i],
							 kopo41_hanBlankForeword(kopo41_df.format(kopo41_price[kopo41_i]*kopo41_num[kopo41_i]),10));
					
					if((kopo41_i+1)%5==0) { //��ǰ�� 5������ �� �ֱ�
						System.out.printf("-----------------------------------------\n");
					}
				}
				
				public static void kopo41_totalPrint() { //�հ� ���� ���� �μ�
					SimpleDateFormat kopo41_sdt2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); //��¥�� �ð� ���� �����ϱ� (�����ð�)
					SimpleDateFormat kopo41_sdt3 = new SimpleDateFormat("YYYYMMdd"); //��¥�� �ð� ���� �����ϱ� (���ڵ�)
					System.out.printf("\n");
					System.out.printf("        %14s%14s\n","�� ǰ�� ����",kopo41_itemname.length); // �� ǰ���� ����
					int kopo41_dutyfree = 0; //�鼼��ǰ �� ���� ���ϱ�
					int kopo41_duty = 0; //�鼼�� �ƴ� ��ǰ �� ���� ���ϱ�
					for(int kopo41_i=0; kopo41_i<kopo41_itemname.length; kopo41_i++) {
						if(kopo41_tax[kopo41_i]== false) { // �鼼 �� ���� ���ϱ�
							kopo41_dutyfree+=kopo41_price[kopo41_i]*kopo41_num[kopo41_i];
						} else { // ��鼼 �� ���� ���ϱ�
							kopo41_duty+=kopo41_price[kopo41_i]*kopo41_num[kopo41_i];
						}
					
					}
					int kopo41_netPrice = kopo41_netprice(kopo41_duty, 0.1); // ��鼼 ǰ�� �����ݾ� ���ϱ�
					int kopo41_totalsum = kopo41_dutyfree+kopo41_duty; // ��ü ���� 
					System.out.printf("        %15s    %10s\n","(*)�� ��  �� ǰ",kopo41_df.format(kopo41_dutyfree)); // �鼼���� ����
					System.out.printf("        %15s   %10s\n"," �� ��  �� ǰ",kopo41_df.format(kopo41_netPrice)); // ��鼼 ���� ����
					System.out.printf("         %15s    %10s\n","��   ��   ��",kopo41_df.format(kopo41_duty-kopo41_netPrice)); // ��鼼 ������ ����
					//���� �� ���ݿ��� �����ݾ��� ���� ������ ���Ѵ�.
					System.out.printf("          %15s   %9s\n","��        ��",kopo41_df.format(kopo41_totalsum)); //��鼼 ���ݰ� �鼼 ������ ����
					System.out.printf("%s%24s\n","�� �� �� �� �� ��",kopo41_df.format(kopo41_totalsum)); // �Һ��� ����
					System.out.printf("------------------------------------------\n");
					System.out.printf("0012 KEB �ϳ�       541707**0484/35860658\n");
					System.out.printf("ī�����(IC)     %7s / %s\n","�Ͻú�",kopo41_df.format(kopo41_totalsum)); //�Һ��� ����
					System.out.printf("------------------------------------------\n");
					System.out.printf("           [�ż��� ����Ʈ ����]\n");
					System.out.printf("��*�� ������ ����Ʈ ��Ȳ�Դϴ�.\n");
					int kopo41_point = kopo41_totalsum/1000; // ��ü ������ 1000���� ������ ����Ʈ�� ���Ѵ�.
					System.out.printf("��ȸ�߻�����Ʈ\t       9350**9995 %s\n",kopo41_df.format(kopo41_point)); 
					int kopo41_ponit2 = 5473; // ���� �� ���� ����Ʈ
					System.out.printf("����(����)����Ʈ       %s(%9s)\n",kopo41_df.format(kopo41_ponit2+kopo41_point),kopo41_df.format(kopo41_ponit2));
					// ���� ����Ʈ ���� �����ϰ� ���� �� �����Ǵ� ����Ʈ�� ���� ���� ����Ʈ�� ���Ѵ�.
					System.out.printf("*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.\n");
					System.out.printf("-----------------------------------------\n");
					System.out.printf("  ���űݾױ��� ���������ð� �ڵ��ο�\n");
					System.out.printf("������ȣ :                       34��****\n");
					System.out.printf("�����ð� :            %s\n",kopo41_sdt2.format(kopo41_calt1.getTime())); //�ʱ��� ������ ����ð�
					System.out.printf("-----------------------------------------\n");
					System.out.printf("ĳ��:084599 ��OO\t             1150\n");
					System.out.printf("      %s/00119861/00164980/31\n",kopo41_sdt3.format(kopo41_calt1.getTime()));
				}
				public static String kopo41_hanBlankForeword(String kopo41_str, int kopo41_num) {
					String kopo41_strF = kopo41_str; //�Ű��������� ���� ���� ������ �Ҵ��ϱ�
					if(kopo41_strF.length()>10) {
						kopo41_strF = kopo41_strF.substring(0,10);
					}
					byte[] kopo41_byteStrF = kopo41_strF.getBytes(); //���ڸ� byte�� �ٲ۴�.
					
					int kopo41_strLen = kopo41_strF.length(); //������ ��

					int kopo41_byteLen = kopo41_byteStrF.length; // ���ڸ� ����Ʈ�� ��ȯ���� �� ����Ʈ�� ��
				
					String kopo41_ret_str =""; //�ʱ� ���ڿ� ����
					
					for(int kopo41_i=0; kopo41_i<(kopo41_num-kopo41_byteLen);kopo41_i++) { 
						// ������ ���ڱ��̿��� ����Ʈ �迭�� ���� �� ��ŭ�� ������ ��´�
						kopo41_ret_str=kopo41_ret_str+" ";
					}
					kopo41_ret_str=kopo41_ret_str+kopo41_strF;
					//������ �߰��� �ڿ� ���ڿ��� ���Ѵ�
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
