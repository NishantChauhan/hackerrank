package hackerrank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftShiftArray {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();
        
        int [] b = rotateArray(a, d);
        
        printArray(b);
    }
    private static int[] rotateArray(int[] src, int shift) {
    	int [] tar = new int[src.length];
    	int position = src.length - shift;
    	System.arraycopy(src, 0, tar, position, shift);
    	System.arraycopy(src, shift, tar, 0, position);
    	
    	return tar;
    }
    
    private static void printArray(int[] arr) {
    	for(int i=0; i< arr.length;i++) {
    		System.out.print(arr[i]+" ");
    	}
    	System.out.println();
    }
}
