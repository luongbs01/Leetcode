import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/task-scheduler/description/
 */

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Integer, Integer> count = new HashMap<>();
        for (char c : tasks) {
            count.put(c - 'A', count.getOrDefault(c - 'A', 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        // index 0: frequency, index 1: character, index 2: last seen position
        count.forEach((key, value) -> pq.offer(new int[]{value, key, 0}));
        ArrayDeque<int[]> deque = new ArrayDeque<>(); // deque is used to hold off from reinserting the processed task into the heap
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] task = pq.poll();
            do {
                ans++;
            } while (ans - task[2] <= n && task[2] > 0);
            System.out.println("f: " + task[0] + ", char: " + task[1] + ", last seen pos: " + task[2] + ", ans: " + ans);
            if (task[0] > 1) {
                // add to head of deque
                deque.offerFirst(new int[]{task[0] - 1, task[1], ans});
            }
            while (!deque.isEmpty() && (ans + 1 - deque.peekLast()[2] > n || pq.isEmpty())) {
                pq.offer(deque.pollLast()); // poll from tail of queue
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(new char[]{'B', 'C', 'D', 'A', 'A', 'A', 'A', 'G'}, 1));
    }
}
