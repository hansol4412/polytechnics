package chapter6;

public class Kopo41_TvRemocon2 {
		int kopo41_limit_up_channel; //최상위 채널
		int kopo41_limit_down_channel; //최하위 채널
		int kopo41_limit_up_volume; //최상위 볼륨
		int kopo41_limit_down_volume; //최하위 볼륨
		int kopo41_channel; //채널 조정
		int kopo41_volume; //볼륨 조정
		String kopo41_help; //조작 후 메세지 출력
		
		public Kopo41_TvRemocon2() {
			this.kopo41_limit_up_channel=50; //최상위 채널
			this.kopo41_limit_down_channel=0; //최하위 채널
			this.kopo41_limit_up_volume=40; //최상위 볼륨
			this.kopo41_limit_down_volume=0; //최하위 볼륨
			System.out.printf("리모콘 조작 준비 완료\n"); //준비 매세지
		}
		
		public Kopo41_TvRemocon2(int kopo41_channelX, int kopo41_channelN, int kopo41_volumeX, int kopo41_volumeN) {
			//생성자 오버라이딩
			this.kopo41_limit_up_channel=kopo41_channelX; //최상위 채널
			this.kopo41_limit_down_channel=kopo41_channelN; //최하위 채널
			this.kopo41_limit_up_volume=kopo41_volumeX; //최상위 볼륨
			this.kopo41_limit_down_volume=kopo41_volumeN; //최하위 볼륨
			System.out.printf("리모콘 조작 준비 완료\n"); //준비 매세지
		}
		
		void kopo41_channel_up() { //채널 올리기
			if(kopo41_channel == kopo41_limit_up_channel) { //마지막 체널이면 올릴 수 없음
				kopo41_help="마지막 채널입니다.";
			}else { //마지막 체널이 아니면 채널 올리기
				kopo41_channel++; 
				kopo41_help=String.format("%d채널입니다.",kopo41_channel);
			}
		}
		
		void kopo41_channel_down() { //채널 내리기
			if(kopo41_channel == kopo41_limit_down_channel) { //처음 체널이면 내릴 수 없음
				kopo41_help="처음 채널입니다.";
			}else { //처음 체널이 아니면 채널 내리기
				kopo41_channel--;
				kopo41_help=String.format("%d채널입니다.",kopo41_channel);
			}
		}
		
		void kopo41_volume_up() { //볼륨 올리기
			if(kopo41_volume == kopo41_limit_up_volume) { //최대 볼륨이면 올릴 수 없음
				kopo41_help="최대 볼륨입니다.";
			}else { //최대 볼륨이 아니면 볼륨 올리기
				kopo41_volume++;
				kopo41_help=String.format("%d볼륨입니다.",kopo41_volume);
			}
		}
		
		void kopo41_volume_down() { //볼륨 내리기
			if(kopo41_volume == kopo41_limit_down_volume) { //최소 볼륨이면 내릴 수 없음
				kopo41_help="최소 볼륨입니다.";
			}else { //최소 볼륨이 아니면 볼륨 내리기
				kopo41_volume--;
				kopo41_help=String.format("%d볼륨입니다.",kopo41_volume);
			}
		}
	
	}
