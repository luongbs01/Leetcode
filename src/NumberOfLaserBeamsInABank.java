/**
 * Description: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
 */

public class NumberOfLaserBeamsInABank {

    public int numberOfBeams(String[] bank) {
        int ans = 0, prev = 0, curr = 0;
        for (String str : bank) {
            char[] chars = str.toCharArray();
            for (char c : chars) {
                if (c == '1') curr++;
            }
            if (curr > 0) {
                ans += prev * curr;
                prev = curr;
                curr = 0;
            }
        }
        return ans;
    }
}
