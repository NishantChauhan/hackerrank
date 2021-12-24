package hackerrank.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/abbr">Abbreviation</a>
 * <p>
 * You can perform the
 * following operations on the string, :
 *
 * <p>Capitalize zero or more of 's lowercase letters. Delete all of the remaining lowercase letters
 * in . Given two strings, and , determine if it's possible to make equal to as described. If so,
 * print YES on a new line. Otherwise, print NO.
 */
class AbbreviationResult {

    /*
     * Complete the 'abbreviation' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    // a = AbcDE, b = ABDE
    public static String abbreviation(String a, String b) {
        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
        dp[0][0] = true;
        char testChar = 0;
        char matchChar = 0;
        boolean currentMatchState;
        System.out.println(String.format("a = %s, b = %s", a, b));
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                currentMatchState = dp[i][j];
                if (j < b.length() && i < a.length()) {
                    testChar = a.charAt(i);
                    matchChar = b.charAt(j);
                }
                if (currentMatchState) {
                    if (j < b.length() && Character.toUpperCase(testChar) == matchChar) {
                        dp[i + 1][j + 1] = true; // achievable
                    }
                    if (Character.isLowerCase(testChar)) {
                        dp[i + 1][j] = true; // discard lowercase
                    }
                }
            }
        }
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    System.out.print(String.format("  %s\t\t", dp[i][j] ? "*" : "-"));
                } else {
                    System.out.print(String.format("%s%s%s\t\t", a.charAt(i - 1), b.charAt(j - 1), dp[i][j] ? "*" : "-"));
                }
            }
            System.out.println();
        }
        boolean result = (dp[a.length()][b.length()]);
        return (result) ? "YES" : "NO";
    }

    private static void printArray(int aLen, int bLen, boolean[][] arr) {
        System.out.println("--------------------");
        for (int x = 0; x < aLen + 1; x++) {
            for (int y = 0; y < bLen + 1; y++) {
                System.out.print("(" + x + "," + y + ")\t" + arr[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

}

public class Abbreviation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String a = bufferedReader.readLine();

                String b = bufferedReader.readLine();

                String result = AbbreviationResult.abbreviation(a, b);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    /**
     * b [ABDE]
     * a [AbcDE]
     * <p>
     * For capital letters in b, Check if letters exists in "a" in the same sequence in any case.
     * For lowercase letters, Check if letters exists in "a" in the same sequence in any same sequence.
     */

    @Test
    void example1() {
        Assertions.assertEquals("YES", AbbreviationResult.abbreviation("AbcDE", "ABDE"));
    }

    @Test
    void example2() {
        Assertions.assertEquals("NO", AbbreviationResult.abbreviation("AbcDE", "AFDE"));
    }

    @Test
    void example3() {
        Assertions.assertEquals("NO", AbbreviationResult.abbreviation("AbcDE", "ADCBE"));
    }

    @Test
    void example4() {
        Assertions.assertEquals("YES", AbbreviationResult.abbreviation("fafbfcfdfe", "ACD"));
    }

    @Test
    void example5() {
        Assertions.assertEquals("YES", AbbreviationResult.abbreviation("aAaAaA", "AAA"));
    }

    @Test
    void example6() {
        Assertions.assertEquals("NO", AbbreviationResult.abbreviation("aAabaA", "BAAA"));
    }

    @Test
    void example9() {
        Assertions.assertEquals("NO", AbbreviationResult.abbreviation("AAAAAAbbbbbbb", "AB"));
    }

    @Test
    void example10() {
        Assertions.assertEquals("YES", AbbreviationResult.abbreviation("aaaaaaaAbbbbbbb", "AB"));
    }

    @Test
    void example11() {
        Assertions.assertEquals("NO", AbbreviationResult.abbreviation("beFgH", "EFG"));
    }

    @Test
    void example12() {
        Assertions.assertEquals("NO", AbbreviationResult.abbreviation("aAaAaAA", "AAA"));
    }

    @Test
    void example13() {
        Assertions.assertEquals("NO", AbbreviationResult.abbreviation("aA", "AAAAAAAAAAAA"));
    }

    @Test
    void example14() {
        Assertions.assertEquals("YES", AbbreviationResult.abbreviation("fafbfCfdfe", "ACD"));
    }
}
