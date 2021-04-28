package amusement;
	//�ֹ� ���� ���� ������ ��Ƴ��� Ŭ����
public class SaveValue {
	String ticketTypeCode; //Ƽ�ϱ����ڵ�
	String ageCode; //�����ڵ� 
	int ticketCount; // Ƽ�ϼ���
	int originalPrice; // ������ �����ϱ� �� ����
	String discountType; // ���� ���� �ڵ�
	int finalPrice; //������ ������ �� ����
	
	//�����ڷ� �� �����ϱ�
	public SaveValue(int ticketTypeCode, int ageCode, int ticketCount, int originalPrice, int discountCode, int finalPrice) {
		
		if(ticketTypeCode==ConstValue.DAY_CODE) {
			this.ticketTypeCode = "�ְ���";
		} else {
			this.ticketTypeCode = "�߰���";
		}
		
		if(ageCode == ConstValue.ADULT_CODE) {
			this.ageCode ="����";
		} else if(ageCode == ConstValue.TEEN_CODE) {
			this.ageCode ="û�ҳ�";
		} else if(ageCode == ConstValue.CHILD_CODE) {
			this.ageCode ="����";
		} else if(ageCode == ConstValue.OLD_CODE) {
			this.ageCode ="���";
		} else {
			this.ageCode ="����(����)";
		}

		this.ticketCount = ticketCount;
		this.originalPrice = originalPrice;
		
		if(discountCode == ConstValue.DISABLE_DISCOUNT_CODE) {
			discountType="�����";
		} else if(discountCode == ConstValue.MERIT_DISCOUNT_CODE) {
			discountType="����������";
		} else if(discountCode == ConstValue.MULTICHILD_DISCOUNT_CODE) {
			discountType="���ڳ�";
		} else if(discountCode == ConstValue.PREGNANT_DISCOUNT_CODE){
			discountType="�ӻ��";
		} else {
			discountType="����";
		}
		
		this.finalPrice = finalPrice;
	}
	
}

