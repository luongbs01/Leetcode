import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii/description/
 */

public class FindTheNumberOfWaysToPlacePeopleII {

    public int numberOfPairs(int[][] points) {
        int n = points.length, ans = 0;
        Arrays.sort(points, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
        for (int i = 0; i < n - 1; i++) {
            int lowestY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (points[j][1] <= points[i][1]) {
                    if (points[j][1] > lowestY) {
                        ans++;
                    }
                    lowestY = Math.max(lowestY, points[j][1]);
                }
            }
        }
        return ans;
    }
}
