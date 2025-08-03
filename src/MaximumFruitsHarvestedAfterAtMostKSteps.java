/**
 * Description: https://leetcode.com/problems/rearranging-fruits/description/
 */

public class MaximumFruitsHarvestedAfterAtMostKSteps {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = Math.max(fruits[fruits.length - 1][0], startPos) + 1;
        int[] fruit = new int[n];
        for (int[] i : fruits) {
            fruit[i[0]] = i[1];
        }
        int maxLeft = Math.min(startPos, k) + 1;
        int maxRight = Math.min(n - startPos - 1, k) + 1;
        int[] left = new int[maxLeft], right = new int[maxRight]; // left[i]: total fruits harvested when stepping i to the left
        left[0] = fruit[startPos];
        right[0] = fruit[startPos];
        for (int i = 1; i < maxLeft; i++) {
            left[i] = left[i - 1] + fruit[startPos - i];
        }
        for (int i = 1; i < maxRight; i++) {
            right[i] = right[i - 1] + fruit[startPos + i];
        }
        int ans = 0;
        for (int i = 0; i < maxLeft; i++) {
            ans = Math.max(ans, left[i] + right[Math.max(Math.min(k - 2 * i, maxRight - 1), 0)] - right[0]);
        }
        for (int i = 0; i < maxRight; i++) {
            ans = Math.max(ans, right[i] + left[Math.max(Math.min(k - 2 * i, maxLeft - 1), 0)] - left[0]);
        }
        return ans;
    }
}
