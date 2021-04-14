package chapter4;

public class Ex1 {
	// if문 예제 최한솔
	public static void main(String[] args) {
		int kopo41_score =85; // 점수 초기화
		
		if(kopo41_score > 60) { 
			//점수가 60점 초과이면 합격
			System.out.println("합격입니다.");
		} else {
			//점수가 60점 이하이면 불합격
			System.out.println("불합격입니다.");
		}
		
		int kopo41_num = 3;
		if(kopo41_num >0) {
			//숫자가 0보다 크면 양수이다.
			System.out.println("양수입니다.");
		} else if(kopo41_num < 0) {
			//숫자가 0보다 작으면 음수이다.
			System.out.println("음수입니다.");
		} else {
			// 0보다 크지도 않고 작지도 않으면 숫자는 0이다.
			System.out.println("영 입니다.");
		}
		
		if(kopo41_score >= 90) {
			// 점수가 90이상이면 A등급
			System.out.println("A등급");
		} else if (kopo41_score >=80 && kopo41_score <90) {
			// 점수가 80점 이상이고 90미만이면 B등급
			System.out.println("B등급");
		} else if (kopo41_score >=70 && kopo41_score <80) {
			// 점수가 70점 이상이고 80미만이면 B등급
			System.out.println("C등급");
		} else {
			// 위의 조건에 모두 충족되지 않으면 F등급
			System.out.println("F등급");
		}
	}

}
