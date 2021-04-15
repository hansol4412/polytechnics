package chapter4;

public class Test6 {
	// 비정형 비교3 최한솔
	public static void main(String[] args) {
		for (int kopo41_i=1; kopo41_i<13; kopo41_i++){ //1월부터 12월까지
			System.out.printf("%d월=>", kopo41_i); //몇 월인지 알려주기
				for(int kopo41_j=1;kopo41_j<32; kopo41_j++){ //일을 출력하기 위해 1부터 31까지
					
					if((kopo41_i==1||kopo41_i==3||kopo41_i==5||kopo41_i==7||kopo41_i==8||kopo41_i==10||kopo41_i==12) && (kopo41_j==31)) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						break; // 만약 1,3,5,7,8,10,12월 일 때 일이 31이 되면 break로 반복문 나가기
					}
					if((kopo41_i==4||kopo41_i==6||kopo41_i==9||kopo41_i==11) && (kopo41_j==30)) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						break; // 만약 4,6,9,11월이고 일이 30이 되면 break로 반복문 나가기
					}
					if(kopo41_i==2 && kopo41_j==28){ 
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						break; // 만약 2월이고 일이 28이 되면 break로 반복문 나가기
					}
					else {
						System.out.printf("%d,",kopo41_j); // 각 월의 일 출력하기 => 콤마 찍기
					}
				}
			System.out.printf("\n"); //각 월의 일들을 다 찍었으면 다음줄로 넘어가 다음 달 출력
		}
	}

}
