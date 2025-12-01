import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/count-number-of-trapezoids-i/
 */

public class CountNumberOfTrapezoidsI {

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] point : points) {
            cnt.put(point[1], cnt.getOrDefault(point[1], 0) + 1 );
        }
        BigInteger sum1 = BigInteger.valueOf(0), sum2 = BigInteger.valueOf(0);
        for (int i : cnt.values()) {
            BigInteger ways = BigInteger.valueOf((long) i * (i - 1) / 2);
            sum1 = sum1.add(ways);
            sum2 = sum2.add(ways.multiply(ways));
        }
        return Integer.parseInt(sum1.multiply(sum1).subtract(sum2).divide(BigInteger.valueOf(2)).mod(BigInteger.valueOf(1_000_000_007)).toString());
    }
}
