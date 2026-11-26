/**
 * Description: https://leetcode.com/problems/stone-removal-game/
 */

public class StoneRemovalGame {

    public boolean canAliceWin(int n) {
        for (int i = 10; i >= 0; i--) {
            n -= i;
            if (n < 0) {
                return (i & 1) != 0;
            }
        }
        return false;
    }
}
