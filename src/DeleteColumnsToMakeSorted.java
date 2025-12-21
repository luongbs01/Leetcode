/**
 * Description: https://leetcode.com/problems/delete-columns-to-make-sorted/
 */

public class DeleteColumnsToMakeSorted {

	public int minDeletionSize(String[] strs) {
		int n = strs.length, m = strs[0].length(), ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
					ans++;
					break;
				}
			}
		}
		return ans;
	}
}
