/**
 * Description: https://leetcode.com/problems/count-no-zero-pairs-that-sum-to-n/description/
 */

public class CountNoZeroPairsThatSumToN {

    public long countNoZeroPairs(long n) {
        String s = Long.toString(n);
        int L = s.length();

        int[] digits = new int[L];
        for (int i = 0; i < L; i++) {
            digits[i] = s.charAt(L - 1 - i) - '0';
        }

        long total = 0L;

        // Try all possible digit lengths of a and b
        for (int lenA = 1; lenA <= L; lenA++) {
            for (int lenB = 1; lenB <= L; lenB++) {
                // dp[carry]: number of ways up to current digit position
                long[] dp = {1, 0};

                for (int pos = 0; pos < L; pos++) {
                    int d = digits[pos];
                    long[] next = new long[2];

                    // Determine valid digit ranges (0 allowed only for leading zeros)
                    int aMin = (pos < lenA) ? 1 : 0;
                    int aMax = (pos < lenA) ? 9 : 0;
                    int bMin = (pos < lenB) ? 1 : 0;
                    int bMax = (pos < lenB) ? 9 : 0;

                    for (int carry = 0; carry <= 1; carry++) {
                        long ways = dp[carry];
                        if (ways == 0) continue;

                        for (int a = aMin; a <= aMax; a++) {
                            for (int b = bMin; b <= bMax; b++) {
                                int sum = a + b + carry;
                                if (sum % 10 == d) {
                                    next[sum / 10] += ways;
                                }
                            }
                        }
                    }
                    dp = next;
                }

                // Only valid if no carry remains
                total += dp[0];
            }
        }

        return total;
    }
}
