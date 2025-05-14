import java.util.*;

/**
 * Description: https://leetcode.com/problems/course-schedule/
 */

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>(numCourses);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new LinkedList<>());
        }
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            adjList.get(course).forEach(adj -> {
                inDegree[adj]--;
                if (inDegree[adj] == 0) {
                    queue.offer(adj);
                }
            });
        }
        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
