/**
 * Description: https://leetcode.com/problems/water-bottles/description/
 */

public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int num = numBottles / numExchange;
            ans += num;
            numBottles = numBottles % numExchange + num;
        }
        return ans;
    }
}
