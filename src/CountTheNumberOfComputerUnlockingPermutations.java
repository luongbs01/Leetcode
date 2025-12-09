/**
 * Description: https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations/description/
 */

public class CountTheNumberOfComputerUnlockingPermutations {

    public int countPermutations(int[] complexity) {
        int min = complexity[0], mod = 1_000_000_007;
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= min) {
                return 0;
            }
        }
        long ans = 1;
        for (int i = 1; i < complexity.length; i++) {
            ans *= i;
            ans %= mod;
        }
        return (int) ans;
    }
}
