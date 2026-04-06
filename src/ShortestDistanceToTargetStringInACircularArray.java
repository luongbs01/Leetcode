/**
 * Description: https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/
 */

public class ShortestDistanceToTargetStringInACircularArray {

	public int closestTarget(String[] words, String target, int startIndex) {
		int n = words.length;
		for (int dist = 0; dist <= n / 2; dist++) {
			if (target.equals(words[(startIndex + dist) % n])
				|| target.equals(words[(startIndex - dist + n) % n])) {
				return dist;
			}
		}
		return -1;
	}
}
