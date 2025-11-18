/**
 * Description: https://leetcode.com/problems/1-bit-and-2-bit-characters/
 */

public class _1bitAnd2bitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length - 1, index = 0;
        while (index < n) {
            index += bits[index] + 1;
        }
        return index == n;
    }
}
