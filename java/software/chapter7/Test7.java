package chapter7;

public class Test7 {
	//클래스의 배열
	public static void main(String[] args) {
		int kopo41_iPerson = 5;
		
		Kopo41_OneRec[] kopo41_inDate = new Kopo41_OneRec[kopo41_iPerson];
		//Kopo41_OneRec클래스 형식으로 값을 받는 배열을 형성
		
		kopo41_inDate[0] = new Kopo41_OneRec("홍길01",100,100,90); // 각 배열마다 인스턴스 생성
		kopo41_inDate[1] = new Kopo41_OneRec("홍길02",90,90,90); // 각 배열마다 인스턴스 생성
		kopo41_inDate[2] = new Kopo41_OneRec("홍길03",80,70,90); // 각 배열마다 인스턴스 생성
		kopo41_inDate[3] = new Kopo41_OneRec("홍길04",70,60,90); // 각 배열마다 인스턴스 생성
		kopo41_inDate[4] = new Kopo41_OneRec("홍길05",60,100,90); // 각 배열마다 인스턴스 생성
		
		for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) { //정보출력
			System.out.printf("이름 : %s, 국어 : %3d, 영어 : %3d, 수학 : %3d, 총합 : %3d, 평균 : %f \n",
					kopo41_inDate[kopo41_i].kopo41_name(),kopo41_inDate[kopo41_i].kopo41_kor(),
					kopo41_inDate[kopo41_i].kopo41_eng(), kopo41_inDate[kopo41_i].kopo41_mat(),
					kopo41_inDate[kopo41_i].kopo41_sum(), kopo41_inDate[kopo41_i].kopo41_avg());
		}
		//각각의 함수를 호출하여 값을 출력한다.
		
	}
}
