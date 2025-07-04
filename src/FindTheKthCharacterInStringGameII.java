/**
 * Description: https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/description/
 */

public class FindTheKthCharacterInStringGameII {

    public char kthCharacter(long k, int[] operations) {
        int ans = 0;
        while (k > 1) {
            long i = 1;
            int cnt = 0;
            while (i * 2 < k) {
                i *= 2;
                cnt++;
            }
            k -= i;
            ans += operations[cnt];
        }
        return (char) ('a' + ans % 26);
    }
}
