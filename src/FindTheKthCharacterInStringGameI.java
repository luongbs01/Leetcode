/**
 * Description: https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/
 */

public class FindTheKthCharacterInStringGameI {

    public char kthCharacter(int k) {
        int ans = 0;
        while (k > 1) {
            int i = 1;
            while (i * 2 < k) {
                i *= 2;
            }
            k -= i;
            ans++;
        }
        return (char) ('a' + ans);
    }
}
