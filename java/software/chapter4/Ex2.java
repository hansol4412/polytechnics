package chapter4;

public class Ex2 {
	// switch문 예제 최한솔
	public static void main(String[] args) {
		String kopo41_jumin="123456-1234567";
		
		switch(kopo41_jumin.charAt(7)){ 
		case '1': //문자열 인덱스 7의 자리에 수가 1이면 20세기에 태어난 남자 사람
			System.out.printf("20세기에 태어난 남자 사람 \n"); 
			//break문이 없다면 case'1'에서 멈추지 않고 다음 break를 만날 때 까지 밑의 코드를 다 실행한다.
		case '2' : //문자열 인덱스 7의 자리에 수가 2이면 20세기에 태어난 여자 사람
			System.out.printf("20세기에 태어난 여자 사람 \n");
			break;
		case '3': //문자열 인덱스 7의 자리에 수가 3이면 20세기 후에 태어난 남자 사람
			System.out.printf("20세기 후에 태어난 남자 사람\n");
			break;
		case '4' : //문자열 인덱스 7의 자리에 수가 4이면 20세기 후에 태어난 여자 사람
			System.out.printf("20세기 후에 태어난 여자 사람 \n");
			break; 
		default :
			System.out.printf("사람입니다\n");  //위의 조건에 모두 충족되지 않을 때 그냥 사람
			break;
		}
	}

}
