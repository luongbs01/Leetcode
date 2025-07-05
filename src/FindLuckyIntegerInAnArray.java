import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/find-lucky-integer-in-an-array/description/
 */

public class FindLuckyIntegerInAnArray {

    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = -1;
        for (int num : freq.keySet()) {
            if (freq.get(num) == num && num > ans) {
                ans = num;
            }
        }
        return ans;
    }
}
