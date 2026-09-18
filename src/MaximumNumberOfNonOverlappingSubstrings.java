import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
 */

public class MaximumNumberOfNonOverlappingSubstrings {

    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        for (int i = 0; i < n; i++) {
            if (start[chars[i] - 'a'] == -1) {
                start[chars[i] - 'a'] = i;
            }
            end[chars[i] - 'a'] = i;
        }

        List<int[]> intervals = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            int startIdx = start[i];
            int endIdx = end[i];
            if (startIdx == -1)
                continue;
            boolean valid = true;
            for (int j = endIdx - 1; j >= startIdx; j--) {
                if (end[chars[j] - 'a'] > endIdx) {
                    valid = false;
                    break;
                }
                startIdx = Math.min(startIdx, start[chars[j] - 'a']);
            }
            if (valid) {
                intervals.add(new int[] { startIdx, endIdx });
            }
        }

        intervals.sort(Comparator.comparingInt(o -> o[1]));
        List<String> ans = new ArrayList<>();
        int endIdx = -1;
        for (int[] interval : intervals) {
            if (interval[0] > endIdx) {
                ans.add(s.substring(interval[0], interval[1] + 1));
                endIdx = interval[1];
            }
        }
        return ans;
    }
}
