import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/valid-triangle-number/description/
 */

public class ValidTriangleNumber {

    // 77 ms
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

    // 25 ms
    public int triangleNumberV2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int r = n - 1;
            for (int j = n - 2; j > i; j--) {
                while (nums[i] + nums[j] <= nums[r] && r > j) {
                    r--;
                }
                ans += (r - j);
            }
        }
        return ans;
    }
}
