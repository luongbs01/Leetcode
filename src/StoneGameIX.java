/**
 * Description: https://leetcode.com/problems/stone-game-ix/
 */

public class StoneGameIX {

	public boolean stoneGameIX(int[] stones) {
		int[] cnt = new int[3];
		for (int stone : stones) {
			cnt[stone % 3]++;
		}
		if ((cnt[0] & 1) == 0) {
			return cnt[1] >= 1 && cnt[2] >= 1;
		}
		return Math.abs(cnt[1] - cnt[2]) >= 3;
	}
}
