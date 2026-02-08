import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/design-ride-sharing-system/description/
 */

public class DesignRideSharingSystem {

	class RideSharingSystem {

		Queue<Integer> rider;
		Queue<Integer> driver;
		boolean[] cancelled;

		public RideSharingSystem() {
			rider = new ArrayDeque<>();
			driver = new ArrayDeque<>();
			cancelled = new boolean[1001];
		}

		public void addRider(int riderId) {
			rider.offer(riderId);
			cancelled[riderId] = false;
		}

		public void addDriver(int driverId) {
			driver.offer(driverId);
		}

		public int[] matchDriverWithRider() {
			while (!rider.isEmpty() && cancelled[rider.peek()]) {
				rider.poll();
			}
			if (rider.isEmpty() || driver.isEmpty()) {
				return new int[] { -1, -1 };
			}
			return new int[] { driver.poll(), rider.poll() };
		}

		public void cancelRider(int riderId) {
			cancelled[riderId] = true;
		}
	}
}
