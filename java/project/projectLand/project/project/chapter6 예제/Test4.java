package chapter6;

public class Test4 {
	// 생성자 실습 - 리모콘 (최한솔)
	public static void main(String[] args) {
		Kopo41_TvRemocon2 kopo41_remocon = new Kopo41_TvRemocon2();
		//Kopo41_TvRemocon2클래스로 kopo41_remocon객체 생성
		
		for(int kopo41_i=0; kopo41_i<10; kopo41_i++) { // 채널 올리기
			kopo41_remocon.kopo41_channel_up();
			System.out.printf("[%s]\n", kopo41_remocon.kopo41_help);  
			//채널 정보 출력하기
		}
		
		for(int kopo41_i=0; kopo41_i<10; kopo41_i++) { //채널 내리기
			kopo41_remocon.kopo41_channel_down();
			System.out.printf("[%s]\n", kopo41_remocon.kopo41_help);
			//채널 정보 출력하기
		}
		
		for(int kopo41_i=0; kopo41_i<5; kopo41_i++) { //볼륨 올리기
			kopo41_remocon.kopo41_volume_up();
			System.out.printf("[%s]\n", kopo41_remocon.kopo41_help);
			//볼륨 정보 출력하기
		}
		
		for(int kopo41_i=0; kopo41_i<5; kopo41_i++) { //볼륨 내리기
			kopo41_remocon.kopo41_volume_down();
			System.out.printf("[%s]\n", kopo41_remocon.kopo41_help);
			//볼륨 정보 출력하기
		}
		
		/*
		Kopo41_TvRemocon2 kopo41_remocon2 = new Kopo41_TvRemocon2(5,5);
		System.out.printf("UP[%s]\n", kopo41_remocon2.kopo41_help);
		
		Kopo41_TvRemocon2 kopo41_remocon3 = new Kopo41_TvRemocon2(-5,-5);
		System.out.printf("DOWN[%s]\n", kopo41_remocon3.kopo41_help);
		*/

	}

}
