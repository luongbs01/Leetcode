import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 */

public class KthLargestElementInStream {
    PriorityQueue<Integer> queue;
    int size;

    public KthLargestElementInStream(int k, int[] nums) {
        size = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.offer(num);
            }
        }
    }

    public int add(int val) {
        if (queue.size() < size) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
