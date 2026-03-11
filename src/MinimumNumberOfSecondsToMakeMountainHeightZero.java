import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/description/
 */

public class MinimumNumberOfSecondsToMakeMountainHeightZero {

	public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
		long ans = 0;
		PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? Long.compare(o1[1], o2[1]) : Long.compare(o1[0], o2[0]));
		for (int workerTime : workerTimes) {
			pq.offer(new long[] { workerTime, workerTime, 2 });
		}
		while (mountainHeight > 0) {
			long[] minTime = pq.poll();
			ans = minTime[0];
			pq.offer(new long[] { minTime[0] + minTime[1] * minTime[2], minTime[1], minTime[2] + 1 });
			mountainHeight--;
		}
		return ans;
	}
}
