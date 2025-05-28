import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/check-if-array-is-good/description/
 */

public class CheckIfArrayIsGood {

    public boolean isGood(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            if (num < n - 1) {
                if (set.contains(num)) {
                    return false;
                }
                set.add(num);
            }
        }
        return set.size() == n - 2 && max == n - 1;
    }
}
