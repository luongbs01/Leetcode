import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/
 */

public class MaximizeConsecutiveElementsInAnArrayAfterModification {

    public int maxSelectedElements(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        for (int num : nums) {
            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), dp.getOrDefault(num, 0) + 1));
            dp.put(num, Math.max(dp.getOrDefault(num, 0), dp.getOrDefault(num - 1, 0) + 1));
            ans = Math.max(ans, Math.max(dp.get(num), dp.get(num + 1)));
            System.out.println(dp);
        }
        return ans;
    }
}
