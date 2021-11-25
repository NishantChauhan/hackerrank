package hackerrank.hashmaps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class SherlockAndAnagrams {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
		Map<String,Integer> subStringMap = new HashMap<>();
		int anagrams=0;
		for(int i=0 ; i < s.length();i++) {
			for(int j=i ; j <= s.length();j++) {
				if(i<j) {
					String signature = createSignature(s.substring(i, j));
					if(subStringMap.containsKey(signature)) {
						int pairs = subStringMap.get(signature);
						subStringMap.put(signature, pairs +1 );						
					}
					else {
						subStringMap.put(signature, 1);
					}
				}
			}
		}
		for(Entry<String,Integer> entry: subStringMap.entrySet()) {
			Integer pairs = entry.getValue();
			anagrams+=(pairs * (pairs - 1)/2);
		}
		return anagrams;
	}

	
	private static String createSignature( String substring) {
		int[] signature = new int[]
				{
				0,0,0,0,0,
				0,0,0,0,0,
				0,0,0,0,0,
				0,0,0,0,0,
				0,0,0,0,0,
				0};
		
		for(int i=0; i<substring.length();i++) {
			int index = substring.charAt(i)-'a';
			signature[index]++;
		}
		String result="";
		for(int i=0; i< signature.length;i++) {
			result+=signature[i];
		}
		return result;
	}


	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagramsMySolution(String s) {
		Map<String,Integer> subStringMap = new HashMap<>();
		int anagrams=0;
		for(int i=0 ; i < s.length();i++) {
			for(int j=i ; j <= s.length();j++) {
				if(i<j) {
					String subString= sortedString(s.substring(i, j));
					if(subStringMap.containsKey(subString)) {
						int pairs = subStringMap.get(subString);
						subStringMap.put(subString, pairs +1 );						
					}
					else {
						subStringMap.put(subString, 1);
					}
				}
			}
		}
		for(Entry<String,Integer> entry: subStringMap.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
			Integer pairs = entry.getValue();
			anagrams+=(pairs * (pairs - 1)/2);
		}
		return anagrams;
	}
	static String sortedString(String s) {
		// convert input string to char array 
        char tempArray[] = s.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray);
	}
	
	static boolean isAnagram(String s1, String s2){
		if (s1.length() != s2.length()) {
			return false;
		}
		List<Character> string1  = new ArrayList <Character>();
		List<Character> string2  = new ArrayList <Character>();
		for(int i=0 ; i < s1.length(); i++) {
			string1.add(s1.charAt(i));
			string2.add(s2.charAt(i));
		}
		Collections.sort(string1);
		Collections.sort(string2);
		return string1.equals(string2)? true : false;
	}
	static int sherlockAndAnagramsBruteForce(String s) {
		Map<Integer,List<String>> subStringMap = new HashMap<>();
		for(int i=0 ; i < s.length();i++) {
			for(int j=i ; j <= s.length();j++) {
				if(i<j) {
					List<String> subStringList= null;
					if(subStringMap.containsKey(j-i)) {
						subStringList= subStringMap.get(j-i);
						subStringList.add(s.substring(i, j));
					}
					else {
						subStringList= new ArrayList<>();
						subStringList.add(s.substring(i, j));
					}
					subStringMap.put(j-i, subStringList);
				}
			}
		}
		int anagrams=0;
		
		for(Entry<Integer,List<String>> entry: subStringMap.entrySet()) {
			List<String> substrings = entry.getValue();
			for(int i=0 ; i< substrings.size();i++) {
				for(int j=0 ; j< substrings.size();j++) {
					if(i!=j && isAnagram(substrings.get(i), substrings.get(j))) {
						anagrams++;
					}
				}
			}
		}
		return anagrams/2;
	}


	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//		consoleInput();
		test("ifailuhkqq");
		test("kkkk");
		test("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel");
//		for(int j=0 ; j <10 ; j++) {
//			String s ="z";
//			for(int i=0; i <=100; i++) {
//					s+="z";
//			}
//			test(s);
//		}
	}
	static void test(String s){
		System.out.println("Input: " +s);
		int result = sherlockAndAnagrams(s);
		System.out.println("Result: "+result);
		System.out.println("----------------------------------------");

	}

	private static void consoleInput() throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
