import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/description/
 */

public class MinimumDifferenceInSumsAfterRemovalOfElements {

    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long[] sumFirst = new long[n + 1]; // sumFirst[i]: max sum of subsequence of length n of an array starting from 0 to n - 1 + i
        long[] sumSecond = new long[n + 1]; // sumSecond[i]: max sum of subsequence of length n of an array starting from 2n - i to 3n-1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n, (o1, o2) -> o2 - o1);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            minHeap.offer(nums[i]);
            sum += nums[i];
        }
        sumFirst[0] = sum;
        for (int i = 1; i <= n; i++) {
            int max = minHeap.peek();
            if (max > nums[n - 1 + i]) {
                minHeap.poll();
                minHeap.offer(nums[n - 1 + i]);
                sum = sum - max + nums[n - 1 + i];
            }
            sumFirst[i] = sum;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n);
        sum = 0;
        for (int i = 2 * n; i < 3 * n; i++) {
            maxHeap.offer(nums[i]);
            sum += nums[i];
        }
        sumSecond[0] = sum;
        for (int i = 1; i <= n; i++) {
            int min = maxHeap.peek();
            if (min < nums[2 * n - i]) {
                maxHeap.poll();
                maxHeap.offer(nums[2 * n - i]);
                sum = sum - min + nums[2 * n - i];
            }
            sumSecond[i] = sum;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, sumFirst[i] - sumSecond[n - i]);
        }
        return ans;
    }
}
