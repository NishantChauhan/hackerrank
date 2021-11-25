package hackerrank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {
	static int mySteps=0;
	static int netSteps=0;
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    	long[] sumArray = new long [n];
    	
    	for(int i=0 ; i < queries.length;i++) {
    		netSteps++;
    		int start= queries[i][0]-1;
    		int end= queries[i][1]-1;
    		long addition= queries[i][2];
    		
    		sumArray[start]+=addition;
    		
//    		System.out.println("Query ["+start+","+end+","+addition+"]");
//    		printArray("Iteration["+i+"]", sumArray);
    		if(end+1!=n) {
    			sumArray[end+1]-=addition;	
    		}
    	}

    	for(int i=1 ; i < n ; i++) {
    		netSteps++;
    		sumArray[i] +=sumArray[i-1];
    	}
//    	printArray("Final", sumArray);
    	long max = 0;
    	for(long sum: sumArray) {
    		mySteps++;
    		if(sum > max) {
    			max = sum;
    		}
    	}

    	return max;
        }
	private static void printArray(String message,long[] edgesArray) {
		System.out.print(message+": ");
		for(long el: edgesArray) {
			System.out.print(el + " ");
		}
		System.out.println();
	}
    static long arrayManipulationTimingOut(int n, int[][] queries) {
    	long[] sumArray = new long [n];
    	
    	for(int i=0 ; i < queries.length;i++) {
    		mySteps++;
    		for(int j=queries[i][0]; j<=queries[i][1];j++ ) {
    			mySteps++;
    			int arrayIndex = j-1;
    			sumArray[arrayIndex]+=queries[i][2];
    		}
//    		System.out.println("Query ["+queries[i][0]+","+queries[i][1]+","+queries[i][2]+"]");
//    		printArray("Iteration["+i+"]", sumArray);
    	}

    	long max = 0;
    	for(long sum: sumArray) {
    		mySteps++;
    		if(sum > max) {
    			max = sum;
    		}
    	}

    	return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        consoleInput();
        fixedInput();

    }

	private static void fixedInput() {
		
		//#1
		test(5,new int [][] {
			{1,2,100},
			{2,5,100},
			{3,4,100}
		});
		System.out.println("============================================");
		
		//#2
		/**/
		int[][] queries2 = new int [200000][];
		for(int i=0; i<queries2.length;i++) {
			int[] query = new int[3];
			query[0] = 1;
			query[1] = 10000000;
			query[2] = 1000000000;
			queries2[i] = query;
		}
		test(10000000,queries2);
		/**/
		System.out.println("============================================");
		//#3
		/**/
		int[][] queries3 = new int [200000][];
		for(int i=0; i<queries3.length;i++) {
			int[] query = new int[3];
			query[0] = 1;
			query[1] = 2;
			query[2] = 1;
			queries3[i] = query;
		}
		test(10000000,queries3);
		/**/
		System.out.println("============================================");
		//#4
		test(10,new int [][] {
			{2,6,8},
			{3,5,7},
			{1,8,1},
			{5,9,15}
		});		
		System.out.println("============================================");
	}
	private static void test(int n, int[][] queries) {
		Date start = new Date();
		long netResult = arrayManipulation(n, queries);
		Date end = new Date();
		System.out.println("Result: "+ netResult +" took "+ (end.getTime() - start.getTime()) +" milliseconds and "+ netSteps + " steps for input size "+n);

//		start = new Date();
//		long myResult = arrayManipulationTimingOut(n, queries);
//		end = new Date();
//		System.out.println("Result: "+ myResult +" took "+ (end.getTime() - start.getTime()) +" milliseconds and "+ mySteps + " steps for input size "+n);
	}

	private static void consoleInput() throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
	}
}
