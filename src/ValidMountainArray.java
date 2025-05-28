/**
 * Description: https://leetcode.com/problems/valid-mountain-array/description/
 */

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        int left = 0, right = arr.length - 2;
        while (left <= right && arr[left] < arr[left + 1]) {
            left++;
        }
        while (left <= right && arr[right] > arr[right + 1]) {
            right--;
        }
        return left < arr.length - 1 && right >= 0 && left > right;
    }
}
