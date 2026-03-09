/**
 * Description: https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 */

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
