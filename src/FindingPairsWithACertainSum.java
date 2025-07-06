import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/
 */

public class FindingPairsWithACertainSum {

    class FindSumPairs {

        int[] nums1, nums2;
        Map<Integer, Integer> map;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            map = new HashMap<>();
            for (int num : nums2) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        public void add(int index, int val) {
            int freq = map.get(nums2[index]);
            if (freq > 1) {
                map.put(nums2[index], freq - 1);
            } else {
                map.remove(nums2[index]);
            }
            nums2[index] += val;
            map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
        }

        public int count(int tot) {
            int ans = 0;
            for (int num : nums1) {
                ans += map.getOrDefault(tot - num, 0);
            }
            return ans;
        }
    }
}
