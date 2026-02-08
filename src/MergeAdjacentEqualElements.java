import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Description: https://leetcode.com/problems/merge-adjacent-equal-elements/description/
 */

public class MergeAdjacentEqualElements {

	public List<Long> mergeAdjacent(int[] nums) {
		List<Long> ans = new LinkedList<>();
		for (int i : nums) {
			ans.add((long) i);
			while (ans.size() > 1 && Objects.equals(ans.get(ans.size() - 2), ans.getLast())) {
				ans.removeLast();
				ans.set(ans.size() - 1, ans.getLast() * 2);
			}
		}
		return ans;
	}
}
