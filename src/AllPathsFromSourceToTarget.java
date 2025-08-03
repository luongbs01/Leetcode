import java.util.*;

/**
 * Description: https://leetcode.com/problems/all-paths-from-source-to-target/description/
 */

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int dest = graph.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(List.of(0));
        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            int curr = list.get(list.size() - 1);
            if (curr < dest) {
                for (int i : graph[curr]) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i);
                    queue.offer(newList);
                }
            } else {
                ans.add(list);
            }
        }
        return ans;
    }
}
