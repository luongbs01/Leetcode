import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/tuple-with-same-product/description/
 */

public class TupleWithSameProduct {

    public int tupleSameProduct(int[] nums) {
        int n = nums.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        for (int val : map.values()) {
            ans += (val - 1) * val * 4;
        }
        return ans;
    }
}
