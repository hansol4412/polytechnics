package amusement;
	//���Ŭ����
public class OutputPrint {
	public void printEachPrice(SaveValue saveV) {
		System.out.printf("������ %d�� �Դϴ�.\n",saveV.finalPrice);
	}
	
	public void header() {
		System.out.println("===============��������================");
	}
	
	public void totalInfo(SaveValue saveV) {
		System.out.printf("%s  %s  x  %d    %d    *�������(%s)\n",
				saveV.ticketTypeCode, saveV.ageCode, saveV.ticketCount, saveV.originalPrice*saveV.ticketCount, saveV.discountType);
	}
	
	public void totalPrice(int totalPrice) {
		System.out.printf("����� �Ѿ��� %d�Դϴ�.\n",totalPrice);
	}
}
