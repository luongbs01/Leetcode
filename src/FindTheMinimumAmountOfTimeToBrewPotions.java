/**
 * Description: https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/description/
 */

public class FindTheMinimumAmountOfTimeToBrewPotions {

    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long minStartTime = 0, sum = 0;
        long[] endTime = new long[n];
        for (int i = 0; i < m; i++) {
            endTime[0] = minStartTime + (long) mana[i] * skill[0];
            minStartTime = endTime[0];
            if (i < m - 1)
                sum = (long) mana[i + 1] * skill[0];
            for (int j = 1; j < n; j++) {
                endTime[j] = endTime[j - 1] + (long) mana[i] * skill[j];
                minStartTime = Math.max(minStartTime, endTime[j] - sum);
                if (i < m - 1)
                    sum += (long) mana[i + 1] * skill[j];
            }
        }
        return endTime[n - 1];
    }
}
