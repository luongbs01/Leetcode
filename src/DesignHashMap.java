import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/design-hashmap/
 */

public class DesignHashMap {

	class MyHashMap {

		int MAX = 1_000_001;
		int[] map;

		public MyHashMap() {
			map = new int[MAX];
			Arrays.fill(map, -1);
		}

		public void put(int key, int value) {
			map[key] = value;
		}

		public int get(int key) {
			return map[key];
		}

		public void remove(int key) {
			map[key] = -1;
		}
	}
}
