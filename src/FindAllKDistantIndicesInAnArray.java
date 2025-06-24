import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/description/
 */

public class FindAllKDistantIndicesInAnArray {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int min = Math.max(0, i - k);
                int max = Math.min(n - 1, i + k);
                for (int j = min; j <= max; j++) {
                    b[j] = true;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (b[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
