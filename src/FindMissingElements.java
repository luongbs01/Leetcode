import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/find-missing-elements/
 */

public class FindMissingElements {

	public List<Integer> findMissingElements(int[] nums) {
		int min = 100, max = 1;
		for (int i : nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		boolean[] seen = new boolean[max - min + 1];
		for (int i : nums) {
			seen[i - min] = true;
		}
		List<Integer> ans = new ArrayList<>(max - min);
		for (int i = min + 1; i < max; i++) {
			if (!seen[i - min]) {
				ans.add(i);
			}
		}
		return ans;
	}
}
