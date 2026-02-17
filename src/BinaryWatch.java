import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/binary-watch/
 */

public class BinaryWatch {

	public List<String> readBinaryWatch(int turnedOn) {
		List<String> ans = new ArrayList<>();
		for (int h = 0; h < 12; h++) {
			for (int m = 0; m < 60; m++) {
				if (countBit(h, m) == turnedOn) {
					String hour = String.valueOf(h);
					String minute = String.valueOf(m);
					if (minute.length() < 2) {
						minute = "0" + minute;
					}
					ans.add(hour + ":" + minute);
				}
			}
		}
		return ans;
	}

	private int countBit(int h, int m) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if ((h & (1 << i)) != 0) {
				cnt++;
			}
		}
		for (int i = 0; i < 6; i++) {
			if ((m & (1 << i)) != 0) {
				cnt++;
			}
		}
		return cnt;
	}
}
