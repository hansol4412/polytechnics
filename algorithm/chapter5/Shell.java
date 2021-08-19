package chapter6;

import java.util.Arrays;

public class Shell {
	//쉘 정렬
	public static void main(String[] args) {
		int[] a = {44, 88, 62, 38, 19, 49, 27, 73};
		int size = a.length;
		int interval = size / 2;
		
		while (interval >= 1) {
			for (int i = 0; i < interval; i++) {
				intervalSort(a, i, size - 1, interval);
			}
			interval = interval / 2;
		}
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}


	public static void intervalSort(int a[], int begin, int end, int interval) {
		int j;
		for (int i = begin + interval; i <= end; i = i + interval) {
			int item = a[i];
			for (j = i - interval; j >= begin && item < a[j]; j = j - interval) {
				a[j + interval] = a[j];
			}
			a[j + interval] = item;
		}
	}
}
