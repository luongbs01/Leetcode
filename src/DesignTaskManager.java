import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/design-task-manager/
 */

public class DesignTaskManager {

    class TaskManager {

        HashMap<Integer, Integer> taskToUser = new HashMap<>();
        HashMap<Integer, Integer> taskToPriority = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);

        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> task : tasks) {
                add(task.get(0), task.get(1), task.get(2));
            }
        }

        public void add(int userId, int taskId, int priority) {
            taskToUser.put(taskId, userId);
            taskToPriority.put(taskId, priority);
            pq.offer(new int[] { taskId, priority });
        }

        public void edit(int taskId, int newPriority) {
            taskToPriority.put(taskId, newPriority);
            pq.offer(new int[] { taskId, newPriority });
        }

        public void rmv(int taskId) {
            taskToUser.remove(taskId);
            taskToPriority.remove(taskId);
        }

        public int execTop() {
            while (!pq.isEmpty()) {
                if (taskToPriority.getOrDefault(pq.peek()[0], -1) == pq.peek()[1]) {
                    int ans = taskToUser.get(pq.peek()[0]);
                    rmv(pq.poll()[0]);
                    return ans;
                }
                pq.poll();
            }
            return -1;
        }
    }
}
