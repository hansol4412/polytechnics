package database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;


public class Grade5 {
		static final int kopo41_iPerson = 1000; // �� �л��� ��
		static final int kopo41_iPerson_page = 30; //�������� ������� ũ��
		public static int kopo41_pageNum =1; //������ ��ȣ
		
		public static void main(String[] args) {
			
			for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) {
				//���
				if((kopo41_i)%kopo41_iPerson_page==0) { //30�� ����
					kopo41_HeaderPrint(); // �ش� ���
					kopo41_pageNum++; //������ ��ȣ ����
				}
				kopo41_ItemPrint(kopo41_i); // ���� �μ�
				if((kopo41_i)%kopo41_iPerson_page==(kopo41_iPerson_page-1)) { //30�� ���� 
					kopo41_page_info(kopo41_i-(kopo41_iPerson_page-1),kopo41_i); // �� �������� ����, ���
					kopo41_TailPrint();  //���� �μ�
				}
			}
			if(kopo41_iPerson%kopo41_iPerson_page!=0) { 
				//���� 30��� �ٿ��� ����, ��� �ѹ� ����ߴٸ� �� �ٽ� ����, ��� ������ ��Ÿ���� �ʾƵ� �ȴ�.
				kopo41_page_info((kopo41_iPerson_page*(kopo41_pageNum-2)),kopo41_iPerson-1); // �� �������� ����, ���
				kopo41_TailPrint();	//����, ��� ���� ���
			}
		}

		//�ش� �μ�
		public static void kopo41_HeaderPrint() { //�ش� ���
			Calendar kopo41_calt1 = Calendar.getInstance();
			SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); //��¥�� �ð� ���� �����ϱ�
			System.out.printf("\n\t\t  ���� ����ǥ\n\n");
			System.out.printf("PAGE: %d\t\t ��� ���� : %s\n",kopo41_pageNum,kopo41_sdt.format(kopo41_calt1.getTime()));
			System.out.printf("=======================================================\n");
			System.out.printf("  %2s\t%4s\t%2s\t%2s\t%2s\t%2s\t%2s \n","��ȣ","�̸�","����","����","����","�հ�","���");
			System.out.printf("=======================================================\n");
		}
		
		public static void kopo41_ItemPrint(int kopo41_i) { //���� ���
			Kopo41_OneRec1 kopo41_rec; //��ü ����
			kopo41_rec = kopo41_ArrayOneRec.get(kopo41_i);
			// ��ü�� ��̸���Ʈ���� ���� ���� �����Ѵ�.
			System.out.printf("%d\t%s\t%3d\t%3d\t%3d\t%3d\t%3d \n",
					kopo41_rec.kopo41_student_id(),kopo41_rec.kopo41_name(),kopo41_rec.kopo41_kor(),
					kopo41_rec.kopo41_eng(),kopo41_rec.kopo41_mat(),kopo41_rec.kopo41_sum(),(int)kopo41_rec.kopo41_avg());
			kopo41_sumKor+=kopo41_rec.kopo41_kor(); //���� �հ迡 �Լ��� ��µ� ���� ������ �������� ���Ѵ�.
			kopo41_sumEng+=kopo41_rec.kopo41_eng(); //���� �հ迡 �Լ��� ��µ� ���� ������ �������� ���Ѵ�.
			kopo41_sumMat+=kopo41_rec.kopo41_mat(); //���� �հ迡 �Լ��� ��µ� ���� ������ �������� ���Ѵ�.
			kopo41_sumsum+=kopo41_rec.kopo41_sum(); //���� �հ迡 �Լ��� ��µ� ���� ������ �������� ���Ѵ�.
			kopo41_sumAvg+=kopo41_rec.kopo41_avg(); //��� �հ迡 �Լ��� ��µ� ��� ������ �������� ���Ѵ�.
			if(kopo41_i != 0) { //0���� ������ �ȵȴ�.
				kopo41_avgkor=kopo41_sumKor/(kopo41_i+1); //���� ���� ���� ���
				kopo41_avgeng=kopo41_sumEng/(kopo41_i+1); //���� ���� ���� ���
				kopo41_avgmat=kopo41_sumMat/(kopo41_i+1); //���� ���� ���� ���
				kopo41_avgsum=kopo41_sumsum/(kopo41_i+1); //�� ���� ���� ���
				kopo41_avgavg=kopo41_sumAvg/(kopo41_i+1); //��� ���� ���� ���
			}
		}
		public static void kopo41_TailPrint() { //���� ��� ���
			
			System.out.printf("=======================================================\n");
			System.out.printf("����������\n"); //������ �� ���� ���
			System.out.printf("�հ� :\t\t%d\t%d\t%d\t%d\t%d\n",kopo41_sumKor_page,
					kopo41_sumEng_page,kopo41_sumMat_page,kopo41_sumSum_page,(int)kopo41_sumAvg_page);
			// ������ ���� ����, ����, ����, ����, ��� ������ ���� ���ϱ�
			System.out.printf("��� :\t\t%d\t%d\t%d\t%d\t%d\n",
					(int)kopo41_avgkor_page,(int)kopo41_avgeng_page,(int)kopo41_avgmat_page,
					(int)kopo41_avgsum_page,(int)kopo41_avgavg_page);
			// ������ ���� ����, ����, ����, ����, ��� ������ ��� ���ϱ�
			System.out.printf("=======================================================\n");
			System.out.printf("����������\n"); //���� �� ���� ���
			System.out.printf("�հ� :\t\t%d\t%d\t%d\t%d\t%d\n",kopo41_sumKor,
					kopo41_sumEng,kopo41_sumMat,kopo41_sumsum,(int)kopo41_sumAvg);
			// ������ ���� ������ ����, ����, ����, ����, ��� ������ ���� ���ϱ�
			System.out.printf("��� :\t\t%d\t%d\t%d\t%d\t%d\n",
					(int)kopo41_avgkor,(int)kopo41_avgeng,(int)kopo41_avgmat,
					(int)kopo41_avgsum,(int)kopo41_avgavg);
			// ������ ���� ������ ����, ����, ����, ����, ��� ������ ��� ���ϱ�
			System.out.printf("=======================================================\n\n");
		}
		
		public static void kopo41_page_info(int kopo41_start, int kopo41_finish) { 
			// �� �������� ���۰� �� ��ȣ�� �޾� �� ��ȣ�鸸 ���� ���հ� ����� ���ϴ� �Լ�
			kopo41_sumKor_page=0; //���� ������ �������� ���� �ʱ�ȭ
			kopo41_sumEng_page=0; //���� ������ �������� ���� �ʱ�ȭ
			kopo41_sumMat_page=0; //���� ������ �������� ���� �ʱ�ȭ
			kopo41_sumSum_page=0; //���� ������ ������ ���� �ʱ�ȭ
			kopo41_sumAvg_page=0; //���� ������ ��������� ���� �ʱ�ȭ
			
			int kopo41_gap = kopo41_finish-kopo41_start; 
			// ����ȣ���� ���۹�ȣ ���� �� ��� �����Ͱ� �ִ��� Ȯ�� => ��ձ��ϱ� ����
			
			for(int kopo41_j=kopo41_start; kopo41_j<=kopo41_finish; kopo41_j++ ) {
				Kopo41_OneRec1 kopo41_rec1 = kopo41_ArrayOneRec.get(kopo41_j);
				// ��ü�� ��̸���Ʈ���� ���� ���� �����Ѵ�.

				//������ ���۹�ȣ���� �� ��ȣ���� �� ����� ����, ����� ���� ���ϱ�
				kopo41_sumKor_page+=kopo41_rec1.kopo41_kor(); //���� ������ �������� ����
				kopo41_sumEng_page+=kopo41_rec1.kopo41_eng(); //���� ������ �������� ����
				kopo41_sumMat_page+=kopo41_rec1.kopo41_mat(); //���� ������ �������� ���� 
				kopo41_sumSum_page+=kopo41_rec1.kopo41_sum(); //���� ������ ������ ���� 
				kopo41_sumAvg_page+=(int)kopo41_rec1.kopo41_avg(); //���� ������ ��������� ����
			}
			kopo41_avgkor_page=kopo41_sumKor_page/(kopo41_gap+1); //���� ������ �������� ��� 
			kopo41_avgeng_page=kopo41_sumEng_page/(kopo41_gap+1); //���� ������ �������� ��� 
			kopo41_avgmat_page=kopo41_sumMat_page/(kopo41_gap+1); //���� ������ �������� ��� 
			kopo41_avgsum_page=kopo41_sumSum_page/(kopo41_gap+1); //���� ������ ������ ��� 
			kopo41_avgavg_page=kopo41_sumAvg_page/(kopo41_gap+1);  //���� ������ ��������� ��� 
			
		}

	}