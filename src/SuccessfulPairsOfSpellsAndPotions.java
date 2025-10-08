import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
 */

public class SuccessfulPairsOfSpellsAndPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int l = 0, r = m, mid;
            while (l < r) {
                mid = (l + r) >> 1;
                if ((long) spells[i] * potions[mid] < success) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            pairs[i] = m - l;
        }
        return pairs;
    }
}
