package hackerrank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps {
	static int mySteps;
	static int editorialSteps;
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	int length = arr.length;
    	mySteps = 0;
    	int minimumSwaps=0;
		for (int i = 0; i < length; i++) {
			boolean swapped = false;
			mySteps++;
			printArray("Iteration "+i +"\t", arr);
			for (int j = 0; j < length; j++) {
				mySteps++;
				int index = arr[j]-1;
				if ( j != index) {
					minimumSwaps++;
					swapped=true;
					swap(arr, j, index);
					printArray("Swapped "+j+" "+arr[j]+","+arr[index] +"\t", arr);
				}
			}
			if(!swapped) {
				break;
			}
		}
    	return minimumSwaps;
    }
    static void swap(int arr [], int from, int to){
    	int temp = arr[to];
    	arr[to] = arr[from];
    	arr[from] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//    		consoleInput();
//	        fixedInput();
    	test(new int[]{2,10,1,9,8,7,6,5,4,3}, false);

    }
	private static void fixedInput() {
		int [][]inputs = new int [6][];
		inputs[0] = new int[] {4,3,1,2};
		inputs[1] = new int[] {1,3,5,2,4,6,7};
		inputs[2] = new int[] {1,3,2,4};
		inputs[3] = new int[] {2,10,1,9,8,7,6,5,4,3};
		// Large
		inputs[4] = new int [100000];
		for(int i=inputs[4].length-1; i >=0 ; i--) {
			inputs[4][i]=inputs[4].length-i;
		}
		
		inputs[5]  = new int [10000000];
		for(int i=1; i <=inputs[5].length ; i++) {
			if(i%2==0) {
				inputs[5][i-1]=i;
			}
			else {
				inputs[5][i-1] = inputs[5].length - i;
			}
		}
		
		boolean[] large = new boolean[] {false,false,false,false,true,true};
		
		boolean allowlarge = true;
		for(int i=0; i < inputs.length; i++) {
			if(!large[i] || allowlarge) {
				test(inputs[i],large[i]);
			}
		}
	}
	private static void test(int []arr, boolean large) {
		int[] arrEditorial = Arrays.copyOf(arr, arr.length);
		System.out.println("Input Size\t: "+ arr.length);
		if(!large) {
			printArray("Input\t\t", arr);
		}
		int myResult = minimumSwaps(arr);
		int editorialResult = minimunSwapEditorial(arrEditorial);
		System.out.println("My Result ("+myResult +") is " + calcPhrase(myResult,editorialResult ) + " than editorial result ("+editorialResult+")"  );
		System.out.println("My steps ("+mySteps +") are " + calcPhrase(mySteps,editorialSteps) + " editorial steps ("+editorialSteps+")"  );
		System.out.println("==================================================");
	}
	static String calcPhrase(int op1, int op2){
		if(op1 > op2) {
			return "greater than (>) ";
		}
		else if (op1 < op2 ) {
			return "less than (<)";
		}
		return "equal to (=)";
	}

	private static void printArray(String message,int[] arr) {
		System.out.print(message+": ");
		for(int el: arr) {
			System.out.print(el + " ");
		}
		System.out.println();
	}
	private static void consoleInput() throws IOException {
		//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		
		        int n = scanner.nextInt();
		        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		        int[] arr = new int[n];
		
		        String[] arrItems = scanner.nextLine().split(" ");
		        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		        for (int i = 0; i < n; i++) {
		            int arrItem = Integer.parseInt(arrItems[i]);
		            arr[i] = arrItem;
		        }
		
		        int res = minimumSwaps(arr);
		
		        bufferedWriter.write(String.valueOf(res));
		        bufferedWriter.newLine();
		
		        bufferedWriter.close();
		
		        scanner.close();
	}
	static class Pair implements Comparable<Pair>{
		public int first;
		public int second;
		@Override
		public int compareTo(Pair o) {
			int result = 0;
			result = this.first < o.first ? -1 : 1;
			result = this.first == o.first ? 0 : result;
			return result;
		}
		@Override
		public String toString() {
			return " ["+second+"-@->"+first+"] ";
		}
		
	}
	static int minimunSwapEditorial(int a[]) {

			int n = a.length;
			List<Pair> p= new ArrayList<>();
			boolean visited [] = new boolean[n];
		    
		    for (int i = 0; i < n; i++)
		    {
		    	editorialSteps++;
		        Pair pair = new Pair();
		    	pair.first = a[i];
		        
		        // Storing the original position of a[i]
		        pair.second = i;
		        p.add(pair);
		    }
		    Collections.sort(p);
//		    System.out.print("Sorted : ");
//		    p.forEach(System.out::print);
//		    System.out.println();

		    editorialSteps = editorialSteps + ((Double)(n * Math.log10(((Integer)n).doubleValue()) * Math.log10(2.0))).intValue(); 
		    int ans = 0;
		    
		    for (int i = 0; i < n; i++)
		    {	
		    	//visited[i]=true indicates that index i belongs to a cycle that is already counted
		        
		        //p[i].second = i denotes that the ith element was at its correct position
		    	editorialSteps++;
		        if (visited[i] || p.get(i).second == i) {
		        	editorialSteps++;
		        	continue;
		        }
		        int cycle_size = 0;
		        int j = i;
		        
		        //Counting the size of the cycle
		        while (!visited[j])
		        {
		        	editorialSteps++;
		        	visited[j] = true;
		            j = p.get(j).second;
		            cycle_size++;
		        }
		        
		        ans += (cycle_size - 1);
		    }
		    return ans;
	}
}
