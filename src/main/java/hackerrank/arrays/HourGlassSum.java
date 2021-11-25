package hackerrank.arrays;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourGlassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int sum= hourGlassTotal(arr,1,1);
    	for(int rowPointer=1;rowPointer< arr.length-1; rowPointer++ ) {
    		for(int columnPointer=1;columnPointer<arr[rowPointer].length-1;columnPointer++) {
    			int localSum = hourGlassTotal(arr,rowPointer,columnPointer);
    			System.out.println("LocalSum: "+localSum + ", RowPointer: " + rowPointer +", ColumnPointer: "+ columnPointer);
    			if(sum < localSum) {
    				sum = localSum;
    			}
    		}
    	}
    	
		return sum;
    }
    static int hourGlassTotal(int [][] arr, int row, int column ){
    	int sum = arr[row-1][column-1] + arr[row-1][column] + arr[row-1][column+1]+
    								arr[row][column]+
    			arr[row+1][column-1]+arr[row+1][column]+arr[row+1][column+1];
    					
    	return sum;
    }
    

    public static void main(String[] args) throws IOException {
        int result = 0;
        result = hourglassSum(
        		new int [][] {
        			new int[]{1,1,1,0,0,0},
        			new int[]{0,1,0,0,0,0},
        			new int[]{1,1,1,0,0,0},
        			new int[]{0,0,2,4,4,0},
        			new int[]{0,0,0,2,0,0},
        			new int[]{0,0,1,2,4,0}
        			}
        		); // 19
        System.out.println(result);
        
        result = hourglassSum(
        		new int [][] {
        			new int[]{0,-4,-6,0,-7,-6},
        			new int[]{-1,-2,-6,-8,-3,-1},
        			new int[]{-8,-4,-2,-8,-8,-6},
        			new int[]{-3,-1,-2,-5,-7,-4},
        			new int[]{-3,-5,-3,-6,-6,-6},
        			new int[]{-3,-6,0,-8,-6,-7}
        			}
        		); //-19
        System.out.println(result);
    }
/*
    
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
    */
}
