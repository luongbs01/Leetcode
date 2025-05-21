import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/zero-array-transformation-i/description/
 */


public class ZeroArrayTransformationI {

    // Refer to https://wiki.vnoi.info/algo/data-structures/prefix-sum-and-difference-array.md
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diffArray = new int[nums.length + 1]; // diffArray[i] = nums[i] - nums[i - 1]
        for (int[] query : queries) {
            diffArray[query[0]]++;
            diffArray[query[1] + 1]--;
        }
        int[] freq = new int[nums.length]; // f[i]: frequency of ith position
        freq[0] = diffArray[0];
        for (int i = 1; i < nums.length; i++) {
            freq[i] = freq[i - 1] + diffArray[i];
        }
        System.out.println(Arrays.toString(diffArray));
        System.out.println(Arrays.toString(freq));
        for (int i = 0; i < nums.length; i++) {
            if (freq[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
