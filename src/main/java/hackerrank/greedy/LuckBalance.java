package hackerrank.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
    	int maxLuckBalance=0;
    	
    	List<Integer> impContestLuckBalanceList = new ArrayList<>();
    	for(int i=0; i<contests.length;i++) {
    		if(contests[i][1]==1) {
    			impContestLuckBalanceList.add(contests[i][0]);
    		}
    		else {
    			maxLuckBalance+=contests[i][0];
    		}
    	}

    	Collections.sort(impContestLuckBalanceList,(x, y)-> x > y ? -1 : (x < y ? 1 : 0 ));
    	for(int i=0; i < impContestLuckBalanceList.size();i++) {
    		if(i<k) {
    			maxLuckBalance+=impContestLuckBalanceList.get(i);
    		}
    		else {
    			maxLuckBalance-=impContestLuckBalanceList.get(i);
    		}
    	}

    	
    	return maxLuckBalance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
  	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
