import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/process-tasks-using-servers/description/
 */

public class ProcessTasksUsingServers {

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length, idx = 0;
        int[] ans = new int[m];
        PriorityQueue<int[]> freeServers = new PriorityQueue<>(
                (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[]{i, servers[i]});
        }

        Queue<Integer> taskQueue = new ArrayDeque<>();
        Queue<long[]> workingServers = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        for (int i = 0; i < m; i++) {
            taskQueue.offer(i);
            while (!workingServers.isEmpty() && workingServers.peek()[1] <= i) {
                freeServers
                        .offer(new int[]{(int) workingServers.peek()[0], servers[(int) workingServers.peek()[0]]});
                workingServers.poll();
            }
            while (!freeServers.isEmpty() && !taskQueue.isEmpty()) {
                workingServers.offer(new long[]{freeServers.peek()[0], i + tasks[taskQueue.peek()]});
                ans[idx++] = freeServers.peek()[0];
                freeServers.poll();
                taskQueue.poll();
            }
        }

        long time = m;
        while (!taskQueue.isEmpty()) {
            while (!workingServers.isEmpty() && workingServers.peek()[1] <= time) {
                freeServers
                        .offer(new int[]{(int) workingServers.peek()[0], servers[(int) workingServers.peek()[0]]});
                workingServers.poll();
            }
            while (!freeServers.isEmpty() && !taskQueue.isEmpty()) {
                workingServers.offer(new long[]{freeServers.peek()[0], time + tasks[taskQueue.peek()]});
                ans[idx++] = freeServers.peek()[0];
                freeServers.poll();
                taskQueue.poll();
            }
            time = workingServers.peek()[1];
        }

        return ans;
    }
}
