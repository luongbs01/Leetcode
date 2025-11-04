import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/
 */

public class FindXSumOfAllKLongSubarraysI {

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < ans.length; i++) {
            int[] freq = new int[51];
            for (int j = i; j < i + k; j++) {
                freq[nums[j]]++;
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
            for (int j = 0; j <= 50; j++) {
                if (freq[j] > 0) {
                    pq.offer(new int[] { freq[j], j });
                }
            }
            int sum = 0;
            int cnt = x;
            while (cnt > 0 && !pq.isEmpty()) {
                sum += pq.peek()[0] * pq.peek()[1];
                pq.poll();
                cnt--;
            }
            ans[i] = sum;
        }
        return ans;
    }
}
