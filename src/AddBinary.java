/**
 * Description: https://leetcode.com/problems/add-binary/
 */

public class AddBinary {

	public String addBinary(String a, String b) {
		int m = a.length() - 1, n = b.length() - 1, carry = 0;
		StringBuilder ans = new StringBuilder(Math.max(m, n) + 1);
		char[] charsA = a.toCharArray(), charsB = b.toCharArray();
		while (m >= 0 || n >= 0) {
			int i = m >= 0 ? (charsA[m] - '0') : 0;
			int j = n >= 0 ? (charsB[n] - '0') : 0;
			int sum = i + j + carry;
			ans.append(sum % 2);
			carry = sum / 2;
			m--;
			n--;
		}
		if (carry > 0) {
			ans.append(1);
		}
		return ans.reverse().toString();
	}
}
