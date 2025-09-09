/**
 * Description: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/
 */

public class NumberOfPeopleAwareOfASecret {

    long MOD = 1_000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1]; // dp[i]: number of shared people on day i
        dp[1] = 1;
        long total = 0, ans = 0;
        for (int i = delay + 1; i <= n; i++) {
            // MUST plus MOD to avoid negative
            total = (total % MOD + dp[i - delay] % MOD - dp[Math.max(i - forget, 0)] % MOD + MOD) % MOD;
            dp[i] = total;
        }
        for (int i = n - forget + 1; i <= n; i++) {
            ans += dp[i];
            ans %= MOD;
        }
        return (int) ans;
    }
}
