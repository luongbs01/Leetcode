import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero/
 */

public class MinimumOperationsToConvertAllElementsToZero {

    public int minOperations(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                pq.offer(new int[]{nums[i], i});
        }
        int[] index = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && stack.peek()[0] > nums[i]) {
                index[stack.pop()[1]] = i;
            }
            stack.push(new int[]{nums[i], i});
        }
        while (!stack.empty()) {
            index[stack.pop()[1]] = n;
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            ans++;
            int[] head = pq.poll();
            int max = index[head[1]];
            while (!pq.isEmpty() && pq.peek()[0] == head[0] && pq.peek()[1] < max) {
                pq.poll();
            }
        }
        return ans;
    }

    public int minOperationsV2(int[] nums) {
        int ans = 0;
        int[] cnt = new int[100001];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                int top = stack.pop();
                cnt[top]--;
                if (cnt[top] == 0) ans++;
            }
            if (num > 0) {
                stack.push(num);
                cnt[num]++;
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            cnt[top]--;
            if (cnt[top] == 0) ans++;
        }
        return ans;
    }
}
