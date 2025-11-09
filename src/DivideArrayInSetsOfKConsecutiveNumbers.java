import java.util.TreeMap;

/**
 * Description: https://leetcode.com/problems/maximize-the-minimum-powered-city/
 */


public class DivideArrayInSetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : nums) {
            treeMap.compute(i, (_, val) -> val != null ? val + 1 : 1);
        }
        while (!treeMap.isEmpty()) {
            int min = treeMap.firstKey();
            for (int i = 0; i < k; i++) {
                Integer val = treeMap.get(min + i);
                if (val == null) {
                    return false;
                }
                if (val > 1) {
                    treeMap.put(min + i, val - 1);
                } else {
                    treeMap.remove(min + i);
                }
            }
        }
        return true;
    }
}
