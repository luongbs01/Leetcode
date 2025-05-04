import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/time-based-key-value-store/description/
 */

public class TimeBasedKeyValueStore {
    Map<String, ArrayList<Object[]>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        ArrayList<Object[]> arrayList = map.getOrDefault(key, new ArrayList<>());
        arrayList.add(new Object[]{timestamp, value});
        map.put(key, arrayList);
    }

    public String get(String key, int timestamp) {
        ArrayList<Object[]> arrayList = map.get(key);
        if (arrayList == null || arrayList.isEmpty()) {
            return "";
        }
        int length = arrayList.size();
        int low = 0, high = length - 1, mid = 0;
        while (low < high) {
            mid = (low + high + 1) >>> 1;
            if ((int) arrayList.get(mid)[0] == timestamp) {
                return (String) arrayList.get(mid)[1];
            } else if ((int) arrayList.get(mid)[0] < timestamp) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int) arrayList.get(low)[0] <= timestamp ? (String) arrayList.get(low)[1] : "";
    }
}
