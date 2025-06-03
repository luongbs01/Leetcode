import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/description/
 */

public class MaximumCandiesYouCanGetFromBoxes {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans = 0;
        Set<Integer> boxes = new HashSet<>();
        for (int i : initialBoxes) {
            boxes.add(i);
        }
        Set<Integer> openedBoxes = new HashSet<>();
        Set<Integer> newBoxes = new HashSet<>();
        int count = 1;
        while (count > 0) {
            count = 0;
            openedBoxes.clear();
            newBoxes.clear();
            for (int box : boxes) {
                if (status[box] == 1) {
                    ans += candies[box];
                    openedBoxes.add(box);
                    count++;
                    for (int k : keys[box]) {
                        status[k] = 1;
                    }
                    for (int i : containedBoxes[box]) {
                        newBoxes.add(i);
                    }
                }
            }
            boxes.removeAll(openedBoxes);
            boxes.addAll(newBoxes);
        }
        return ans;
    }
}
