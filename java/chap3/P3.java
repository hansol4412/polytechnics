package chapter3;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class P3 {
	// 한글의 자음, 모음 구분하기
			  
			  final static char[] ChoSung   = { 0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 
					  0x3145, 0x3146, 0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
		
			  final static char[] JungSung = { 0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 
					  0x3158, 0x3159, 0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160, 0x3161, 0x3162, 0x3163 };
			  
			  final static char[] JongSung  = { 0,      0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 
					  0x313a, 0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145, 
					  0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };


		 public static void main(String[] args) { 
			 	Scanner stdIn = new Scanner(System.in);
			 	System.out.print("input:");
				String str = stdIn.next();
				int a, b, c; 
			    for (int i = 0; i < str.length(); i++){
			    char ch = str.charAt(i);
			    if(ch >= 0xAC00 && ch <= 0xD7A3){ 
			    	
				        c = ch - 0xAC00;
				        a = c / (21 * 28);
				        c = c % (21 * 28);
				        b = c / 28;
				        c = c % 28;
				        System.out.print(ChoSung[a]);
				        System.out.print(JungSung[b]);
	
				        if(c != 0 ) System.out.print(JongSung[c]); 
			      		}
			    }
		}
		
}
