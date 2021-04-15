package chapter4;

public class Test7 {
	//case문 비교 최한솔
	public static void main(String[] args) { //1월부터 12월까지
		for(int kopo41_i=1;kopo41_i<13;kopo41_i++){ 
			System.out.printf("%d월=>", kopo41_i); //몇 월인지 알려주기
			LOOP: for (int kopo41_j=1;kopo41_j<32; kopo41_j++){ 
				 // 일을 출력하기 위해 1부터 31까지 출력하기
				if(kopo41_j==31) {
					 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
					break LOOP; //일이 31이 되면 위의 LOOP로 가기 
				} else {
					System.out.printf("%d, ",kopo41_j); // 막일이 아닌 각 월의 일 출력하기 => 콤마 찍기
				}
				//switch문 사용해서 월 선택하기
				switch(kopo41_i) { 
					case 4:case 6: case 9: case 11:
						// 만약 4,6,9,11월일 때
						if(kopo41_j==30) {
							 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
							break LOOP; //일이 30이 되면 위의 LOOP로 가기 
						}
						
						break; // 밑의 코드로 이어지는 것을 방지
					case 2:
						//만약 2월일 때
						if(kopo41_j==28) {
							System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
							break LOOP; //일이 28이 되면 위의 LOOP로 가기
						}
						break; // 밑의 코드로 이어지는 것을 방지
				}	
			}
			System.out.printf("\n"); //각 월의 일들을 다 찍었으면 다음줄로 넘어가 다음 달 출력
		}
	}

}
