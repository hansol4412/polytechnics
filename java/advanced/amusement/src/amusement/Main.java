package amusement;

import java.io.IOException;

public class Main {
	//����Ŭ����
	public static void main(String[] args) throws IOException{
		Input in = new Input(); //�Է� Ŭ����
		OriginalPrice_By_IdNum op = new OriginalPrice_By_IdNum(); //�ֹε�Ϲ�ȣ ó���Ͽ� ������ �ݾ��� ���ϴ� Ŭ����
		DiscountRate discount = new DiscountRate(); //��������ڵ忡 ���� ������ ���ϴ� Ŭ����
		CalculatorPrice price = new CalculatorPrice(); //������ ���ϴ� Ŭ����
		OutputPrint print = new OutputPrint(); //�ܼ�â�� ����� ����ϴ� Ŭ����
		OutputFile fw; //����� ���Ͽ� �����ϴ� Ŭ����
		SaveValue[] saveV = new SaveValue[10]; // ����� ������ ��� ���� Ŭ����
		int count =0; //SaveValueŬ���� �迭���� �ε��� ��ȣ
		int totalPrice = 0; //����
		
		
		
		while(true) {
			
			int ticketType = in.ticketType(); // ���� �Է¹ޱ�
			String idNum = in.idNum(); // �ֹε�Ϲ�ȣ �Է¹ޱ�
			int ticketCount = in.ticketCount(); //Ƽ�� ���� �Է¹ޱ�
			int discountCode = in.discountCode(); //������ �Է¹ޱ�
			
			int year = op.birth(idNum); //�ֹε�Ϲ�ȣ �޾� ������� ����
			int age = op.age(year); // ������Ͽ��� ���� ����
			int agecode = op.agePrice(age); //���̿��� ���� �ڵ�� ��ȯ
			int originalPrice = op.originalPrice(ticketType, agecode); // �����ڵ�� �����ڵ忡 ���� ������ ���� ���ϱ�
			
			double discountRate = discount.discount(discountCode); //������� �ڵ忡 ���� ������ ���ϱ�
			int finalPrice = price.eachPrice(originalPrice, ticketCount, discountRate); // �������� ������ �߰����� ���ϱ�
			
			saveV[count] = new SaveValue(ticketType,agecode,ticketCount,originalPrice,discountCode,finalPrice); //����� �����ϱ�
			print.printEachPrice(saveV[count]); //�߰����� ���
			
			//���Ϸ� �����ϱ�
			fw = new OutputFile();
			fw.headerWrite();
			fw.dataWrite(saveV[count]);
			fw.fileClose();
			
			count++;
			
			int continueBuyTicket = in.continueBuyTicket(); //�߱� ���࿩�� �Է¹ޱ�
			if(continueBuyTicket==ConstValue.CALCULATE_EXIT) break; //�ݺ��� �����ϰ� ����� ���
		}
		
		print.header(); //������
		for(int i=0; i<count; i++) {
			print.totalInfo(saveV[i]); // �� ��� ����
			totalPrice = price.totalPrice(saveV[i].finalPrice); // �����ݾ� ���ϴ� �Լ� ȣ��
		}
		print.totalPrice(totalPrice); //�����ݾ� ���
	}

}
