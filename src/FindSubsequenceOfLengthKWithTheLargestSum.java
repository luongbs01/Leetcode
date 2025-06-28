import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/
 */

public class FindSubsequenceOfLengthKWithTheLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        boolean[] marked = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n; i++) {
            if (pq.size() < k) {
                pq.offer(new int[]{nums[i], i});
                marked[i] = true;
            } else if (pq.peek()[0] < nums[i]) {
                marked[pq.peek()[1]] = false;
                marked[i] = true;
                pq.poll();
                pq.offer(new int[]{nums[i], i});
            }
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (marked[i]) {
                ans[index] = nums[i];
                index++;
            }
        }
        return ans;
    }
}
