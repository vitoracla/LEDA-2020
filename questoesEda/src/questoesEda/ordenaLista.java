package questoesEda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ordenaLista {

	public static void main(String[] args) {

		int[] a = { 5, 23, 67, 124, 234, 346, 765, 982, 999, 10000 };
		int[] b = { 50, 75, 123, 345, 765, 1000 };
		ordenaLista(a,b);
	}

	public static void ordenaLista(int[] a, int[] b) {
		 int[] c = new int[a.length + b.length];
	        int i = 0;
	        int j = b.length - 1; 
	        int k = 0;
	        
	        while(i < a.length && j >= 0) {
	            if(a[i] <= b[j]) {
	                c[k] = a[i];
	                i++;
	                k++;
	                
	            } else {
	                c[k] = b[j];
	                j--;
	                k++;
	            }
	        }
	        
	        while(i < a.length) {
	            c[k] = a[i];
	            i++;
	            k++;
	        }
	        
	        while(j >= 0) {
	            c[k] = b[j];
	            j--;
	            k++;
	            
	            
	        }
	  }
	

	public static String arrayToString(int[] c) {
		String s = "";
		for (int a : c)
			s += a + " ";

		return s.substring(0, s.length() - 1);
	}
}

/**
 * if (k != 0 && j != a.length -1 ) { if (a[j] < b[k]) { c[i] = a[j]; j++; }
 * else{ c[i] = b[k]; k--; }
 * 
 * } else if (k == 0) { c[i] = a[j]; j++; } else if (j == a.length - 1) { c[i] =
 * b[k]; k--; }
 * 
 * else { break; }
 * 
 * } return c; }
 **/
