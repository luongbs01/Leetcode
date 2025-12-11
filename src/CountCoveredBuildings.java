import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/count-covered-buildings/
 */

public class CountCoveredBuildings {

    // 439ms
    public int countCoveredBuildings(int n, int[][] buildings) {
        int len = buildings.length;
        if (buildings.length < 5) return 0;
        Arrays.sort(buildings, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        Set<String> set1 = new HashSet<>();
        for (int i = 1; i < len - 1; i++) {
            if (buildings[i - 1][0] == buildings[i][0] && buildings[i + 1][0] == buildings[i][0]) {
                set1.add(Arrays.toString(buildings[i]));
            }
        }
        Arrays.sort(buildings, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        Set<String> set2 = new HashSet<>();
        for (int i = 1; i < len - 1; i++) {
            if (buildings[i - 1][1] == buildings[i][1] && buildings[i + 1][1] == buildings[i][1]) {
                set2.add(Arrays.toString(buildings[i]));
            }
        }
        set1.retainAll(set2);
        return set1.size();
    }

    // 13ms
    public int countCoveredBuildingsV2(int n, int[][] buildings) {
        int[] xMax = new int[n + 1], xMin = new int[n + 1], yMax = new int[n + 1], yMin = new int[n + 1];
        Arrays.fill(xMin, n + 1);
        Arrays.fill(yMin, n + 1);
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            xMax[x] = Math.max(xMax[x], y);
            xMin[x] = Math.min(xMin[x], y);
            yMax[y] = Math.max(yMax[y], x);
            yMin[y] = Math.min(yMin[y], x);
        }
        int ans = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if (y > xMin[x] && y < xMax[x] && x > yMin[y] && x < yMax[y]) {
                ans++;
            }
        }
        return ans;
    }
}
