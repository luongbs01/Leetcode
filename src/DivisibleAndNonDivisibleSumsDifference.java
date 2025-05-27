/**
 * Description: https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/
 */

public class DivisibleAndNonDivisibleSumsDifference {
    public int differenceOfSums(int n, int m) {
        int k = n / m;
        int nonDivisibleSum = 0;
        for (int i = 1; i <= k; i++) {
            nonDivisibleSum += i * m;
        }
        return n * (n + 1) / 2 - nonDivisibleSum * 2;
    }
}
