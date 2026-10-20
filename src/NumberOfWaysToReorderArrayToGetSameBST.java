import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
 */

public class NumberOfWaysToReorderArrayToGetSameBST {

    static int MAX = 1000, MOD = 1_000_000_007;
    static int[][] C = new int[MAX + 1][MAX + 1];

    static {
        for (int i = 0; i <= MAX; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
    }

    public int numOfWays(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(n);
        for (int i : nums) {
            list.add(i);
        }
        return (int) ((dfs(list) + MOD - 1) % MOD);
    }

    private long dfs(List<Integer> list) {
        int n = list.size();
        if (n < 3) {
            return 1;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = list.getFirst();
        for (int i : list) {
            if (i < root) {
                left.add(i);
            } else if (i > root) {
                right.add(i);
            }
        }
        return (((dfs(left) * dfs(right)) % MOD) * C[left.size() + right.size()][left.size()]) % MOD;
    }
}
