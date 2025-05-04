/**
 * Description: https://leetcode.com/problems/koko-eating-bananas/description/
 */

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1, mid, time;
        int length = piles.length;
        for (int i = 0; i < length; i++) {
            high = Math.max(high, piles[i]);
        }
        while (low < high) {
            mid = (low + high) >>> 1;
            time = timeToEat(piles, mid);
            if (time > h) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private int timeToEat(int[] piles, int speed) {
        int time = 0, length = piles.length;
        for (int i = 0; i < length; i++) {
            time += (int) Math.ceil((double) piles[i] / speed);
        }
        return time;
    }
}
