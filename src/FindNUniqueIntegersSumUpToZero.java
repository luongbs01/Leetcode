/**
 * Description: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/
 */

public class FindNUniqueIntegersSumUpToZero {

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n - 1; i++) {
            ans[i] = i + 1;
        }
        ans[n - 1] = (n - 1) * n / (-2);
        return ans;
    }
}
