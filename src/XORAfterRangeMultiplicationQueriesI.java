/**
 * Description: https://leetcode.com/problems/xor-after-range-multiplication-queries-i/
 */

public class XORAfterRangeMultiplicationQueriesI {

	public int xorAfterQueries(int[] nums, int[][] queries) {
		int ans = 0;
		for (int[] query : queries) {
			for (int i = query[0]; i <= query[1]; i += query[2]) {
				nums[i] = (int) (((long) nums[i] * (long) query[3]) % 1_000_000_007);
			}
		}
		for (int num : nums) {
			ans ^= num;
		}
		return ans;
	}
}
