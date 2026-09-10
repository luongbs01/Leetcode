import java.util.*;

/**
 * Description: https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
 */

public class MaximumNumberOfNonOverlappingPalindromeSubstrings {

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int dist = 1;
            while (dist * 2 - 1 < k && i - dist >= 0 && i + dist < n && chars[i - dist] == chars[i + dist]) {
                dist++;
            }
            if (dist * 2 - 1 >= k) {
                intervals.add(new int[]{i - dist + 1, i + dist - 1});
            }

            dist = 0;
            while (dist * 2 < k && i - dist >= 0 && i + 1 + dist < n && chars[i - dist] == chars[i + 1 + dist]) {
                dist++;
            }
            if (dist * 2 >= k) {
                intervals.add(new int[]{i - dist + 1, i + dist});
            }
        }

        int ans = 0, endIndex = -1;
        for (int[] interval : intervals) {
            if (interval[0] > endIndex) {
                ans++;
                endIndex = interval[1];
            }
        }
        return ans;
    }
}
