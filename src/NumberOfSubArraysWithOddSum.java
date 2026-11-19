/**
 * Description: https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
 */

public class NumberOfSubArraysWithOddSum {

    public int numOfSubarrays(int[] arr) {
        int ans = 0, sum = 0, MOD = 1_000_000_007, evenSumCnt = 1, oddSumCnt = 0;
        for (int i : arr) {
            sum = (sum + i) % MOD;
            if ((sum & 1) != 0) {
                ans = (ans + evenSumCnt) % MOD;
                oddSumCnt++;
            } else {
                ans = (ans + oddSumCnt) % MOD;
                evenSumCnt++;
            }
        }
        return ans;
    }
}
