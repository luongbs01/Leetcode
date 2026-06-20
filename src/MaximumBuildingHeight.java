import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Description: https://leetcode.com/problems/maximum-building-height/
 */

public class MaximumBuildingHeight {

	public int maxBuilding(int n, int[][] restrictions) {
		Arrays.sort(restrictions, Comparator.comparingInt(o -> o[0]));
		HashSet<Integer> visited = new HashSet<>();
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ?
			Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
		treeMap.put(1, 0);
		treeMap.put(n, n - 1);
		pq.offer(new int[] { 1, 0 });
		pq.offer(new int[] { n, n - 1 });
		for (int[] restriction : restrictions) {
			treeMap.put(restriction[0], restriction[1]);
			pq.offer(new int[] { restriction[0], restriction[1] });
		}
		while (!pq.isEmpty()) {
			int[] head = pq.poll();
			if (!visited.contains(head[0])) {
				int idx = head[0], maxHeight = head[1];
				visited.add(idx);
				Map.Entry<Integer, Integer> leftIdx = treeMap.lowerEntry(idx);
				if (leftIdx != null) {
					int key = leftIdx.getKey();
					int val = leftIdx.getValue();
					if (maxHeight + idx - key < val) {
						int newVal = maxHeight + idx - key;
						treeMap.put(key, newVal);
						pq.offer(new int[] { key, newVal });
					}
				}
				Map.Entry<Integer, Integer> rightIdx = treeMap.higherEntry(idx);
				if (rightIdx != null) {
					int key = rightIdx.getKey();
					int val = rightIdx.getValue();
					if (maxHeight - idx + key < val) {
						int newVal = maxHeight - idx + key;
						treeMap.put(key, newVal);
						pq.offer(new int[] { key, newVal });
					}
				}
			}
		}
		int ans = 0, prevKey = 1, prevVal = 0;
		for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
			int currKey = entry.getKey(), currVal = entry.getValue();
			ans = Math.max(ans, Math.max(currVal, prevVal) + ((currKey - prevKey - Math.abs(currVal - prevVal)) >> 1));
			prevKey = currKey;
			prevVal = currVal;
		}
		return ans;
	}
}
