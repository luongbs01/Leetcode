/**
 * Description: https://leetcode.com/problems/fruits-into-baskets-ii/description/
 */

public class FruitsIntoBasketsII {

    // O(n) space
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, count = 0;
        boolean[] used = new boolean[n];
        for (int fruit : fruits) {
            for (int i = 0; i < n; i++) {
                if (fruit <= baskets[i] && !used[i]) {
                    used[i] = true;
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }

    // O(1) space
    public int numOfUnplacedFruits2(int[] fruits, int[] baskets) {
        int n = fruits.length, count = 0;
        for (int fruit : fruits) {
            for (int i = 0; i < n; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = -1;
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }
}
