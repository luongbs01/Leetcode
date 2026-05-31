import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/destroying-asteroids/
 */

public class DestroyingAsteroids {

	public boolean asteroidsDestroyed(int mass, int[] asteroids) {
		Arrays.sort(asteroids);
		long total = mass;
		for (int asteroid : asteroids) {
			if (total < asteroid) {
				return false;
			}
			total += asteroid;
		}
		return true;
	}
}
