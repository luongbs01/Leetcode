import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/find-all-people-with-secret/description/
 */

public class FindAllPeopleWithSecret {

	public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
		int[] minTime = new int[n];
		Arrays.fill(minTime, Integer.MAX_VALUE);
		minTime[0] = 0;
		minTime[firstPerson] = 0;
		List<List<int[]>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		adjList.get(0).add(new int[] { firstPerson, 0 });
		adjList.get(firstPerson).add(new int[] { 0, 0 });
		for (int[] meeting : meetings) {
			adjList.get(meeting[0]).add(new int[] { meeting[1], meeting[2] });
			adjList.get(meeting[1]).add(new int[] { meeting[0], meeting[2] });
		}
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		queue.offer(new int[] { 0, 0 });
		queue.offer(new int[] { firstPerson, 0 });
		boolean[] visited = new boolean[n];
		while (!queue.isEmpty()) {
			int[] person = queue.poll();
			if (visited[person[0]])
				continue;
			visited[person[0]] = true;
			List<int[]> adjs = adjList.get(person[0]);
			for (int[] adj : adjs) {
				if (adj[1] >= minTime[person[0]]) {
					if (!visited[adj[0]]) {
						queue.offer(new int[] { adj[0], adj[1] });
					}
					minTime[adj[0]] = Math.min(minTime[adj[0]], adj[1]);
				}
			}
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (minTime[i] != Integer.MAX_VALUE) {
				ans.add(i);
			}
		}
		return ans;
	}
}
