package chapter4;

public class Test4 {
	// 비정형비교1 최한솔
	public static void main(String[] args) {
		 for (int kopo41_i=1;kopo41_i<13; kopo41_i++){ //1월부터 12월까지
			 System.out.printf("%d월 =>", kopo41_i); //몇 월인지 알려주기
				 for (int kopo41_j=1;kopo41_j<32; kopo41_j++){
					 if(kopo41_i==1 && kopo41_j ==31) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break;    //1월은 31일까지 출력
					 }
					 if(kopo41_i==2 && kopo41_j ==28) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //2월은 28일까지 출력
					 }
					 if(kopo41_i==3 && kopo41_j ==31) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //3월은 31일까지 출력
					 }
					 if(kopo41_i==4 && kopo41_j ==30) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //4월은 30일까지 출력
					 }
					 if(kopo41_i==5 && kopo41_j ==31) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //5월은 31일까지 출력
					 }
					 if(kopo41_i==6 && kopo41_j ==30) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //6월은 30일까지 출력
					 }
					 if(kopo41_i==7 && kopo41_j ==31) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //7월은 31일까지 출력
					 }
					 if(kopo41_i==8 && kopo41_j ==31) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //8월은 31일까지 출력
					 }
					 if(kopo41_i==9 && kopo41_j == 30) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //9월은 30일까지 출력
					 }
					 if(kopo41_i==10 && kopo41_j ==31) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //10월은 31일까지 출력
					 }
					 if(kopo41_i==11 && kopo41_j ==30) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //11월은 30일까지 출력
					 }
					 if(kopo41_i==12 && kopo41_j ==31) {
						 System.out.printf("%d ", kopo41_j); // 마지막 일에 ","을 출력하지 않기위해
						 break; //12월은 31일까지 출력
					 }
					 else {
						 System.out.printf("%d, ", kopo41_j); // 각 월의 일 출력하기 => 콤마 찍기
					 }
				 }
				 System.out.printf("\n"); //각 월의 일들을 다 찍었으면 다음줄로 넘어가 다음 달 출력
		 }
	}

}
