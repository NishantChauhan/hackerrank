package hackerrank.sorting;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MarkAndToys {

    // Complete the maximumToys function below.

//	static int maximumToysPrirityQueue(int[] prices, int budget) {
	static int maximumToys(int[] prices, int budget) {
		PriorityQueue<Integer> sortedPrices = new PriorityQueue<>();
		int steps = 0;
		for (int price : prices) {
			steps++;
			sortedPrices.add(price);
		}
		int numberOfToys = 0;
		int currentCost = 0;
		while (!sortedPrices.isEmpty()) {
			steps++;
			Integer price = sortedPrices.poll();
			currentCost += price;
			if (currentCost > budget) {
				break;
			}
			numberOfToys++;
		}
		steps+= 2 * Math.log(prices.length)/Math.log(2);
//		System.out.println(steps);
		return numberOfToys;
	}

	static int maximumToysBubbleSort(int[] prices, int k) {
//	static int maximumToys(int[] prices, int k) {
		int steps = 0;
		int length = prices.length;
    	int budget = k;
    	int noOftoys=0;
    	int currentCost=0;

    	boolean unSortedArray =true;
    	
    	for(int i=0 ; i < length; i++) {
    		boolean swapped = false;
    		steps++;
        	for(int j=length-1; j > i && unSortedArray; j--) {
        		steps++;
        		if(prices[j]<prices[j-1]) {
        			swap(prices,j,j-1);
        			swapped= true;
        		}
        	}
        	if(!swapped && unSortedArray) {
        		unSortedArray =false;
        	}
        	currentCost+=prices[i];
        	if(budget < currentCost){
        		noOftoys=i;
        		break;
        	}
        	if(i==length-1) {
        		noOftoys=length;
        	}
    	}
    	System.out.println(steps);
    	return noOftoys;
    	
    }

    private static void swap(int[] prices, int from, int to) {
    	int temp = prices[to];
    	prices[to] = prices[from];
    	prices[from]=temp;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
