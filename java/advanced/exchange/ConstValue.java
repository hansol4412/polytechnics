package kyd;

public class ConstValue {
	// 상수 하나의 클래스에 모아 넣기
	// static을 붙여 객체 생성 없이 클래스명.변수명으로 불러 들일 수 있다
	final static int EX_TYPE_EXIT = 0;
	final static int EX_TYPE_USD = 1;
	final static int EX_TYPE_EUR = 2;
	final static int EX_TYPE_JPY = 3;
	
	final static double EX_RATE_USD = 1127.30;
	final static double EX_RATE_EUR = 1327.11;
	final static double EX_RATE_JPY = 1019.47;
	
	final static String FILEPATH = "C:\\Users\\hanso\\OneDrive\\바탕 화면\\exchange.csv";
}
