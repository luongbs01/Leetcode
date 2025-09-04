/**
 * Description: https://leetcode.com/problems/find-closest-person/description/
 */

public class FindClosestPerson {

    public int findClosest(int x, int y, int z) {
        return Math.abs(z - x) == Math.abs(z - y) ? 0 : Math.abs(z - x) < Math.abs(z - y) ? 1 : 2;
    }
}
