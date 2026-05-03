/**
 * Description: https://leetcode.com/problems/rotate-string/
 */

public class RotateString {

	public boolean rotateString(String s, String goal) {
		return s.length() == goal.length() && s.repeat(2).contains(goal);
	}
}
