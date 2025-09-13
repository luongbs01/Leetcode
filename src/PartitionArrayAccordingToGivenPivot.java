import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/partition-array-according-to-given-pivot/description/
 */

public class PartitionArrayAccordingToGivenPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> less = new ArrayDeque<>(), greater = new ArrayDeque<>();
        int equal = 0, index = 0;
        for (int i : nums) {
            if (i < pivot) less.offer(i);
            else if (i > pivot) greater.offer(i);
            else equal++;
        }
        while (!less.isEmpty()) nums[index++] = less.poll();
        while (equal-- > 0) nums[index++] = pivot;
        while (!greater.isEmpty()) nums[index++] = greater.poll();
        return nums;
    }
}
