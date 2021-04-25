package chapter6;

public class Test6 {
	// 클래스로 배열 생성하기 (최한솔)
	public static void main(String[] args) {
		int kopo41_iPerson = 30; //저장소의 크기
		Kopo41_InputData kopo41_inData = new Kopo41_InputData(kopo41_iPerson);
		// Kopo41_InputData의 클래스로 kopo41_inData객체를 생성한다.
		// 생성자로 저장소의 크기를 지정한다.
		
		for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) {
			String kopo41_name = String.format("홍길%02d", kopo41_i); //이름만들기
			int kopo41_kor = (int)(Math.random()*100); //국어점수 만들기
			int kopo41_eng = (int)(Math.random()*100); //영어점수 만들기
			int kopo41_mat = (int)(Math.random()*100); //수학점수 만들기
			kopo41_inData.kopo41_SetData(kopo41_i, kopo41_name, kopo41_kor, kopo41_eng, kopo41_mat);
			//클래스 내 값 입력
		}
		
		//저장소 내용 출력
		for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) {
			System.out.printf("번호:%d, 이름:%s, 국어:%d, 영어:%d, 수학:%d, 총점:%d, 평균:%f\n",
					kopo41_i,kopo41_inData.kopo41_name[kopo41_i],kopo41_inData.kopo41_kor[kopo41_i],
					kopo41_inData.kopo41_eng[kopo41_i], kopo41_inData.kopo41_mat[kopo41_i],
					kopo41_inData.kopo41_sum[kopo41_i], kopo41_inData.kopo41_avg[kopo41_i]);
		}
	}

}
