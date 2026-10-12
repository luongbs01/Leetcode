import java.util.Comparator;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/
 */

public class ApplyOperationsOnArrayToMaximizeSumOfSquares {

    // O(nk) => TLE
    public int maxSum(List<Integer> nums, int k) {
        int n = nums.size(), MOD = 1_000_000_007;
        long ans = 0;
        nums.sort(Comparator.naturalOrder());
        for (int i = n - 1; i >= n - k; i--) {
            ans = (ans + (long) nums.get(i) * nums.get(i)) % MOD;
        }
        if (nums.getFirst() == nums.getLast()) {
            return (int) ans;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j >= Math.max(n - k, i + 1); j--) {
                if ((nums.get(i) | nums.get(j)) > nums.get(j)) {
                    int newI = nums.get(i) & nums.get(j);
                    int newJ = nums.get(i) | nums.get(j);
                    ans = (ans + MOD - (long) nums.get(j) * nums.get(j) + (long) newJ * newJ) % MOD;
                    if (i >= n - k) {
                        ans = (ans + MOD - (long) nums.get(i) * nums.get(i) + (long) newI * newI) % MOD;
                    }
                    nums.set(i, newI);
                    nums.set(j, newJ);
                    if (newI == 0) {
                        break;
                    }
                }
            }
        }
        return (int) (ans + MOD) % MOD;
    }

    public int maxSumV2(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] cnt = new int[30];
        for (int num : nums) {
            for (int i = 29; i >= 0; i--) {
                if (((1 << i) & num) != 0) {
                    cnt[i]++;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            int num = 0;
            for (int j = 29; j >= 0; j--) {
                if (cnt[j] > 0) {
                    num |= (1 << j);
                    cnt[j]--;
                }
            }
            ans = (ans + (long) num * num) % MOD;
        }
        return (int) ans;
    }
}
