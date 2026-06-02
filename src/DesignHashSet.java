/**
 * Description: https://leetcode.com/problems/design-hashset/
 */

public class DesignHashSet {

	class MyHashSet {

		int MAX = 1_000_001;
		boolean[] marked;

		public MyHashSet() {
			marked = new boolean[MAX];
		}

		public void add(int key) {
			marked[key] = true;
		}

		public void remove(int key) {
			marked[key] = false;
		}

		public boolean contains(int key) {
			return marked[key];
		}
	}
}
