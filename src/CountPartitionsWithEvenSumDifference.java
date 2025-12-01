/**
 * Description: https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/
 */

public class CountPartitionsWithEvenSumDifference {

    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return (sum & 1) == 0 ? nums.length - 1 : 0;
    }
}
