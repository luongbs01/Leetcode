/**
 * Description: https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/description/
 */

public class TakingMaximumEnergyFromTheMysticDungeon {

    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length, ans = Integer.MIN_VALUE;
        int[] absorb = new int[k];
        for (int i = n - 1; i >= 0; i--) {
            absorb[i % k] += energy[i];
            ans = Math.max(ans, absorb[i % k]);
        }
        return ans;
    }
}
