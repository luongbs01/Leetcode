import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * Description: https://leetcode.com/problems/sliding-window-maximum/
 */

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = k; i <= length; i++) {
            ans[i - k] = treeMap.lastKey();
            if (i < length) {
                treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
            }
            if (treeMap.get(nums[i - k]) > 1) {
                treeMap.put(nums[i - k], treeMap.get(nums[i - k]) - 1);
            } else {
                treeMap.remove(nums[i - k]);
            }
        }
        return ans;
    }

    // Refer to https://wiki.vnoi.info/algo/data-structures/deque-min-max
    public int[] maxSlidingWindowV2(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) { // mono decreasing queue
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peek()];
            }
        }
        return ans;
    }
}
