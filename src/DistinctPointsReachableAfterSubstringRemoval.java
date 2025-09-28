import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/distinct-points-reachable-after-substring-removal/
 */

public class DistinctPointsReachableAfterSubstringRemoval {

    public int distinctPoints(String s, int k) {
        int x = 0, y = 0;
        char[] chars = s.toCharArray();
        Set<List<Integer>> set = new HashSet<>();
        for (char c : chars) {
            if (c == 'L') x--;
            else if (c == 'R') x++;
            else if (c == 'D') y--;
            else if (c == 'U') y++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == 'L') x++;
            else if (chars[i] == 'R') x--;
            else if (chars[i] == 'D') y++;
            else if (chars[i] == 'U') y--;
            if (i == k - 1) set.add(List.of(x, y));
            if (i >= k) {
                if (chars[i - k] == 'L') x--;
                else if (chars[i - k] == 'R') x++;
                else if (chars[i - k] == 'D') y--;
                else if (chars[i - k] == 'U') y++;
                set.add(List.of(x, y));
            }
        }
        return set.size();
    }
}
