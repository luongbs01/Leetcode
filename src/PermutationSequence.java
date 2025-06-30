/**
 * Description: https://leetcode.com/problems/permutation-sequence/description/
 */

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        StringBuilder ans = new StringBuilder(n);
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (used[j]) {
                j++;
            }
            while (k > factorial[n - i]) {
                k -= factorial[n - i];
                do {
                    j++;
                } while (used[j]);
            }
            used[j] = true;
            ans.append(j);
        }
        return ans.toString();
    }
}
