import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/
 */

public class SubarraysDistinctElementSumOfSquaresI {

    public int sumCounts(List<Integer> nums) {
        int n = nums.size(), ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                ans += set.size() * set.size();
            }
        }
        return ans;
    }
}
