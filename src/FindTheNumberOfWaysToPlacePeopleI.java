/**
 * Description: https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/description/
 */

public class FindTheNumberOfWaysToPlacePeopleI {

    public int numberOfPairs(int[][] points) {
        int n = points.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && points[i][0] <= points[j][0] && points[i][1] >= points[j][1]) {
                    boolean valid = true;
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j
                                && points[i][0] <= points[k][0] && points[k][0] <= points[j][0]
                                && points[i][1] >= points[k][1] && points[k][1] >= points[j][1]) {
                            valid = false;
                            break;
                        }
                    }
                    ans += valid ? 1 : 0;
                }
            }
        }
        return ans;
    }
}
