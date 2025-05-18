import java.util.Iterator;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/plus-one/description/
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();
        int m = 0;
        int digit;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digit = digits[i] + 1;
            } else {
                digit = digits[i] + m;
            }
            list.addFirst(digit % 10);
            m = digit / 10;
        }
        if (m == 1) {
            list.addFirst(1);
        }
        int[] ans = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            ans[i] = iterator.next();
        }
        return ans;
    }
}
