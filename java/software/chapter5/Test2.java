package chapter5;

public class Test2 {
	// 달력인쇄 최한솔
	
	public static void main(String[] args) {
		int kopo41_iWeekday = 5; //1월 1일 금요일부터 시작 (일요일이 0)
		int[] kopo41_iEnd= {31,29,31,30,31,30,31,31,30,31,30,31};
		//각 달의 마지막 일 배열로 지정
		
		for(int kopo41_iMon=0; kopo41_iMon<12; kopo41_iMon++) { //한 달 주기
			System.out.printf("\n\n                       %d월\n",kopo41_iMon+1); //달 알려주기
			System.out.printf("=====================================================\n"); //구분선
			System.out.printf(" 일\t월\t화\t수\t목\t금\t토\n"); //요일 출력 "\t"로 요일 칸 맞추기
			for(int kopo_i=1; kopo_i<=kopo41_iEnd[kopo41_iMon]; kopo_i++) { //일 출력하기, 배열로 정의된 막일 까지 일 출력
				
				if(kopo_i==1 && kopo41_iWeekday != 0) { //만약 1일이고 일요일이 아니라면
					for(int kopo_j=1; kopo_j<=kopo41_iWeekday; kopo_j++) { //칸을 맞추기 위해 자신의 요일이 올 때가지
						System.out.print("\t"); // 칸 띄어서 칸 맞추기
					}
				}
				System.out.printf("%2d\t",kopo_i); //각 일의 숫자 2칸식 차지해서 자리 맞추기
				kopo41_iWeekday++; //요일 하나씩 증가시키다가
				if(kopo41_iWeekday==7) { //7, 즉 일요일에 도달하면
					kopo41_iWeekday=0; // 다시 0으로 돌아오고
					System.out.printf("\n"); //줄을 넘긴다.
				}
			}
		}

	}
}
