import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/check-if-array-is-good/description/
 */

public class CheckIfArrayIsGood {

	public boolean isGood(int[] nums) {
		int n = nums.length;
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (num >= n || (num < n - 1 && set.contains(num))) {
				return false;
			}
			set.add(num);
		}
		return set.size() == n - 1;
	}
}
