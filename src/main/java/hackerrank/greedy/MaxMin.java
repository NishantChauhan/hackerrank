package hackerrank.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxMin {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
    	// Sort the array in ascending order
    	//Calculate the difference in window that is minimum;
    	
    	Arrays.sort(arr);
    	int minUnfairness = 1000000000;
    	for(int i=k;i<=arr.length;i++) {
    		int min = arr[i-k];
    		int max = arr[i-1];
    		int unfairness = max-min;
    		if(minUnfairness > unfairness) {
    			minUnfairness = unfairness;
    		}
    	}
    	return minUnfairness;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
  	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
