/**
 * Description: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/
 */

public class NRepeatedElementInSize2NArray {

	public int repeatedNTimes(int[] nums) {
		boolean[] visited = new boolean[10001];
		for (int i : nums) {
			if (visited[i])
				return i;
			visited[i] = true;
		}
		return -1;
	}
}
