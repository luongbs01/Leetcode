/**
 * Description: https://leetcode.com/problems/jump-game-vii/description/
 */

public class JumpGameVII {

	// dp + sliding window
	public boolean canReach(String s, int minJump, int maxJump) {
		int n = s.length(), cnt = 0;
		char[] chars = s.toCharArray();
		boolean[] canReach = new boolean[n];
		canReach[0] = true;
		for (int i = minJump; i <= maxJump; i++) {
			if (chars[i] == '0') {
				canReach[i] = true;
				cnt++;
			}
		}
		if (cnt == 0)
			return false;

		cnt = 0;
		for (int i = 0; i <= maxJump - minJump; i++) {
			if (chars[i] == '0' && canReach[i]) {
				cnt++;
			}
		}
		for (int i = maxJump + 1; i < n; i++) {
			cnt += (canReach[i - minJump] ? 1 : 0);
			cnt -= (canReach[i - maxJump - 1] ? 1 : 0);
			if (chars[i] == '0' && cnt > 0) {
				canReach[i] = true;
			}
		}
		return canReach[n - 1];
	}
}
