/**
 * Description: https://leetcode.com/problems/number-of-unique-xor-triplets-i/
 */

public class NumberOfUniqueXORTripletsI {

	public int uniqueXorTriplets(int[] nums) {
		int n = nums.length;
		if (n <= 2)
			return n;
		int ans = 1;
		while (ans <= n) {
			ans <<= 1;
		}
		return ans;
	}
}
