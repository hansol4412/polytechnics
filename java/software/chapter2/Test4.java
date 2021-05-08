package chapter2;

public class Test4 {
	// 문자열 실습
	public static void main(String[] args) {
		System.out.println('\'');   //앞에 \를 붙이면 특수문자를 붙일 수 없다
		System.out.println("abc\t123\b456");  // \t는 탭 출력 \b는 백스페이스이지만 이클립스에서 동작x
		System.out.println('\n'); // 행바꾸기
		System.out.println("\"Hello\""); // \붙여서 특수문자 출력
		System.out.println("c:\\"); // \을 출략하기 위헤 앞에 \를 붙인다
	}
}
