import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/number-of-unique-xor-triplets-ii/
 */

public class NumberOfUniqueXORTripletsII {

	public int uniqueXorTriplets(int[] nums) {
		int n, idx = 0;
		Set<Integer> set = new HashSet<>(1 << 12);
		for (int i : nums) {
			set.add(i);
		}
		n = set.size();
		for (int i : set) {
			nums[idx++] = i;
		}
		set.clear();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				set.add(nums[i] ^ nums[j]);
			}
		}
		Set<Integer> triplets = new HashSet<>(1 << 12);
		for (int i : set) {
			for (int j : nums) {
				triplets.add(i ^ j);
			}
		}
		return triplets.size();
	}

	public int uniqueXorTripletsV2(int[] nums) {
		int n = 0, idx = 0, max = 0;
		for (int i : nums) {
			max = Math.max(max, i);
		}
		boolean[] seen = new boolean[max + 1];
		for (int i : nums) {
			if (!seen[i]) {
				seen[i] = true;
				n++;
			}
		}
		for (int i = 0; i <= max; i++) {
			if (seen[i]) {
				nums[idx++] = i;
			}
		}

		seen = new boolean[max << 1 + 1];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				seen[nums[i] ^ nums[j]] = true;
			}
		}

		int cnt = 0;
		for (int i = 0; i <= (max << 1); i++) {
			if (seen[i]) {
				cnt++;
			}
		}
		int[] arr = new int[cnt];
		idx = 0;
		for (int i = 0; i <= (max << 1); i++) {
			if (seen[i]) {
				arr[idx++] = i;
			}
		}

		boolean[] triplets = new boolean[max << 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < cnt; j++) {
				triplets[nums[i] ^ arr[j]] = true;
			}
		}
		int ans = 0;
		for (boolean b : triplets) {
			ans += b ? 1 : 0;
		}
		return ans;
	}
}
