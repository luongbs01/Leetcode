import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Description: https://leetcode.com/problems/design-a-number-container-system/description/
 */

public class DesignANumberContainerSystem {

    class NumberContainers {

        Map<Integer, Integer> indexMap;
        Map<Integer, SortedSet<Integer>> numberMap;

        public NumberContainers() {
            indexMap = new HashMap<>();
            numberMap = new HashMap<>();
        }

        public void change(int index, int number) {
            if (indexMap.containsKey(index)) {
                int oldNumber = indexMap.get(index);
                if (numberMap.containsKey(oldNumber)) {
                    numberMap.get(oldNumber).remove(index);
                    if (numberMap.get(oldNumber).isEmpty()) {
                        numberMap.remove(oldNumber);
                    }
                }
            }
            indexMap.put(index, number);
            if (!numberMap.containsKey(number)) {
                numberMap.put(number, new TreeSet<>());
            }
            numberMap.get(number).add(index);
        }

        public int find(int number) {
            return numberMap.containsKey(number) ? numberMap.get(number).first() : -1;
        }
    }
}
