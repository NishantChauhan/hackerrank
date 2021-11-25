package hackerrank.stringmanipulation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
/**Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.

For example, if , it is a valid string because frequencies are . So is  because we can remove one  and have  of each character in the remaining string. If  however, the string is not valid as we can only remove  occurrence of . That would leave character frequencies of .

Function Description

Complete the isValid function in the editor below. It should return either the string YES or the string NO.

isValid has the following parameter(s):

s: a string*/
public class SherlockAndValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
    	long[] signature = new long[26];
  
    	boolean isValid = false;
    	s.chars().forEach(character -> signature[character - 'a']++);
    	
    	Map <Long,Long> frequencies = new HashMap<>();
    	
		for (int i = 0; i < 26; i++) {
			if (signature[i] != 0) {
				Long count = frequencies.get(signature[i]);
				if (count == null) {
					frequencies.put(signature[i], 1L);
				} else {
					frequencies.put(signature[i], count + 1);
				}
			}
		}
    	System.out.println(frequencies);
    	long uniqueFrequencies = frequencies.keySet().size();
    	if(uniqueFrequencies==1) {
    		isValid = true;
    	}else if (uniqueFrequencies== 2) {
    		Long[] keys = new Long [2];
    		frequencies.keySet().toArray(keys);
    		if(keys[0]==1 && frequencies.get(keys[0]) ==1 || keys[1]==1 && frequencies.get(keys[1]) ==1) {
    			isValid=true;
    		}
    		else if (frequencies.get(keys[0])==1 &&  Math.abs(keys[0]-keys[1])==1 || frequencies.get(keys[1])==1 &&  Math.abs(keys[0]-keys[1])==1  ) {
    			isValid= true;
    		}
    		
	    }
    	
    	return isValid ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

