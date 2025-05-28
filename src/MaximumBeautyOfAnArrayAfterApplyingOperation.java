/**
 * Description: https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/
 */

public class MaximumBeautyOfAnArrayAfterApplyingOperation {

    public int maximumBeauty(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] diffArr = new int[max - min + 2 * k];
        for (int num : nums) {
            diffArr[num - min]++;
            diffArr[num - min + 2 * k + 1]--;
        }
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : diffArr) {
            sum += i;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
