package hackerrank.stringmanipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
    	int m = s1.length();
    	int n = s2.length();
    	int[][] dp = new int[m+1][n+1];
     
    	for(int i=0; i<=m; i++){
    		for(int j=0; j<=n; j++){
    			if(i==0 || j==0){
    				dp[i][j]=0;
    			}else if(s1.charAt(i-1)==s2.charAt(j-1)){
    				dp[i][j] = 1 + dp[i-1][j-1];
    			}else{
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}
     
    	return dp[m][n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
