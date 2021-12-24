package hackerrank.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * <a href="https://www.hackerrank.com/challenges/candies/problem">Candies</a><br/>
 * Complete the 'candies' function below.<br/>
 * <p>
 * The function is expected to return a LONG_INTEGER.<br/>
 * The function accepts following parameters:<br/>
 * 1. INTEGER n<br/>
 * 2. INTEGER_ARRAY arr<br/>
 */
class CandiesResult {


    public static long candies(int n, List<Integer> arr) {
        // Write your code here
        int candies[] = new int[n];
        candies[0]=1;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1) < arr.get(i)) {
                candies[i] = candies[i - 1] + 1;
            }
            else {
                candies[i]=1;
            }
        }
        for (int i = arr.size() - 2; i >= 0; i--) {
            if (arr.get(i + 1) < arr.get(i) && candies[i + 1] >= candies[i]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        return Arrays.stream(candies).asLongStream().sum();
    }

}

public class Candies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr =
                IntStream.range(0, n)
                        .mapToObj(
                                i -> {
                                    try {
                                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                })
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(toList());

        long result = CandiesResult.candies(n, arr);
        System.out.println(result);
    }

    /**
     * <h1>Solution</h1>
     * <p>
     * Let c = candies, r = rating
     *
     * <p>
     *
     *
     * <p>
     */
    @Test
    void example1() {
        Assertions.assertEquals(10, CandiesResult.candies(6, Arrays.asList(new Integer[]{4, 6, 4, 5, 6, 2})));
        /*  i r[i] Initial Pass 1  Pass 2
            0   4    1      1       x
            1   6    1      2       x 3
            2   4    1      1       x 4
            3   5    1      2       x 6
            4   6    1      3       x 9
            5   2    1      1       x 10
        */
    }

    @Test
    void example2() {
        Assertions.assertEquals(4, CandiesResult.candies(3, Arrays.asList(new Integer[]{1, 2, 2})));
        /*  i r[i] I P1 P2
            0   1  1 1 x 1
            1   2  1 2 x 3
            2   2  1 1 x 4
         */

    }

    @Test
    void example3() {
        Assertions.assertEquals(19, CandiesResult.candies(10, Arrays.asList(new Integer[]{2, 4, 2, 6, 1, 7, 8, 9, 2, 1})));
        /*  i r[i]  I P1 P2
            0   2   1 1 x 1
            1   4   1 2 x 3
            2   2   1 1 x 4
            3   6   1 2 x 6
            4   1   1 1 x 7
            5   7   1 2 x 9
            6   8   1 3 x 12
            7   9   1 4 x 16
            8   2   1 1 2 18
            9   1   1 1 x 19
         */
    }

    @Test
    void example4() {
        Assertions.assertEquals(12, CandiesResult.candies(8, Arrays.asList(new Integer[]{2, 4, 3, 5, 2, 6, 4, 5})));
    }

    @Test
    void example5() {
        Assertions.assertEquals(15, CandiesResult.candies(7, Arrays.asList(new Integer[]{4, 3, 2, 1, 2, 1, 3})));
        /*
        i r[i] I P1 P2
        0 4    1 1 4
        1 3    1 1 3 7
        2 2    1 1 2 9
        3 1    1 1 x 10
        4 2    1 2 x 12
        5 1    1 1 x 13
        6 3    1 2 x 15

        4  3  2  1  2  1  3
        4  3  2  1  2  1  2
        4  7  9 10 12 13 15
         */

    }
    @Test
    void example6() {
        Assertions.assertEquals(19, CandiesResult.candies(10, Arrays.asList(new Integer[]{2,3,2,6,1,7,8,9,2,1})));
    }
}