import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/my-calendar-i/
 */

public class MyCalendarI {

	class MyCalendar {

		List<int[]> calendar;

		public MyCalendar() {
			calendar = new ArrayList<>();
		}

		public boolean book(int startTime, int endTime) {
			for (int[] event : calendar) {
				int start = event[0], end = event[1];
				if ((startTime >= start && startTime < end)
					|| (endTime > start && endTime <= end)
					|| (startTime <= start && endTime >= end)) {
					return false;
				}
			}
			calendar.add(new int[] { startTime, endTime });
			return true;
		}
	}
}
