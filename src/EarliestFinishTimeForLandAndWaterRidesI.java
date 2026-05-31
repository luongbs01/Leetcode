/**
 * Description: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/
 */

public class EarliestFinishTimeForLandAndWaterRidesI {

	public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
		int ans = Integer.MAX_VALUE, earliestLandFinishTime = Integer.MAX_VALUE, earliestWaterFinishTime = Integer.MAX_VALUE;
		for (int i = 0; i < landStartTime.length; i++) {
			earliestLandFinishTime = Math.min(earliestLandFinishTime, landStartTime[i] + landDuration[i]);
		}
		for (int i = 0; i < waterStartTime.length; i++) {
			if (waterStartTime[i] >= earliestLandFinishTime) {
				ans = Math.min(ans, waterStartTime[i] + waterDuration[i]);
			} else {
				ans = Math.min(ans, earliestLandFinishTime + waterDuration[i]);
			}
		}

		for (int i = 0; i < waterStartTime.length; i++) {
			earliestWaterFinishTime = Math.min(earliestWaterFinishTime, waterStartTime[i] + waterDuration[i]);
		}
		for (int i = 0; i < landStartTime.length; i++) {
			if (landStartTime[i] >= earliestWaterFinishTime) {
				ans = Math.min(ans, landStartTime[i] + landDuration[i]);
			} else {
				ans = Math.min(ans, earliestWaterFinishTime + landDuration[i]);
			}
		}
		return ans;
	}
}
