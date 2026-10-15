/**
 * Description: https://leetcode.com/problems/maximum-k-to-sort-a-permutation/
 */

public class MaximumKToSortAPermutation {

    // wrong answer
    public int sortPermutation(int[] nums) {
        int n = nums.length, ans = -1;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i != nums[i] && !visited[i]) {
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    if (ans == -1) {
                        ans = j & nums[j];
                    } else if (ans != (j & nums[j])) {
                        System.out.println(j + " " + ans);
                        return 0;
                    }
                    j = nums[j];
                }
            }
        }
        return Math.max(ans, 0);
    }
}
