package chapter2;

public class Test9 {
	// 실수형, 정수형 변환
	public static void main(String[] args) {
		double kopo41_d = 85.4; // 실수형 숫자 초기화
		int kopo41_score = (int)kopo41_d; // 실수형 (int)를 사용하여 형 변환해서 소숫점 날리기
		
		System.out.println("score="+kopo41_score); //kopo41_score 값 출력해서 확인
		System.out.println("d="+kopo41_d); //정수형으로 변한 kopo41_score값 출력해서 확인
	}

}
