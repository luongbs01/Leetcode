import java.util.HashMap;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/longest-balanced-substring-ii/description/
 */

public class LongestBalancedSubstringII {

	int n;

	public int longestBalanced(String s) {
		n = s.length();
		char[] chars = s.toCharArray();
		int ans = 1;
		ans = Math.max(ans, count1(chars));
		ans = Math.max(ans, count2(chars, 'a', 'b'));
		ans = Math.max(ans, count2(chars, 'b', 'c'));
		ans = Math.max(ans, count2(chars, 'a', 'c'));
		ans = Math.max(ans, count3(chars));
		return ans;
	}

	private int count1(char[] chars) {
		int ans = 1, count = 1;
		for (int i = 1; i < n; i++) {
			if (chars[i - 1] == chars[i]) {
				count++;
				ans = Math.max(ans, count);
			} else {
				count = 1;
			}
		}
		return ans;
	}

	private int count2(char[] chars, char a, char b) {
		HashMap<Integer, Integer> pos = new HashMap<>();
		pos.put(0, -1);
		int cntA = 0, cntB = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			if (chars[i] != a && chars[i] != b) {
				pos = new HashMap<>();
				pos.put(0, i);
				cntA = 0;
				cntB = 0;
				continue;
			}
			if (chars[i] == a) {
				cntA++;
			} else {
				cntB++;
			}
			if (pos.get(cntA - cntB) != null) {
				ans = Math.max(ans, i - pos.get(cntA - cntB));
			} else {
				pos.put(cntA - cntB, i);
			}
		}
		return ans;
	}

	private int count3(char[] chars) {
		int ans = 0;
		int[] cnt = new int[3];
		HashMap<List<Integer>, Integer> pos = new HashMap<>();
		pos.put(List.of(0, 0), -1);
		for (int i = 0; i < n; i++) {
			cnt[chars[i] - 'a']++;
			int diffAB = cnt[0] - cnt[1];
			int diffBC = cnt[1] - cnt[2];
			List<Integer> key = List.of(diffAB, diffBC);
			Integer val = pos.get(key);
			if (val != null) {
				ans = Math.max(ans, i - val);
			} else {
				pos.put(key, i);
			}
		}
		return ans;
	}
}
