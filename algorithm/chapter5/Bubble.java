package chapter5;

public class Bubble {

	public static void main(String[] args) {
		// 버블정렬
		int[] a = {44, 88, 62, 38, 19, 49};
		
		for(int i = 0; i<a.length-1; i++) { //5번
			for(int j = 0; j<a.length-i-1; j++) { //뒤부터 고정
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			
			/*
			//과정보기
			for(int t=0; t<a.length; t++) {
				System.out.print(a[t]+" ");
			}
			System.out.println();
			*/
		}
		
		for(int t=0; t<a.length; t++) {
			System.out.print(a[t]+" ");
		}
		
	}

}
