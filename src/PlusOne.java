import java.util.ArrayList;

/**
 * Description: https://leetcode.com/problems/plus-one/description/
 */

public class PlusOne {
	public int[] plusOne(int[] digits) {
		ArrayList<Integer> list = new ArrayList<>(digits.length + 1);
		int carry = 1;
		int digit;
		for (int i = digits.length - 1; i >= 0; i--) {
			digit = digits[i] + carry;
			list.add(digit % 10);
			carry = digit / 10;
		}
		if (carry == 1) {
			list.add(1);
		}
		int[] ans = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(list.size() - 1 - i);
		}
		return ans;
	}
}
