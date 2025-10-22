/**
 * Description: https://leetcode.com/problems/next-greater-numerically-balanced-number/
 */

public class NextGreaterNumericallyBalancedNumber {

    public int nextBeautifulNumber(int n) {
        int ans = n + 1;
        while (!isBeautifulNumber(ans)) {
            ans++;
        }
        return ans;
    }

    private boolean isBeautifulNumber(int n) {
        int[] cnt = new int[10];
        while (n != 0) {
            cnt[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (cnt[i] > 0 && cnt[i] != i)
                return false;
        }
        return true;
    }
}
