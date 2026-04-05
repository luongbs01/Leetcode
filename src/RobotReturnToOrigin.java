/**
 * Description: https://leetcode.com/problems/decode-the-slanted-ciphertext/
 */

public class RobotReturnToOrigin {

	public boolean judgeCircle(String moves) {
		int vertical = 0, horizontal = 0;
		for (char c : moves.toCharArray()) {
			switch (c) {
			case 'U':
				vertical++;
				break;
			case 'D':
				vertical--;
				break;
			case 'L':
				horizontal--;
				break;
			case 'R':
				horizontal++;
			}
		}
		return vertical == 0 && horizontal == 0;
	}
}
