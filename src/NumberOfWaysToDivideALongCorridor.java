/**
 * Description: https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
 */

public class NumberOfWaysToDivideALongCorridor {

    public int numberOfWays(String corridor) {
        char[] chars = corridor.toCharArray();
        int seats = 0, mod = 1_000_000_007;
        for (char c : chars) {
            if (c == 'S') seats++;
        }
        if (seats < 2 || (seats & 1) != 0) {
            return 0;
        }
        if (seats == 2) return 1;
        seats = 0;
        long ans = 1, cnt = 0;
        for (char c : chars) {
            if (c == 'P') cnt++;
            else if (seats < 2) {
                seats++;
                cnt = 0;
            } else {
                ans = (ans * (cnt + 1)) % mod;
                seats = 1;
                cnt = 0;
            }
        }
        return (int) ans % mod;
    }
}
