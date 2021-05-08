package chapter2;

public class Test3 {
	//문자열 실급
	public static void main(String[] args) {
		 String kopo41_name = "Ja" + "va"; // 문자열 더하기
		 String kopo41_str = kopo41_name + 8.0; // 문자열 더하기 뒤의 숫자는 8.0은 문자로 변해서 더한다.
		 
		 System.out.println(kopo41_name); // 문자열 출력해 확인
		 System.out.println(kopo41_str); // 문자열 출력해 확인
		 System.out.println(7+ " "); //7은 숫자, 뒤에 문자열 공백 추가 => 문자열로 변함
		 System.out.println(" "+7); //7이 문자열로 변하고 앞에 공백 추가
		 System.out.println(7+ ""); //7은 숫자, 뒤에 문자열 추가 => 문자열로 변함
		 System.out.println(""+7); //7이 문자열로 변하고 앞에 공백 추가
		 System.out.println(""+""); // 빈칸 출력
		 System.out.println(7+7+""); //앞에 숫자를 더하고 뒤에 문자열로 버꿔서 앞에서 숫자를 더한다.
		 System.out.println(""+7+7); // 이미 숫자가 문자열 취급당해서 14가 아닌 77이 나온다.
	}

}
