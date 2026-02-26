/**
 * Description: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/
 */

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {

	public int numSteps(String s) {
		int ans = 0, carry = 0;
		char[] chars = s.toCharArray();
		for (int i = s.length() - 1; i > 0; i--) {
			int digit = chars[i] - '0' + carry;
			if (digit % 2 == 1) {
				ans += 2;
				carry = 1;
			} else {
				ans++;
			}
		}
		return ans + carry;
	}
}
