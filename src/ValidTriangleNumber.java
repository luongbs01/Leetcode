import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/valid-triangle-number/description/
 */

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int l = j + 1;
                int r = n;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (nums[mid] > nums[i] + nums[j]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                ans += (n - l);
            }
        }
        return ans;
    }
}
