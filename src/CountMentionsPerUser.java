import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/count-mentions-per-user/
 */

public class CountMentionsPerUser {

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] ans = new int[numberOfUsers];
        List<List<Integer>> mentions = new ArrayList<>(numberOfUsers);
        for (int i = 0; i < numberOfUsers; i++) {
            mentions.add(new ArrayList<>());
        }
        for (List<String> event : events) {
            if (event.get(0).equals("OFFLINE")) {
                mentions.get(Integer.parseInt(event.get(2))).add(Integer.valueOf(event.get(1)));
            }
        }
        for (List<String> event : events) {
            if (event.get(0).equals("MESSAGE")) {
                int timestamp = Integer.parseInt(event.get(1));
                if (event.get(2).equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        ans[i]++;
                    }
                } else if (event.get(2).equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        boolean isMentioned = true;
                        for (int offline : mentions.get(i)) {
                            if (timestamp >= offline && timestamp < offline + 60) {
                                isMentioned = false;
                                break;
                            }
                        }
                        if (isMentioned)
                            ans[i]++;
                    }
                } else {
                    String mentionString = event.get(2);
                    String[] mentionArr = mentionString.split(" ");
                    for (String str : mentionArr) {
                        ans[Integer.parseInt(str.substring(2))]++;
                    }
                }
            }
        }
        return ans;
    }
}
