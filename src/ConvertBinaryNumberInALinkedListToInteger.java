/**
 * Description: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 */

public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans << 1 | head.val;
            head = head.next;
        }
        return ans;
    }
}
