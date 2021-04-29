package chapter7;

import java.text.DecimalFormat;

public class Test2 {
	// ���� ���̿��� �ʵ� ���� ó�� (���Ѽ�)
	public static void main(String[] args) {
		DecimalFormat kopo41_df = new DecimalFormat("00"); // ���� ǰ�� ��ȣ ��
		DecimalFormat kopo41_df2 = new DecimalFormat("###,###,###,###,###"); // ���� �޸���� ����
		String[] kopo41_oneRec = {
				" ����Ȩ �ڵ�ũ��  	 7,500   2   15,000",
				" ���� ����ȭ��   	 6,900   1    6,900",
				" ��������E     	 5,980   1    5,980",
				" ���� ���Ϸ� �� 	 3,300   1    3,300",
				" ����Ȩ �ڵ����  	 5,500   2   11,000",
				" ��� �Ŷ��    	 3,380   1    3,380",
				"*����������  	 6,610   1    6,610",
				" ���ѱ� ������� 1	 2,750   1    2,750",
				"*GAP ������ 6	10,800   1   19,800",
				"*�� ����� �ٳ��� 	 4,980   1    4,980",
				" ����ũ ����̿��� 	 3,980   1    3,980",
				"*���� ���ִ� ����G	 4,480   1    4,480",
				" ���������÷�10��	 4,980   1    4,980",
				" ����� ����(��)6	 3,210   1    3,210",
				" �ɶ�ý� ���� Ʈ��	 6,950   1    8,950",
				" Ǫ���� �̼��������	 2,980   2    5,960",
				" ���Ϸν���������50	 1,990   1    1,990",
				" CJ ����Ĩ   	 1,980   1    1,980",
				" ����ũ �����ⱹ5	 3,980   1    3,980",
				" ����� ���� ��ũƼ	 4,480   1    4,480",
				" 1+ ��޶� 10��	 3,480   2    6,960",
				" ������ݺ���    	 7,980   1    7,980",
				" ��ĵ�� ����Ʈ  	 1,000   1    1,000",
				" ������Ʈ 3������ 	 1,000   3    3,000",
				" ����)����500ML	 1,600   1    1,600",
				" �㽬���ڹ�     	 4,000   2    9,000",
				"*��ȣ��       	 1,360   1    1,360",
				"*�������     	 1,180   1    1,180",
				" ������������    	 3,180   1    3,180",
				" ��ɴߴٸ��ʰ�   	 1,980   1    2,980"
		};
		
		//��ǰ��
		String[] kopo41_name = new String[kopo41_oneRec.length]; // ��ǰ�� �迭�� ����
		for(int kopo41_i=0; kopo41_i<kopo41_name.length; kopo41_i++) {
			kopo41_name[kopo41_i] = kopo41_oneRec[kopo41_i].substring(1, 11);
			// �� �迭���� 1���� �ε������� 11��° �ε��� ������ ���� �����ؼ� kopo41_name �迭�� �ִ´�.
		}
		
		// ���� ���� ����
		String[] kopo41_originalPrice = new String[kopo41_oneRec.length];  // ��ǰ ���� �迭�� ���� (��Ʈ��)
		int[] kopo41_originalPriceInt = new int[kopo41_oneRec.length]; // ��ǰ ���� �迭�� ���� (������)
		for(int kopo41_i=0; kopo41_i<kopo41_originalPrice.length; kopo41_i++) {
			kopo41_originalPrice[kopo41_i] = kopo41_oneRec[kopo41_i].substring(12, 18);
			// �� �迭���� 12���� �ε������� 18��° �ε��� ������ ���� �����ؼ� kopo41_originalPrice �迭�� �ִ´�.
			kopo41_originalPrice[kopo41_i] = kopo41_originalPrice[kopo41_i].replaceAll(",", "");
			// kopo41_originalPrice ���ݿ� �޸��� ������ replaceAll �޼ҵ带 �̿��ؼ� �޸��� ���ش�
			kopo41_originalPrice[kopo41_i] = kopo41_originalPrice[kopo41_i].replaceAll(" ", "");
			// kopo41_originalPrice ���ݿ� ��ĭ�� ������ replaceAll �޼ҵ带 �̿��ؼ� ��ĭ�� ���ش�
			kopo41_originalPriceInt[kopo41_i] = Integer.parseInt(kopo41_originalPrice[kopo41_i]);
			// ��ĭ�� �޸��� ���� ���ڿ��� ���������� �ٲ㼭 kopo41_originalPriceInt�迭�� �ִ´�.
		}
		
		// ���� ǰ�� �� ������ ����
		String[] kopo41_originalCnt = new String[kopo41_oneRec.length]; //��ǰ ���� ���� �迭�� ���� (��Ʈ��)
		int[] kopo41_originalCntInt = new int[kopo41_oneRec.length]; //��ǰ ���� ���� �迭�� ���� (������)
		
		for(int kopo41_i=0; kopo41_i<kopo41_originalCnt.length; kopo41_i++) {
			kopo41_originalCnt[kopo41_i] = kopo41_oneRec[kopo41_i].substring(21,22);
			// �� �迭���� 21���� �ε������� 22��° �ε��� ������ ���� �����ؼ� kopo41_originalCnt �迭�� �ִ´�.
			kopo41_originalCntInt[kopo41_i] = Integer.parseInt(kopo41_originalCnt[kopo41_i]);
			//  ���ڿ��� ���������� �ٲ㼭 kopo41_originalCntInt�迭�� �ִ´�.
		}

		// ���� ǰ�� �� ����� ����
		String[] kopo41_CalPrice = new String[kopo41_oneRec.length]; //��ǰ ��� ���� �迭�� ���� (��Ʈ��)
		int[] kopo41_CallPriceInt = new int[kopo41_oneRec.length]; //��ǰ ��� ���� �迭�� ���� (������)
		for(int kopo41_i=0; kopo41_i<kopo41_CalPrice.length; kopo41_i++) {
			kopo41_CalPrice[kopo41_i] = kopo41_oneRec[kopo41_i].substring(25);
			// �� �迭���� 25���� �ε������� ������ ���� �����ؼ� kopo41_originalPrice �迭�� �ִ´�.
			kopo41_CalPrice[kopo41_i] = kopo41_CalPrice[kopo41_i].replaceAll(",", "");
			// kopo41_CalPrice ���ݿ� �޸��� ������ replaceAll �޼ҵ带 �̿��ؼ� �޸��� ���ش�
			kopo41_CalPrice[kopo41_i] = kopo41_CalPrice[kopo41_i].replaceAll(" ", "");
			// kopo41_CalPrice ���ݿ� ��ĭ�� ������ replaceAll �޼ҵ带 �̿��ؼ� ��ĭ�� ���ش�
			kopo41_CallPriceInt[kopo41_i] = Integer.parseInt(kopo41_CalPrice[kopo41_i]);
			// ��ĭ�� �޸��� ���� ���ڿ��� ���������� �ٲ㼭 kopo41_CallPriceInt�迭�� �ִ´�.
		}
		for(int kopo41_i=0; kopo41_i<kopo41_oneRec.length; kopo41_i++) {
			if(kopo41_originalPriceInt[kopo41_i]*kopo41_originalCntInt[kopo41_i] != kopo41_CallPriceInt[kopo41_i]) {
				// ��ǰ ���ݰ� ��ǰ ������ ������ ���� �Ͱ� ��ǰ ����� �ٸ��ٸ� ������ ��ģ��.
				System.out.printf("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�\n");
				System.out.printf("����[%s  %s %6s                   %2d        %6s]\n", //���� ���
						kopo41_df.format(kopo41_i),kopo41_hanBlankBackword(kopo41_name[kopo41_i], 30),kopo41_df2.format(kopo41_originalPriceInt[kopo41_i]),
						kopo41_originalCntInt[kopo41_i], kopo41_df2.format(kopo41_CallPriceInt[kopo41_i]));
				System.out.printf("����[%s  %s %6s                   %2d        %6s]\n", //���� ���
						kopo41_df.format(kopo41_i),kopo41_hanBlankBackword(kopo41_name[kopo41_i], 30),kopo41_df2.format(kopo41_originalPriceInt[kopo41_i]),
						kopo41_originalCntInt[kopo41_i], kopo41_df2.format(kopo41_originalPriceInt[kopo41_i]*kopo41_originalCntInt[kopo41_i]));
				System.out.printf("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�\n");
			}
		}
	}
	
	//��ǰ�� ��¿��� ĭ�� ���߱� ���� �Լ�
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
