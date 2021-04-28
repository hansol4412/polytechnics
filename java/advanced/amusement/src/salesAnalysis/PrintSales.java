package salesAnalysis;

import java.util.ArrayList;

public class PrintSales {

	public void fullInfo(ArrayList<String> data,String[][] dataArray) {
		System.out.println("-------------------------------------amusement.csv------------------------------------------");
		System.out.printf("%s\t\t%s\t\t%s\t%s\t\t%s\t\t%s\n",
				dataArray[0][0],dataArray[0][1],dataArray[0][2],dataArray[0][3],dataArray[0][4],dataArray[0][5]);
		
		
		for(int i=1; i<data.size(); i++) {
			System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
					dataArray[i][0],dataArray[i][1],dataArray[i][2],dataArray[i][3],dataArray[i][4],dataArray[i][5]);
		}
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public void ticketType_age(TicketType_Age ta) {
		System.out.println("\n------------------------------------������ ������Ȳ-----------------------------------------");
		System.out.println("�ְ��� �� "+ta.day_cnt+"��");
		System.out.printf("���� %d��\t ��� %d��\t û�ҳ� %d��\t � %d��\t ���� %d��\n",ta.baby_day,ta.child_day,ta.teem_day,ta.adult_day,ta.old_day);
		System.out.println("�ְ��� ���� : "+ta.day_price);
		System.out.println();
		System.out.println("�߰��� �� "+ta.night_cnt+"��");
		System.out.printf("���� %d��\t ��� %d��\t û�ҳ� %d��\t � %d��\t ���� %d��\n",ta.baby_night,ta.child_night,ta.teem_night,ta.adult_night,ta.old_night);
		System.out.println("�߰��� ���� : "+ta.night_price);
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public void dateAnalysis(ArrayList<Integer> dateData, int[] totalPrice) {
		System.out.println("\n------------------------------------���ں� �Ǹ���Ȳ-----------------------------------------");
		for(int i=0; i<dateData.size(); i++) {
			System.out.printf("%s�� %s�� %s�� : %d�� \n",(dateData.get(i)+"").substring(0, 4),(dateData.get(i)+"").substring(4, 6),(dateData.get(i)+"").substring(6, 8),totalPrice[i]);
		}
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public void discountAnalysis(Discount dis) {
		System.out.println("\n------------------------------------���� �Ǹ���Ȳ-----------------------------------------");
		System.out.printf("%s\t\t : %d��\n","�� �Ǹ� Ƽ�ϼ�",dis.totalCnt);
		System.out.printf("%s\t\t : %d��\n","��� ����",dis.noDiscount);
		System.out.printf("%s\t\t\t : %d��\n","�����",dis.disable);
		System.out.printf("%s\t\t : %d��\n","����������",dis.merit);
		System.out.printf("%s\t\t\t : %d��\n","���ڳ�",dis.multichild);
		System.out.printf("%s\t\t\t : %d��\n","�ӻ��",dis.pregnant);
		System.out.println("--------------------------------------------------------------------------------------------");
	}
}

