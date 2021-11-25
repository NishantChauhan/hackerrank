package hackerrank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumBribes {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
    	int swaps = 0 ;
    	for (int i=q.length-1; i>=0 ; i--) {
    		if(q[i]!=(i+1)) {
    			if((i-1)>=0 && q[i-1]==(i+1)) {
    				swaps++;
    				swap(q, i,i-1);
    			}
    			else if (((i-2)>=0) && q[i-2] == (i+1)){
    				swaps+=2;
    				q[i-2] = q[i-1];
    				q[i-1]=q[i];
    				q[i] = i+1;
    			}
    			else {
    				System.out.println("Too chaotic");
    				return;
    			}
    		}
    	}
   		System.out.println(swaps);
    }
    static void swap(int[] q, int i, int j){
    	int t = q[i];
    	q[i]=q[j];
    	q[j]=t;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
/*        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }
            minimumBribes(q);
        }

        scanner.close();
*/
    		minimumBribes(new int[] {1,2,3,4,5});//0
            minimumBribes(new int[] {1,2,3,5,4});//1
            minimumBribes(new int[] {1,2,5,3,4});//2
            minimumBribes(new int[] {1,2,5,4,3});//3
            minimumBribes(new int[] {1,2,3,4,5,6,7,8,9,10});//0
            minimumBribes(new int[] {1,2,3,4,5,7,6,8,9,10});//1
            minimumBribes(new int[] {1,2,3,4,7,5,6,8,9,10});//2
            minimumBribes(new int[] {1,2,3,4,7,5,6,9,8,10});//3
            minimumBribes(new int[] {1,2,3,4,7,5,9,6,8,10});//4
            minimumBribes(new int[] {1,2,3,4,7,5,9,8,6,10});//5
            minimumBribes(new int[] {1,2,3,4,7,5,8,9,6,10});//4
            minimumBribes(new int[] {3,2,1});//3
            minimumBribes(new int[] {4,1,3,2,7,5,9,8,6,10});//Too chaotic
            minimumBribes(new int[] {5,1,2,3,7,8,6,4});//Too chaotic
            minimumBribes(new int[] {1,2,5,3,7,8,6,4});//7
         
            
    }
}
