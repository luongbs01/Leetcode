import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/count-covered-buildings/
 */

public class CountCoveredBuildings {

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
}
