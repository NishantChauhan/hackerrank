package hackerrank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {

    // Complete the rotLeft function below.
	static int mySteps=0;
    static int[] rotLeft(int[] a, int d) {
    	int [] result = new int[a.length];
    	for(int i=0;i<a.length;i++) {
    		mySteps++;
    		int index = (i-d) < 0 ? a.length+i-d : i-d;
    		result[index]=a[i];
    	}
    	
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//	        consoleInput();
    	//#1
    	test(new int[]{1,2,3,4,5}, 4);

    	//#2
    	/**//*
    	int[]bigArray= new int [100000];
    	for(int i=0; i < bigArray.length; i++ ) {
    		bigArray[i]=i;
    	}
    	test(bigArray, bigArray.length);
    	/**/

    }

	private static void test(int[] a, int d) {
		Date start = new Date();
		int[] result = rotLeft(a, d);
		Date end = new Date();
		if(a.length <1000) {
			printArray("Result",result);
		}
		System.out.println("Result took "+ (end.getTime() - start.getTime()) +" milliseconds and "+ mySteps + " steps for input size "+a.length);


	}
	private static void printArray(String message,int[] result) {
		System.out.print(message+": ");
		for(int el: result) {
			System.out.print(el + " ");
		}
		System.out.println();
	}


	private static void consoleInput() throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
	}
}

