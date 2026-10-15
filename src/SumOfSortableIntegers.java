import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/sum-of-sortable-integers/
 */

public class SumOfSortableIntegers {

    // wrong answer
    public int sortableIntegers(int[] nums) {
        int n = nums.length, ans = 0;
        if (check(nums, 0, n - 1)) {
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    ans += i;
                }
            }
            return ans;
        }
        Map<Integer, Queue<Integer>> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idx.computeIfAbsent(nums[i], (k) -> new ArrayDeque<>()).offer(i);
        }
        Arrays.sort(nums);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = idx.get(nums[i]).poll();
        }
        return ans;
    }

    private boolean check(int[] nums, int startInclusive, int endInclusive) {
        for (int i = startInclusive; i < endInclusive; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
