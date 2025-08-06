/**
 * Description: https://leetcode.com/problems/fruits-into-baskets-iii/description/
 */

public class FruitsIntoBasketsIII {

    int[] segTree;
    int[] baskets;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        segTree = new int[n * 4];
        this.baskets = baskets;
        build(1, 0, n - 1);
        int ans = 0;
        for (int fruit : fruits) {
            int index = get(1, fruit, 0, n - 1);
            if (index == -1) {
                ans++;
            } else {
                update(1, index, -1, 0, n - 1);
            }
        }
        return ans;
    }

    private void build(int id, int l, int r) {
        if (l == r) {
            segTree[id] = baskets[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(id << 1, l, mid);
        build(id << 1 | 1, mid + 1, r);
        segTree[id] = Math.max(segTree[id << 1], segTree[id << 1 | 1]);
    }

    private void update(int id, int index, int newValue, int l, int r) {
        if (l > index || r < index) {
            return;
        }
        if (l == r) {
            segTree[id] = newValue;
            return;
        }
        int mid = (l + r) >> 1;
        update(id << 1, index, newValue, l, mid);
        update(id << 1 | 1, index, newValue, mid + 1, r);
        segTree[id] = Math.max(segTree[id << 1], segTree[id << 1 | 1]);
    }

    private int get(int id, int value, int l, int r) {
        if (segTree[id] < value) {
            return -1;
        }
        if (l == r) {
            return l;
        }
        int mid = (l + r) >> 1;
        if (segTree[id << 1] >= value) {
            return get(id << 1, value, l, mid);
        }
        return get(id << 1 | 1, value, mid + 1, r);
    }
}
