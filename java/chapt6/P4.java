package chapter6;

import java.util.Arrays;
import java.util.Collections;

public class P4 {

	public static void main(String[] args) {
		//정렬하기, 역정렬하기
		int[] a = {2, 33, 7, 5, 12, 34, 99, 25, 28, 53, 20};
		int min;
		for(int i =0; i<a.length; i++) {
			min=i;
			for(int j=i+1; j<a.length; j++ ) {
				if(a[min]>a[j]) min=j;
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		
		for(int i =0; i<a.length; i++) {
			System.out.print(a[i] +" ");
		}
		
		System.out.println();
		
		Integer[] b = {2, 33, 7, 5, 12, 34, 99, 25, 28, 53, 20};
		
		int max;
		for(int i=0; i<b.length; i++) {
			max = i;
			for(int j=i+1; j<b.length; j++) {
				if(b[max]<b[j]) max=j;
			}
			int temp  = b[i];
			b[i] = b[max];
			b[max] = temp;
		}
		
		for(int i =0; i<b.length; i++) {
			System.out.print(b[i] +" ");
		}
		

		
		
	}

}
