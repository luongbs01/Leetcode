/**
 * Description: https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/
 */

public class MaximumManhattanDistanceAfterKChanges {

    public int maxDistance(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int horizontal = 0, vertical = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            switch (chars[i]) {
                case 'N':
                    vertical++;
                    break;
                case 'S':
                    vertical--;
                    break;
                case 'E':
                    horizontal++;
                    break;
                case 'W':
                    horizontal--;
                    break;
            }
            ans = Math.max(ans, Math.min(Math.abs(horizontal) + Math.abs(vertical) + 2 * k, i + 1));
        }
        return ans;
    }
}
