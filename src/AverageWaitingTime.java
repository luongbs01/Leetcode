/**
 * Description: https://leetcode.com/problems/average-waiting-time/description/
 */

public class AverageWaitingTime {

	public double averageWaitingTime(int[][] customers) {
		int n = customers.length;
		double totalWaitingTime = 0;
		int startTime = customers[0][0];
		for (int[] customer : customers) {
			startTime = Math.max(startTime, customer[0]);
			totalWaitingTime += (startTime - customer[0]) + customer[1];
			startTime += customer[1];
		}
		return totalWaitingTime / n;
	}
}
