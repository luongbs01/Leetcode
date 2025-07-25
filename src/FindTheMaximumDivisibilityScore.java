/**
 * Description: https://leetcode.com/problems/find-the-maximum-divisibility-score/description/
 */

public class FindTheMaximumDivisibilityScore {

    public int maxDivScore(int[] nums, int[] divisors) {
        int[] count = new int[divisors.length];
        for (int i = 0; i < divisors.length; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (num % divisors[i] == 0) {
                    cnt++;
                }
            }
            count[i] = cnt;
        }
        int max = count[0], ans = divisors[0];
        for (int i = 0; i < divisors.length; i++) {
            if (count[i] > max) {
                max = count[i];
                ans = divisors[i];
            } else if (count[i] == max && ans >= divisors[i]) {
                ans = divisors[i];
            }
        }
        return ans;
    }
}
