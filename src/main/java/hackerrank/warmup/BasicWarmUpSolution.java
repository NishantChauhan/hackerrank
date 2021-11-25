package hackerrank.warmup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BasicWarmUpSolution {

	public static void main(String[] args) throws IOException {

// Jumping on Clouds		
//		int result = 0;
//		result = jumpingOnClouds(new int[] { 0,0,1,0,1,0,0,1,0 }); //5
//		System.out.println(result);
//		result = jumpingOnClouds(new int[] { 0,0,0,0,0,0,0 ,0});//4
//		System.out.println(result);
//		result = jumpingOnClouds(new int[] { 0,0,1,0,1,0,1,0,1,0,0 });//6
//		System.out.println(result);
//		result = jumpingOnClouds(new int[] { 0,1,0,0,1,0,0,1,0,0,1,0 }); //7
//		System.out.println(result);
//		result = jumpingOnClouds(new int[] { 0,1,0,0,1,0,0,0,1,0,1,0 }); //6
//		System.out.println(result);

		// Repeated String
		// long result = 0;
		// result = repeatedString("aba",10);
		// System.out.println("A: "+result);
		// result = repeatedString("a",1000000000000L);
		// System.out.println("A: "+result);
		// result = repeatedString("aa",7);
		// System.out.println("A: "+result);
		// result = repeatedString("baaa",7);
		// System.out.println("A: "+result);

		// Count Valleys
		// int result;
		// result = countingValleys(8, "UDDDUDUU");
		// System.out.println(result);
		// result = countingValleys(12, "DDDUUUDDDUUU");
		// System.out.println(result);
		// result = countingValleys(12, "DDDUUUDDDUUU");
		// System.out.println(result);
		// result = countingValleys(0, "UUUDDDUUUDDDUUUUUUDDDDDDDDDD");
		// System.out.println(result);

	}

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		long repetitions = 0;
		Map<Integer, Integer> occurencesOnIndex = new HashMap<Integer, Integer>();
		int totalAs = 0;
		long stringLength = s.length();
		for (int i = 0; i < s.length(); i++) {
			if ('a' == s.charAt(i)) {
				totalAs++;
			}
			occurencesOnIndex.put(i, totalAs);
		}
		long quotient = n / stringLength;
		Long remainder = n % stringLength;
		repetitions = quotient * totalAs + (remainder == 0 ? 0 : occurencesOnIndex.get(remainder.intValue() - 1));
		return repetitions;
	}

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {

		int numOfPairs = 0;
		Map<Integer, Integer> colours = new HashMap<Integer, Integer>();
		for (int colour : ar) {
			int count = 0;
			if (colours.containsKey(colour)) {
				count = colours.get(colour);
			}
			colours.put(colour, ++count);
		}
		for (Entry<Integer, Integer> colourEntry : colours.entrySet()) {
			numOfPairs += colourEntry.getValue() / 2;
		}
		return numOfPairs;

	}
	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		int valleys = 0;
		int ups = 0;
		int downs = 0;
		int seaLevels = 0;
		for (int i = 0; i < s.length(); i++) {
			int currentSeaLevels = seaLevels;
			if (downs == ups)
				seaLevels++;
			if (s.charAt(i) == 'U')
				ups++;
			if (s.charAt(i) == 'D')
				downs++;

			if (downs > ups && currentSeaLevels != seaLevels) {
				valleys++;
			}
		}

		return valleys;

	}

	static int jumpingOnClouds(int[] c) {
		int jumps = 0;
		int length = c.length;
		for(int playerPointer=0 ;playerPointer < length - 1  ;) {
			if((playerPointer + 2) < length && c[playerPointer + 2]==1) {
				playerPointer=playerPointer+1;
			}else {
				playerPointer=playerPointer+2;
			}	
			jumps++;
		}
		return jumps;
	}

}