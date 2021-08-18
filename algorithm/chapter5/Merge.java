package chapter6;

import java.util.Arrays;

public class Merge {
	static int[] sorted = new int[8];

	public static void merge(int a[], int m, int middle, int n) {
		int i = m;
		int j = middle + 1;
		int k = m;
		
		//비교해서 작은 것부터 정렬하기 
		while (i <= middle && j <= n) {
			if (a[i] <= a[j]) {
				sorted[k++] = a[i++];
			} else {
				sorted[k++] = a[j++];
			}
		}
		
		//집합의 남은 요소를 뒤에 넣기
		if (i > middle) {
			for (int t = j; t <= n; t++, k++) {
				sorted[k] = a[t];
			}
		} else {
			for (int t = i; t <= middle; t++, k++) {
				sorted[k] = a[t];
			}
		}
		
		for (int t = m; t <= n; t++) {
			a[t] = sorted[t];
		}
	}

	public static void mergeSort(int a[], int m, int n) {
		int middle;
		if (m < n) {
			middle = (m + n) / 2;
			mergeSort(a, m, middle); //앞 쪼개기
			mergeSort(a, middle + 1, n); // 뒤 쪼개기
			merge(a, m, middle, n); // 합병
		}
	}

	public static void main(String[] args) {
		int[] a = {44, 88, 62, 38, 19, 49, 27, 73};
		mergeSort(a, 0, a.length - 1); //쪼객기
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
