package chapter5;

public class Selection {

	public static void main(String[] args) {
		// 선택정렬
		int[] a = {44, 88, 62, 38, 19, 49};
		
		
		for(int i = 0; i<a.length; i++) {
			int min = a[i];
			int minPos = i;
			for(int j=i+1; j <a.length; j++) {
				if(min>a[j]) {
					min = a[j];
					minPos = j;
				}
			}
			int temp = a[i];
			a[i] = min;
			a[minPos] = temp;
		}
		
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
