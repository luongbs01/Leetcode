/**
 * Description: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 */

public class CountOddNumbersInAnIntervalRange {

    public int countOdds(int low, int high) {
        int ans = (high - low) >> 1;
        return (high & 1) == 0 && (low & 1) == 0 ? ans : (ans + 1);
    }
}
