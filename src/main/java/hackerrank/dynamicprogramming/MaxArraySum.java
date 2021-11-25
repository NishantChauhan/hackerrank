package hackerrank.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/** <a href="https://www.hackerrank.com/challenges/max-array-sum/problem">Max Array Sum</a> */
public class MaxArraySum {

  // Complete the maxSubsetSum function below.
  static int maxSubsetSum(int[] arr) {
    int memo[] = new int[arr.length];
    Arrays.fill(memo, -1);

    for (int i = 0; i < arr.length; i++) {
      maxSum(i, arr, memo);
    }
    return memo[arr.length - 1];
  }

  /**
   *
   *
   * <h1>Key Learnings</h1>
   *
   * <ol>
   *   <li>Remember when recursion with memo, memo should be calculated status.
   *   <li>The Memo should store only the state function result
   *   <li>In the <strong>master</strong> solution the negative value check was not needed
   * </ol>
   */
  static int maxSum(int n, int arr[], int memo[]) {
    /**
     * */
    int val = arr[n] < 0 ? 0 : arr[n];

    if (n == 0) {
      memo[n] = val;
    } else if (n == 1) {
      memo[n] = Math.max(memo[0], val);
    } else {
      int minusOne = memo[n - 1] >= 0 ? memo[n - 1] : maxSum(n - 1, arr, memo);
      int minusTwo = memo[n - 2] >= 0 ? memo[n - 2] : maxSum(n - 2, arr, memo);
      memo[n] = Math.max(minusOne,val +  minusTwo);
    }

    return memo[n];
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = maxSubsetSum(arr);

    System.out.println(res);
    scanner.close();
  }

  @Test
  void example0() {
    Assertions.assertEquals(0, maxSubsetSum(new int[] {-1, -2, -3, -4}));
  }

  @Test
  void example1() {
    Assertions.assertEquals(13, maxSubsetSum(new int[] {3, 7, 4, 6, 5}));
  }

  @Test
  void example2() {
    Assertions.assertEquals(11, maxSubsetSum(new int[] {2, 1, 5, 8, 4}));
  }

  @Test
  void example3() {
    Assertions.assertEquals(15, maxSubsetSum(new int[] {3, 5, -7, 8, 10}));
  }

  @Test
  void example4() {
    Assertions.assertEquals(15, maxSubsetSum(new int[] {3, 5, -7, 8, 10}));
  }

  @Test
  void example5() {
    Assertions.assertEquals(15, maxSubsetSum(new int[] {3, 5, -7, 8, 10}));
  }
}
