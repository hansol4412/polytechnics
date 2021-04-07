package chapter3;

public class Taxcalc {
	//세금계산기 (2021.04.01) 최한솔
	public static int kopo41_taxcal(int kopo41_val, int kopo41_rate) { 
		//static을 이용해서 클래스 내에서 kopo41_taxcal 메소드를 사용할 수 있게 한다
		// kopo41_val, kopo41_rate 매개변수를 사용하여 함수를 호출할 때 값을 불러온다
		int kopo41_ret; // 세후 가격
		
		if(((double)kopo41_val*(double)kopo41_rate/100.0) == kopo41_val*kopo41_rate/100) { 
			//실수형으로 계산한 것과 실수형의 소숫점을 버림해 정수형으로 계산한 것의 값이 같다면 기업 입장에서는 손해가 없다
			kopo41_ret = kopo41_val*kopo41_rate/100; //세전 가격에 세율을 적용하여 세금의 값을 계산한다.
		} else { //실수형으로 계산한 것과 실수형의 소숫점을 버림해 정수형으로 계산한 것의 값이 다르다면 기업 입장에서는 손해가 생긴다.
			kopo41_ret = kopo41_val*kopo41_rate/100 +1; //따라서 계산된 세금에 1을 더해 기업입장에서 세금으로 인한 손해를 안보려고 한다.
		}
		return kopo41_ret; //각각 조건문에 따른 변화된 세금 값을 함수의 return 값으로 내보낸다.
	}
	
	
	public static void main(String[] args) {
		int kopo41_val = 271; //세전 물건 값
		int kopo41_rate = 3; //세금 3퍼센트
		
		int kopo41_tax = kopo41_taxcal(kopo41_val, kopo41_rate); //세금을 구하기위헤 kopo41_taxcal함수를 호출한다.
		
		System.out.printf("**********************************\n");
		System.out.printf("*         단순 세금 계산             *\n");
		System.out.printf("실제 세금계산: %f\n", kopo41_val*kopo41_rate/100.0); //실제 소수점 버림없이 계산된 세금가격
		System.out.printf("세전가격: %d  세금: %d   세포함가격: %d\n", kopo41_val, kopo41_tax, kopo41_val+kopo41_tax); 
		// 물건세전가격, 정수형으로 소숫점 버림하고 +1해서 얻은 세금, 세금 포함한 물건가격 
		System.out.printf("**********************************\n");
		
	}

}
