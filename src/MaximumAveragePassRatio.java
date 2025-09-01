import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/maximum-average-pass-ratio/description/
 */

public class MaximumAveragePassRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[0] > o1[0] ? 1 : -1);
        for (int[] clazz : classes) {
            priorityQueue.offer(new double[]{gain(clazz[0], clazz[1]), clazz[0], clazz[1]});
        }
        while (extraStudents > 0) {
            double[] clazz = priorityQueue.poll();
            priorityQueue.offer(new double[]{gain(clazz[1] + 1, clazz[2] + 1), clazz[1] + 1, clazz[2] + 1});
            extraStudents--;
        }
        double ans = 0;
        while (!priorityQueue.isEmpty()) {
            double[] clazz = priorityQueue.poll();
            ans += clazz[1] / clazz[2];
        }
        return ans / classes.length;
    }

    private double gain(double pass, double total) {
        return (total - pass) / (total * (total + 1));
    }
}
