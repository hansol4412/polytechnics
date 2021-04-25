package chapter6;

public class Test5 {
	//클래스 상속하기 - 리모콘 (최한솔)
	public static void main(String[] args) {
		Kopo41_TvRemoconX kopo41_remocon = new Kopo41_TvRemoconX();
		// Kopo41_TvRemoconX 클래스로 kopo41_remocon 객체 생성
		for(int kopo41_i=0; kopo41_i<10; kopo41_i++) { //채널 올리기
			kopo41_remocon.kopo41_channel_up();
			//채널 정보 출력하기
			System.out.printf("[%s]\n", kopo41_remocon.kopo41_help);
		}
		
		for(int kopo41_i=0; kopo41_i<10; kopo41_i++) { //채널 내리기
			kopo41_remocon.kopo41_channel_down();
			//채널 정보 출력하기
			System.out.printf("[%s]\n", kopo41_remocon.kopo41_help);
		}
		
		for(int kopo41_i=0; kopo41_i<5; kopo41_i++) { //볼륨 올리기
			kopo41_remocon.kopo41_volume_up();
			//볼륨 정보 출력하기
			System.out.printf("[%s]\n", kopo41_remocon.kopo41_help);
		}
		
		for(int kopo41_i=0; kopo41_i<5; kopo41_i++) { //볼륨 내리기
			kopo41_remocon.kopo41_volume_down();
			//볼륨 정보 출력하기
			System.out.printf("[%s]\n", kopo41_remocon.kopo41_help);
		}
		kopo41_remocon.kopo41_checkBattery(); //건전지 체크하기
		System.out.printf("[%s]\n", kopo41_remocon.kopo41_help);
	}

}
