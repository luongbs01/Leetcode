import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/reordered-power-of-2/description/
 */

public class ReorderedPowerOf2 {

    public boolean reorderedPowerOf2(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        String str = Arrays.toString(freq);
        n = 1;
        while (n < 1000000000) {
            int i = n;
            freq = new int[10];
            while (i > 0) {
                freq[i % 10]++;
                i /= 10;
            }
            if (str.equals(Arrays.toString(freq))) return true;
            n <<= 1;
        }
        return false;
    }
}
