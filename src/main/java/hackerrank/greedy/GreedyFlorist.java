package hackerrank.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {

    	// Sort the cost in descending order of price
    	
    	// For each friend choose the expensive flowers one by one
    	
    	// Once all friends have bought 1 flower repeat till all flowers are purchased.
    	
    	 Arrays.sort(c);
    	 
    	 int iteration = 0;
    	 int flowerIdx = c.length-1;
    	 int totalCost =0;
    	 
    	 for(int i=1;flowerIdx>=0;i++) {
    		 totalCost+= (iteration+1)*c[flowerIdx--];
    		 if (i%k==0) iteration++;
    	 }
    	return totalCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
  	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
