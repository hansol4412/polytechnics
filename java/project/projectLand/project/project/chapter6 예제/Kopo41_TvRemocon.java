package chapter6;

public class Kopo41_TvRemocon {
	public int kopo41_volUP(int kopo41_volume) { //볼륨을 올리는 함수
		if(kopo41_volume>=40) { // 볼륨이 40이상이면 더 이상 올라가지 않는다
			System.out.println("최대 볼륨입니다."); //최대 볼륨이라고 알린다
			return 40; //40이 넘어가면 더 큰 값을 리턴하지 않고 40을 리턴한다.
		} else {
			kopo41_volume = kopo41_volume+1; // 볼륨이 40보다 낮으면 값을 올린다
			return kopo41_volume; //볼륨 리턴
		}
	}
	
	public int kopo41_volDown(int kopo41_volume) { //볼륨을 낮추는 함수
		if(kopo41_volume<=0) { //볼륨이 0보다 낮으면 더 이상 내려가지 않는다
			System.out.println("최소 볼륨입니다."); //최소 볼륨이라고 알린다
			return 0; //값을 계속 내리려고 해도 0에서 더 이상 내려가지 않는다.
		} else {
			kopo41_volume = kopo41_volume-1; //값이 0이 아니라면 볼륨값이 내려간다.
			return kopo41_volume; //볼륨값 리턴
		}
	}
	
	public int kopo41_channelUP(int kopo41_channel) { //채널을 올리는 함수
		if(kopo41_channel>=50) { //채널이 50이상이면 더 이상 올라가지 않고 채널 0으로 가서 채널이 순환한다.
			System.out.println("마지막 채널입니다. 다시 채널 0으로 돌아갑니다."); //마지막 채널이라고 알리다.
			return 0; //채널 0으로 돌아가기
		} else {
			kopo41_channel = kopo41_channel+1; //마지막 채널이 아니라면 채널을 계속 올린다
			return kopo41_channel; //채널을 리턴
		}
	}
	
	public int kopo41_channelDown(int kopo41_channel) { //채널을 내리는 함수
		if(kopo41_channel<=0) { //채널이 0이면 최소채널이므로 마지막 채널인 50으로 가서 채널 순환한다.
			System.out.println("처음 채널입니다. 채널 50으로 올라갑니다."); //처음 채널이라고 알리고 채널 50으로 간다.
			return 50; //채널 50으로 순환하기
		} else {
			kopo41_channel = kopo41_channel-1; //최소 체널이 아니라면 계속 채널 내리기
			return kopo41_channel; //채널값 리턴
		}
	}
}
