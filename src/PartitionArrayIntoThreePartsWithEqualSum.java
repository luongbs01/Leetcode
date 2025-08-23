/**
 * Description: https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/
 */

public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length, sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 3 != 0) return false;
        int sum2 = 0, count = 0;
        for (int i = 0; i < n - 1; i++) {
            sum2 += arr[i];
            if (sum2 == sum / 3) {
                sum2 = 0;
                count++;
            }
        }
        return count >= 2;
    }
}
