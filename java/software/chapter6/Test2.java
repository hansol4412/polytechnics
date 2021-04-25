package chapter6;

public class Test2 {
	// 클래스, 객체, 인스턴스 실습 - 리모콘 (최한솔)
	public static void main(String[] args) {
		Kopo41_TvRemocon kopo41_remo = new Kopo41_TvRemocon(); 
		//Kopo41_TvRemocon로 kopo41_remo객체 생성
		int kopo41_volume = 37; //초기 볼륨 지정
		int kopo41_channel = 45; //초기 채널 지정
		
		for(int kopo41_i =0; kopo41_i<5; kopo41_i++ ) { //볼륨 5번 올리기
			kopo41_volume = kopo41_remo.kopo41_volUP(kopo41_volume); 
			//kopo41_remo의 kopo41_volUP함수로 볼륨 올려 값지정
			System.out.println("볼륨 크기 : " + kopo41_volume); // 볼륨 출력
		}
		
		for(int kopo41_i =0; kopo41_i<5; kopo41_i++ ) { //볼륨 5번 내리기
			kopo41_volume =  kopo41_remo.kopo41_volDown(kopo41_volume); 
			//kopo41_remo의 kopo41_volDown함수로 볼륨 내려 값지정
			System.out.println("볼륨 크기 : " +kopo41_volume); //볼륨출력
		}
		
		for(int kopo41_i =0; kopo41_i<10; kopo41_i++ ) { //채널 10번 올리기
			kopo41_channel = kopo41_remo.kopo41_channelUP(kopo41_channel); 
			//kopo41_remo의 kopo41_channelUP함수로 채널올려 값 지정
			System.out.println("채널 번호 : " + kopo41_channel); //채널 출력
		}
		
		for(int kopo41_i =0; kopo41_i<10; kopo41_i++ ) { //채널 10번 내리기
			kopo41_channel = kopo41_remo.kopo41_channelDown(kopo41_channel); 
			//kopo41_remo의 kopo41_channelDown함수로 채널내려 값 지정
			System.out.println("채널 번호 : " + kopo41_channel); //채널 출력
		}

	}

}
