/**
 * Description: https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/
 */

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        if (n < 3) return false;
        char[] chars = colors.toCharArray();
        int turnA = 0, turnB = 0;
        for (int i = 1; i < n - 1; i++) {
            if (chars[i - 1] == chars[i] && chars[i] == chars[i + 1]) {
                if (chars[i] == 'A') turnA++;
                else turnB++;
            }
        }
        return turnA > turnB;
    }
}
