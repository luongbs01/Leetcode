/**
 * Description: https://leetcode.com/problems/find-and-replace-pattern/
 */

public class MaximumValueAfterInsertion {

	public String maxValue(String n, int x) {
		int sign = n.charAt(0) == '-' ? -1 : 1;
		int i = sign > 0 ? 0 : 1;
		while (i < n.length() && (n.charAt(i) - '0') * sign >= x * sign) {
			i++;
		}
		if (i < n.length())
			return n.substring(0, i) + x + n.substring(i);
		return n + x;
	}
}
