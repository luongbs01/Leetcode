import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/cinema-seat-allocation/
 */

public class CinemaSeatAllocation {

	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		int m = reservedSeats.length, ans = 0;
		Set<Integer> set = new HashSet<>(m);
		boolean[] reserved = new boolean[11];
		Arrays.sort(reservedSeats, Comparator.comparingInt(o -> o[0]));
		for (int i = 1; i <= m; i++) {
			reserved[reservedSeats[i - 1][1]] = true;
			if (i == m || reservedSeats[i - 1][0] != reservedSeats[i][0]) {
				set.add(reservedSeats[i - 1][0]);
				if (!(reserved[2] || reserved[3] || reserved[4] || reserved[5]
					|| reserved[6] || reserved[7] || reserved[8] || reserved[9])) {
					ans += 2;
				} else if (!(reserved[2] || reserved[3] || reserved[4] || reserved[5])
					|| !(reserved[4] || reserved[5] || reserved[6] || reserved[7])
					|| !(reserved[6] || reserved[7] || reserved[8] || reserved[9])) {
					++ans;
				}
				for (int j = 2; j <= 9; j++) {
					reserved[j] = false;
				}
			}
		}
		return ans + ((n - set.size()) << 1);
	}
}
