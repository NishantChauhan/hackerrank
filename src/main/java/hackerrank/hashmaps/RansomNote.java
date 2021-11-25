package hackerrank.hashmaps;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	List<String> magazineList = new ArrayList<>();
    	for(int i=0; i<magazine.length; i++) {
    		magazineList.add(magazine[i]);
    	};
    	
    	for(String word : note) {

    		if(!magazineList.contains(word)) {
    			System.out.println("No");
    			return;
    		}
    		else {
    			magazineList.remove(word);
    		}
    	}
    	System.out.println("Yes");    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        consoleInput();
        test(new String[] {"give", "me", "one", "grand", "today", "night"},new String[] {"give", "one", "grand", "today"});
        test(new String[] {"two", "times", "three", "is" ,"not", "four"},new String[] {"two", "times", "two", "is","four"});
        test(new String[] {"the"},new String[] {"two", "times", "two", "is","four"});
    }
    static void test(String[] magazine, String[] note) {
    	System.out.println("Magazine :" + printStringArray(magazine));
    	System.out.println("Note :" + printStringArray(note));
    	checkMagazine(magazine, note);
    	System.out.println("----------------------------");

    }

	private static String printStringArray(String[] array) {
		String result = "";
		for(String element: array) {
			result+=" "+element;
		}
		return result;
	}
	private static void consoleInput() {
		String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
	}
}

