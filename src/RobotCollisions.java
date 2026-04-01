import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Description: https://leetcode.com/problems/robot-collisions/description/
 */

public class RobotCollisions {

	public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
		int n = positions.length;
		List<List<Integer>> robots = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			robots.add(Arrays.asList(i, positions[i], healths[i], directions.charAt(i) == 'L' ? 0 : 1));
		}
		robots.sort(Comparator.comparingInt(o -> o.get(1)));
		List<List<Integer>> stack = new ArrayList<>();
		for (List<Integer> robot : robots) {
			stack.add(robot);
			while (stack.size() > 1 && stack.get(stack.size() - 2).get(3) == 1 && stack.getLast().get(3) == 0) {
				List<Integer> robot2 = stack.removeLast();
				List<Integer> robot1 = stack.removeLast();

				// Must NOT use : robot1.get(2) == robot2.get(2)
				// Because: Java compares the object references, not the values, for numbers outside the range of -128 to 127
				// Refer to https://gpcoder.com/3468-integer-constant-pool-trong-java/
				if (Objects.equals(robot1.get(2), robot2.get(2))) {
					break;
				} else if (robot1.get(2) > robot2.get(2)) {
					int newHealth = robot1.get(2) - 1;
					if (newHealth > 0) {
						robot1.set(2, newHealth);
						stack.add(robot1);
					}
				} else {
					int newHealth = robot2.get(2) - 1;
					if (newHealth > 0) {
						robot2.set(2, newHealth);
						stack.add(robot2);
					}
				}
			}
		}
		if (stack.isEmpty()) {
			return List.of();
		}
		stack.sort(Comparator.comparingInt(List::getFirst));
		List<Integer> ans = new ArrayList<>();
		for (List<Integer> l : stack) {
			ans.add(l.get(2));
		}
		return ans;
	}
}
