package chapter7;

public class Test1 {
		public static void main(String[] args) {
			System.out.printf("HanBlankForeword[%s]\n",kopo41_hanBlankForeword("�ѱ�abcd",15)); //�� ���� �ֱ�
			System.out.printf("HanBlankForeword[%s]\n",kopo41_hanBlankForeword("�ѱ��ѱ�aa",15)); //�� ���� �ֱ�
			System.out.printf("HanBlankBackword[%s]\n",kopo41_hanBlankBackword("�ѱ�aa",15)); //�� ���� �ֱ�
			System.out.printf("HanBlankBackword[%s]\n",kopo41_hanBlankBackword("�ѱ��ѱ�aa",15)); //�� ���� �ֱ�
			System.out.printf("�ѱ��� [%d]��\n",kopo41_hanCount("�ѱ��ѱ�aa")); // �ѱ� ���� ã��
		}
		
		public static String kopo41_hanBlankForeword(String kopo41_str, int kopo41_num) {
			String kopo41_strF = kopo41_str; //�Ű��������� ���� ���� ������ �Ҵ��ϱ�
			byte[] kopo41_byteStrF = kopo41_strF.getBytes(); //���ڸ� byte�� �ٲ۴�.
			
			int kopo41_strLen = kopo41_strF.length(); //������ ��
			//System.out.println(kopo41_strLen);
			int kopo41_byteLen = kopo41_byteStrF.length; // ���ڸ� ����Ʈ�� ��ȯ���� �� ����Ʈ�� ��
			//System.out.println(kopo41_byteLen);
			int kopo41_KorLen = kopo41_byteLen-kopo41_strLen; // �ѱ��� ���ڼ� 
			//System.out.println(kopo41_KorLen);
			int kopo41_EngLen = kopo41_strLen-kopo41_KorLen; // ������ ���ڼ� 
			//System.out.println(kopo41_EngLen);
					
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
			String kopo41_strB = kopo41_str; //�Ű��������� ���� ���� ������ �Ҵ��ϱ�
			byte[] kopo41_byteStrF = kopo41_strB.getBytes();  //���ڸ� byte�� �ٲ۴�.
			
			int kopo41_strLen = kopo41_strB.length(); //������ ��
			//System.out.println(kopo41_strLen);
			int kopo41_byteLen = kopo41_byteStrF.length; // ���ڸ� ����Ʈ�� ��ȯ���� �� ����Ʈ�� ��
			//System.out.println(kopo41_byteLen);
			int kopo41_KorLen = (kopo41_byteLen-kopo41_strLen)/2; // �ѱ��� ���ڼ� 
			//System.out.println(kopo41_KorLen);
			int kopo41_EngLen = kopo41_strLen-kopo41_KorLen; // ������ ���ڼ� 
			//System.out.println(kopo41_EngLen);
					
			String kopo41_ret_str =""; //�ʱ� ���ڿ� ����
			for(int kopo41_i=0; kopo41_i<(kopo41_num-kopo41_byteLen);kopo41_i++) {
				// ������ ���ڱ��̿��� ����Ʈ �迭�� ���� �� ��ŭ�� ������ ��´�
				kopo41_ret_str=kopo41_ret_str+" ";
			}
			kopo41_ret_str=kopo41_strB+kopo41_ret_str;
			//������ �߰��� �տ� ���ڿ��� ���Ѵ�
			return kopo41_ret_str; //���ڿ� ����
		}
		
		public static int kopo41_hanCount(String kopo41_str) {
			String kopo41_strC = kopo41_str; // �Է¹��� ����
			byte[] kopo41_byteStrC = kopo41_strC.getBytes(); //���ڸ� byte�� �ٲ۴�.
			
			int kopo41_strLen = kopo41_strC.length(); //������ ��
			int kopo41_byteLen = kopo41_byteStrC.length; // ���ڸ� ����Ʈ�� ��ȯ���� �� ����Ʈ�� ��
			
			//System.out.printf("kopo41_strLen[%d], kopo41_byteLen[%d] ����[%d]\n", kopo41_strLen, kopo41_byteLen, (kopo41_byteLen-kopo41_strLen));
			// �ѱ��� 2byte�� �����ϰ�, ����� 1byte�� ����Ѵ�.
			return (kopo41_byteLen-kopo41_strLen); // �ѱ��� ���� ����Ѵ�.
		}


}
