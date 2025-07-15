/**
 * Description: https://leetcode.com/problems/longest-uncommon-subsequence-ii/description/
 */

public class LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    private boolean isSubsequence(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s1.length();
    }
}
