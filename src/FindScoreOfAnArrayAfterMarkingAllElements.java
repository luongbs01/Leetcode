import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/
 */

public class FindScoreOfAnArrayAfterMarkingAllElements {

    public long findScore(int[] nums) {
        int n = nums.length;
        long ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int value = arr[0], index = arr[1];
            if (!marked[index]) {
                marked[index] = true;
                if (index - 1 >= 0) marked[index - 1] = true;
                if (index + 1 < n) marked[index + 1] = true;
                ans += value;
            }
        }
        return ans;
    }
}
