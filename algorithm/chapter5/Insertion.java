package chapter6;

public class Insertion {

	public static void main(String[] args) {
		// 삽입정렬
		int[] a = {44, 88, 62, 38, 19, 49};
		
		for(int i=1; i<a.length; i++) {
			for(int j=i-1; j>=0; j--) {
				if(a[j+1]<a[j]) {
					int n = a[j];
					a[j] = a[j+1];
					a[j+1] = n;
				} else {
					break;
				}
			}
			
			for(int t=0; t<a.length; t++) {
				System.out.print(a[t]+" ");
			}
			System.out.println();
			
		}
	}
}
