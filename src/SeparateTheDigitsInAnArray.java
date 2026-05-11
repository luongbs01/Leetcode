import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/separate-the-digits-in-an-array/
 */

public class SeparateTheDigitsInAnArray {

	public int[] separateDigits(int[] nums) {
		int n = nums.length;
		List<Integer> arr = new ArrayList<>(n * 6);
		for (int i = n - 1; i >= 0; i--) {
			int num = nums[i];
			while (num > 0) {
				arr.add(num % 10);
				num /= 10;
			}
		}
		n = arr.size();
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = arr.get(n - 1 - i);
		}
		return ans;
	}
}
