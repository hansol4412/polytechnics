package chapter7;

public class Test1 {
		public static void main(String[] args) {
			System.out.printf("HanBlankForeword[%s]\n",kopo41_hanBlankForeword("한글abcd",15)); //앞 공백 넣기
			System.out.printf("HanBlankForeword[%s]\n",kopo41_hanBlankForeword("한글한글aa",15)); //앞 공백 넣기
			System.out.printf("HanBlankBackword[%s]\n",kopo41_hanBlankBackword("한글aa",15)); //뒷 공백 넣기
			System.out.printf("HanBlankBackword[%s]\n",kopo41_hanBlankBackword("한글한글aa",15)); //뒷 공백 넣기
			System.out.printf("한글은 [%d]개\n",kopo41_hanCount("한글한글aa")); // 한글 갯수 찾기
		}
		
		public static String kopo41_hanBlankForeword(String kopo41_str, int kopo41_num) {
			String kopo41_strF = kopo41_str; //매개변수에서 받은 문자 변수에 할당하기
			byte[] kopo41_byteStrF = kopo41_strF.getBytes(); //문자를 byte로 바꾼다.
			
			int kopo41_strLen = kopo41_strF.length(); //문자의 수
			//System.out.println(kopo41_strLen);
			int kopo41_byteLen = kopo41_byteStrF.length; // 문자를 바이트로 변환했을 때 바이트의 수
			//System.out.println(kopo41_byteLen);
			int kopo41_KorLen = kopo41_byteLen-kopo41_strLen; // 한글의 문자수 
			//System.out.println(kopo41_KorLen);
			int kopo41_EngLen = kopo41_strLen-kopo41_KorLen; // 영어의 문자수 
			//System.out.println(kopo41_EngLen);
					
			String kopo41_ret_str =""; //초기 문자열 설정
			
			for(int kopo41_i=0; kopo41_i<(kopo41_num-kopo41_byteLen);kopo41_i++) { 
				// 지정한 문자길이에서 바이트 배열의 수를 뺀 만큼을 공백을 찍는다
				kopo41_ret_str=kopo41_ret_str+" ";
			}
			kopo41_ret_str=kopo41_ret_str+kopo41_strF;
			//공백을 추가한 뒤에 문자열을 더한다
			return kopo41_ret_str; //문자열 리턴
		}

		public static String kopo41_hanBlankBackword(String kopo41_str, int kopo41_num) {
			String kopo41_strB = kopo41_str; //매개변수에서 받은 문자 변수에 할당하기
			byte[] kopo41_byteStrF = kopo41_strB.getBytes();  //문자를 byte로 바꾼다.
			
			int kopo41_strLen = kopo41_strB.length(); //문자의 수
			//System.out.println(kopo41_strLen);
			int kopo41_byteLen = kopo41_byteStrF.length; // 문자를 바이트로 변환했을 때 바이트의 수
			//System.out.println(kopo41_byteLen);
			int kopo41_KorLen = (kopo41_byteLen-kopo41_strLen)/2; // 한글의 문자수 
			//System.out.println(kopo41_KorLen);
			int kopo41_EngLen = kopo41_strLen-kopo41_KorLen; // 영어의 문자수 
			//System.out.println(kopo41_EngLen);
					
			String kopo41_ret_str =""; //초기 문자열 설정
			for(int kopo41_i=0; kopo41_i<(kopo41_num-kopo41_byteLen);kopo41_i++) {
				// 지정한 문자길이에서 바이트 배열의 수를 뺀 만큼을 공백을 찍는다
				kopo41_ret_str=kopo41_ret_str+" ";
			}
			kopo41_ret_str=kopo41_strB+kopo41_ret_str;
			//공백을 추가한 앞에 문자열을 더한다
			return kopo41_ret_str; //문자열 리턴
		}
		
		public static int kopo41_hanCount(String kopo41_str) {
			String kopo41_strC = kopo41_str; // 입력받은 문자
			byte[] kopo41_byteStrC = kopo41_strC.getBytes(); //문자를 byte로 바꾼다.
			
			int kopo41_strLen = kopo41_strC.length(); //문자의 수
			int kopo41_byteLen = kopo41_byteStrC.length; // 문자를 바이트로 변환했을 때 바이트의 수
			
			//System.out.printf("kopo41_strLen[%d], kopo41_byteLen[%d] 차이[%d]\n", kopo41_strLen, kopo41_byteLen, (kopo41_byteLen-kopo41_strLen));
			// 한글은 2byte를 차지하고, 영어는 1byte를 출력한다.
			return (kopo41_byteLen-kopo41_strLen); // 한글의 수를 출력한다.
		}


}
