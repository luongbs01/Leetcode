/**
 * Description: https://leetcode.com/problems/longest-uploaded-prefix/
 */

public class LongestUploadedPrefix {

	class LUPrefix {

		boolean[] uploaded;
		int longest;

		public LUPrefix(int n) {
			uploaded = new boolean[n + 1];
			longest = 0;
		}

		public void upload(int video) {
			uploaded[video] = true;
			while (longest + 1 < uploaded.length && uploaded[longest + 1]) {
				++longest;
			}
		}

		public int longest() {
			return longest;
		}
	}
}
