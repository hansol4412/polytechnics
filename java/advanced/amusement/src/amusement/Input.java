package amusement;

import java.util.Scanner;

public class Input {
	//�Է�Ŭ����
	Scanner stdIn = null;
	
	public Input() { //������
		stdIn = new Scanner(System.in); 
	}
	
	protected void finalize() { //�Ҹ���
		stdIn.close();
	}
	
	public int ticketType() {
		// ���� �Է¹ޱ�
		System.out.println("������ �����ϼ���.\n"
				+ "1. �ְ���\n"
				+ "2. �߰���");
		String ticketType= stdIn.next();
		if(!(ticketType.equals("1") || ticketType.equals("2"))) {
			System.out.println("�߸��� ���ڸ� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
			ticketType= this.ticketType()+"";
		}
		return Integer.parseInt(ticketType);
	}
	
	public String idNum() {
		//�ֹι�ȣ �Է¹ް� �˻�
		System.out.println("�ֹι�ȣ�� �Է��ϼ���. (\"-\"�� �����ϰ� �Է��Ͻÿ�.)");
	
		String idNum = stdIn.next();
		if(idNum.length()!=13) {
			System.out.println("�߸��� �ֹε�Ϲ�ȣ�� �Է��߽��ϴ�. �ٽ� �Է��ϼ���");
			idNum = this.idNum();
		} 

		if(Integer.parseInt(idNum.substring(0, 2))>=30 && !(idNum.substring(6, 7).equals("1") || idNum.substring(6, 7).equals("2"))) {
			System.out.println("�߸��� �ֹε�Ϲ�ȣ�� �Է��߽��ϴ�. �ٽ� �Է��ϼ���");
			idNum = this.idNum();
		}
		
		if(Integer.parseInt(idNum.substring(0, 2))<30 && !(idNum.substring(6, 7).equals("3") || idNum.substring(6, 7).equals("4"))) {
			System.out.println("�߸��� �ֹε�Ϲ�ȣ�� �Է��߽��ϴ�. �ٽ� �Է��ϼ���");
			idNum = this.idNum();
		}
			
		return idNum;
	}
	
	public int ticketCount() {
		//Ƽ�� ���� �Է¹ޱ�
		System.out.println("��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");
		String ticketCount = stdIn.next();
		if(!(ticketCount.equals("1") || ticketCount.equals("2") || ticketCount.equals("3") || ticketCount.equals("4") || ticketCount.equals("5")
				|| ticketCount.equals("6") || ticketCount.equals("7") || ticketCount.equals("8") || ticketCount.equals("9") || ticketCount.equals("10"))) {
			System.out.println("�ִ� 10���� ǥ�� ������ �� �ֽ��ϴ�.");
			ticketCount = this.ticketCount()+"";
		}
		return Integer.parseInt(ticketCount);
	}
	
	public int discountCode() {
		// ������ �Է¹ޱ�
		System.out.println("�������� �����ϼ���.\n"
				+ "1. ���� (���� ��� �ڵ�ó��)\n"
				+ "2. ����� \n"
				+ "3. ���� ������\n"
				+ "4. ���ڳ� \n"
				+ "5. �ӻ��");
		String discountCode = stdIn.next();
		if(!(discountCode.equals("1") || discountCode.equals("2") || discountCode.equals("3") || discountCode.equals("4") || discountCode.equals("5"))) {
			System.out.println("�߸��� ���ڸ� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
			discountCode = this.discountCode()+"";
		}
		return  Integer.parseInt(discountCode);
	}
	
	public int continueBuyTicket() {
		// �߱� ���� ���� �Է¹ޱ�
		System.out.println("��� �߱��ֹ��� �Ͻðڽ��ϱ�?\n"
				+ "1. �ֹ��ϱ�\n"
				+ "2. ����ϱ�");
		String continueValue =  stdIn.next();
		if(!(continueValue.equals("1") || continueValue.equals("2"))) {
			System.out.println("�߸��� ���ڸ� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
			continueValue =  this.continueBuyTicket()+"";
		}
		return Integer.parseInt(continueValue);
	}	
}
