import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/course-schedule-ii/
 */

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int count = 0;
        int[] ans = new int[numCourses];
        LinkedList<Integer>[] adjList = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            adjList[prerequisite[1]].add(prerequisite[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            ans[count] = queue.peek();
            count++;
            adjList[queue.poll()].forEach(course -> {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.offer(course);
                }
            });
        }
        return count == numCourses ? ans : new int[]{};
    }
}
