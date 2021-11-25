package hackerrank.stringmanipulation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpecialPalinDrome {

	// Complete the substrCount function below.
	static class Pair {
		char c;
		long cnt;

		public Pair(char c, long cnt) {
			this.c = c;
			this.cnt = cnt;
		}
	}

	// Complete the substrCount function below.
	static long substrCount(int n, String s) {
		long count = 0;
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			int j = i + 1;
			while (j < s.length() && s.charAt(j) == s.charAt(i))
				j++;
			list.add(new Pair(s.charAt(i), j - i));
			i = j - 1;
		}

		for (int i = 0; i < list.size(); i++) {
			Pair pair = list.get(i);
			// e.g. for "aaa" we have (1 + 3) * 3 / 2 = 6 special palindromic strings here
			// for case 1
			count += (1 + pair.cnt) * pair.cnt / 2;
			if (pair.cnt == 1 && i > 0 && i < list.size() - 1) {
				Pair pre = list.get(i - 1);
				Pair next = list.get(i + 1);
				if (pre.c == next.c) {
					count += Math.min(pre.cnt, next.cnt);
				}
			}
		}

		return count;
	}

	static long substrCountBruteForce(int n, String s) {
		// Find all substrings n^2
		// check each substring for palindrome n^2

		int palindromes = 0;

		for (int left = 0; left < s.length(); left++) {
			for (int right = left + 1; right <= s.length(); right++) {
				String subString = s.substring(left, right);
				boolean isPalindrome = isPalindromeBruteForce(subString);
				palindromes += isPalindromeBruteForce(subString) ? 1 : 0;
				System.out.println(palindromes + "[" + subString + "," + isPalindrome + "]");
			}
		}

		return palindromes;
	}

	static boolean isPalindromeBruteForce(String s) {
		if (s.length() == 1) {
			return true;
		}

		int left = 0;
		int right = s.length() - 1;
		boolean odd = right % 2 == 0;
		int mid = odd ? right / 2 : -1;
		char commonChar = s.charAt(left);
		while (left < right) {
			if (odd && (left == mid || right == mid)) {

			} else if (s.charAt(left) != s.charAt(right) || s.charAt(left) != commonChar
					|| s.charAt(right) != commonChar) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		long result = substrCount(n, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
