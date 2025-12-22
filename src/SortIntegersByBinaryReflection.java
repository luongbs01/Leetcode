import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/sort-integers-by-binary-reflection/description/
 */

public class SortIntegersByBinaryReflection {

	public int[] sortByReflection(int[] nums) {
		int n = nums.length;
		List<int[]> list = new ArrayList<>(n);
		for (int i : nums) {
			list.add(new int[] { i, reflection(i) });
		}
		list.sort((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = list.get(i)[0];
		}
		return ans;
	}

	private int reflection(int n) {
		int ans = 0;
		while (n > 0) {
			ans = (ans << 1) | (n & 1);
			n >>= 1;
		}
		return ans;
	}
}
