package hackerrank.hashmaps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	Set<Character> set1 = new HashSet<Character>();
    	Set<Character> set2 = new HashSet<Character>();
    	
    	populateSet(s1, set1);
    	populateSet(s2, set2);
    	set1.retainAll(set2);

    	return set1.isEmpty() ? "NO": "YES";
    }


	private static void populateSet(String s1, Set<Character> set1) {
		for(char s: s1.toCharArray()) {
    		set1.add(s);
    	}
	}
    
    
    // Complete the twoStrings function below.
    static String twoStringsMySolution(String s1, String s2) {
    	HashSet<String> set = new HashSet<>();
    	for(int i=0 ; i < s1.length();i++) {
    		set.add(String.valueOf(s1.charAt(i)));
    	}
    	
    	for(int j=0; j < s2.length();j++) {
    		if(set.contains(String.valueOf(s2.charAt(j)))) {
    			return "YES";
    		}
    	}
    	return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	//    	consoleInput();
    	test("hello","world");
    	test("hi","world");
    }
    static void test(String s1, String s2){
    	String result = twoStrings(s1, s2);
    	System.out.println("Input: "+ s1 +" , "+ s2);
    	System.out.println("Result: "+ result);
    }

	private static void consoleInput() throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
	}
}

