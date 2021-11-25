package hackerrank.sorting;

public class MergeSort {
	public static void main(String[] args) {
		int[] input = new int [] {0,20,1,19,2,18,3,17,4,16,5,15,6,14,7,13,8,12,9,11,10};
		
		printArray("Input\t",input);
		
		printArray("Output\t",sort(input));
		
	}

	private static int[] sort(int[] input) {
		int size = input.length;
		int left = 0;
		int right = size-1;
		if(left == right) {
			return input;
		}
		mergeSort(input,new int[size],left,right);
		return input;
		
	}
	private static void mergeSort(int[] input,int [] helper,int left, int right){
		int mid = (right+left)/2;
		System.out.print("Merge Sort -> [Left,Mid,Right]: [" + left + ","+mid+","+right+"]");
		if(right<=left) {
			System.out.println(" Failed");
			return;
		}
		System.out.println();
		System.out.println("====================================================================");
		mergeSort(input,helper,left,mid);
		mergeSort(input,helper,mid+1,right);
		mergeHalves(input, helper, left, right);
		System.out.println("====================================================================");
	}

	private static void mergeHalves(int[] input, int[] helper, int left, int right) {
		
		int mid = (left+right)/2;
		int size = right-left+1;

		int helperIndex = left;
		int leftIndex=left;
		int rightIndex= mid+1;
		
		System.out.println("Merge Halves -> [Left,Mid,Right]: [" + left + ","+mid+","+right+"]");
		printArray("Interim Input\t", input);
//		printArray("Before Helper\t", helper);
		while(leftIndex<=mid &&  rightIndex<= right) {
			if(input[leftIndex]<=input[rightIndex]) {
				System.out.println("Left,Right: ["+ input[leftIndex]+","+ input[rightIndex]+"]");
				helper[helperIndex++] = input[leftIndex++];
			}
			else {
				System.out.println("Left,Right: ["+ input[leftIndex]+","+ input[rightIndex]+"]");
				helper[helperIndex++] = input[rightIndex++];
			}
		}
		if(mid-leftIndex+1>0) {
			int[] temp = new int[mid-leftIndex+1];
			int count = leftIndex;
			for(int i = 0; i<mid-leftIndex+1;i++) {
				temp[i] = input[count++];
			}
//			printArray("After Helper\t", helper);
//			printArray("Copying left element from Input", temp);
//			System.out.println("To position [" +helperIndex+"]" );
			System.arraycopy(input, leftIndex, helper, helperIndex, mid-leftIndex+1);
//			printArray("Merged Helper\t", helper);
		}
		if(right-rightIndex+1>0) {
			int[] temp = new int[right-rightIndex+1];
			int count = rightIndex;
			for(int i = 0; i<right-rightIndex+1;i++) {
				temp[i] = input[count++];
			}
//			printArray("Helper\t", helper);
//			printArray("Copying right element from Input", temp);
//			System.out.println("To position [" +helperIndex+"]" );
			System.arraycopy(input, rightIndex, helper, helperIndex, right-rightIndex+1);
//			printArray("Merged Interim\t", helper);

		}
		System.arraycopy(helper, left, input, left, size);
		printArray("Merged Input\t", input);
	}
	

	private static void printArray(String msg, int[] input) {
		System.out.print( msg+": {");
		for(int i=0; i<input.length;i++) {	
			System.out.print(" ["+i+"]"+input[i]);
		}
		System.out.println(" }");
	}
	
}
