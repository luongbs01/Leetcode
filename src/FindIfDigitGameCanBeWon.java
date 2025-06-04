/**
 * Description: https://leetcode.com/problems/find-if-digit-game-can-be-won/description/
 */

public class FindIfDigitGameCanBeWon {

    public boolean canAliceWin(int[] nums) {
        int sum = 0;
        int sumSingleDigit = 0;
        for (int i : nums) {
            sum += i;
            if (i < 10) {
                sumSingleDigit += i;
            }
        }
        return sumSingleDigit * 2 != sum;
    }
}
