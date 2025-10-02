/**
 * Description: https://leetcode.com/problems/water-bottles-ii/description/
 */

public class WaterBottlesII {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            numBottles -= numExchange;
            ans++;
            numExchange++;
            numBottles++;
        }
        return ans;
    }
}
