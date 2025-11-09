/**
 * Description: https://leetcode.com/problems/rabbits-in-forest/
 */

public class RabbitsInForest {

    public int numRabbits(int[] answers) {
        int[] count = new int[1001];
        for (int i : answers) {
            count[i]++;
        }
        int ans = 0;
        for (int i = 0; i < 1001; i++) {
            ans += (count[i] / (i + 1) + (count[i] % (i + 1) != 0 ? 1 : 0)) * (i + 1);
        }
        return ans;
    }
}
