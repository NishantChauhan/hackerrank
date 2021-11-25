package hackerrank.sorting;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FradulentActivityAlerts {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
    	int[]  counterArray = new int[201];
    	int notifications = 0;

        for(int i=0;i < d ; i++) {
            counterArray[expenditure[i]]++; 
        }
//        printArray("counterArray",counterArray);
    	
    	for(int day=d; day < expenditure.length; day++ ) {
//    		printArrayRange("recentTransactions", expenditure, day-d,d);
            int medianDouble = findMedianDouble(expenditure,counterArray,day, d); 
            if(expenditure[day]>=  medianDouble) {
                notifications++;
            }
//            System.out.println("Notifications: "+ notifications + " 2 * Median: "+ medianDouble +" Expenditure: "+ expenditure[day]+" Day: "+ day);
        }
        return notifications;
    }
    

    private static int findMedianDouble(int[] expenditure,int [] counterArray, int day, int d) {
    	int low_median = -1;
    	int high_median = -1;
    	int accumulator = 0;

//    	printCounterArray("counterArray", counterArray,10);
        for(int i=0; i< 201; i++) {
        	accumulator += counterArray[i];
//        	System.out.println("i: " + i + " accumulator: " +accumulator );
        	if(low_median==-1 && accumulator >= ((Double)(Math.floor((d+1)/2.0))).intValue()) {
        		low_median= i;
        	}
        	if(high_median==-1 && accumulator >= ((Double)(Math.ceil((d+1)/2.0))).intValue()) {
        		high_median=i;
        	}
        	if(high_median!=-1 && low_median!=-1) {
        		break;
        	}
        }
        
        int medianDouble = low_median+high_median;
        
        counterArray[expenditure[day-d]]--;
        counterArray[expenditure[day]]++;
        
//        printCounterArray("counterArray", counterArray,10);
        return  medianDouble;
    }

	private static void printArrayRange(String string, int[] expenditure, int start, int length) {
		int []  recentTransactions = new int[length];
//		System.out.println("start"+ start + "length" + length);
		System.arraycopy(expenditure, start, recentTransactions, 0, length);
		printArray("recentTransactions",recentTransactions);
	}

    private static void printCounterArray(String name, int [] array, int max){
    	System.out.print(name+": {");
    	for(int i=0; i<max;i++) {
    		System.out.print(" ["+i+"] "+array[i]);
    	}
    	System.out.println(" }");
    }
	
    private static void printArray(String name, int [] array){
    	System.out.print(name+": [");
    	for(int element: array) {
    		System.out.print(" "+element);
    	}
    	System.out.println(" ]");
    }
    static int activityNotificationsTimingOut(int[] expenditure, int d) {
    	int notifications = 0;
    	
    	for(int day=d; day < expenditure.length; day++ ) {
    		int []  recentTransactions = new int[d];
    		System.arraycopy(expenditure, day-d, recentTransactions, 0, d);
    		printArray("recentTransactions",recentTransactions);
    		int medianDouble = findMedianTimingOut(recentTransactions); 
    		if(expenditure[day]>=  medianDouble) {
    			notifications++;
    		}
    		System.out.println("Notifications: "+ notifications + " 2 * Median: "+ medianDouble +" Expenditure: "+ expenditure[day]+" Day: "+ day);
    	}
    	return notifications;
    }

    public static int findMedianTimingOut(int[] nums) {
    	Arrays.sort(nums);
    	printArray("Sorted",nums);
    	int length = nums.length;
    	return length%2==1? 2 * nums[length/2]:nums[length/2]+ nums[(length/2) +1];
    }
   
	private static int findMedianOrderOfnlogn(int[] expenditure, int start , int end) {
    	int [] trailingExpenditure = Arrays.copyOfRange(expenditure, start, end);
    	Arrays.sort(trailingExpenditure);
    	int range = end - start;
    	if (range % 2==1) {
    		return trailingExpenditure[range/2];    		
    	}
    	int offset = range/2;
    	return (trailingExpenditure[offset] + trailingExpenditure[offset+1] )/2;
	}
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
