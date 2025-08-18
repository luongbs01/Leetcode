import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/24-game/description/
 */

public class _24Game {
    private boolean ans = false;
    private List<Character> operator = List.of('+', '-', '*', '/');
    private List<List<Character>> operators = new ArrayList<>(64);
    private int[] cards;
    private boolean[] marked = new boolean[4];

    public boolean judgePoint24(int[] cards) {
        this.cards = cards;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    operators.add(List.of(operator.get(i), operator.get(j), operator.get(k)));
                }
            }
        }
        backtrack(0, new int[4]);
        return ans;
    }

    private void backtrack(int index, int[] permutation) {
        if (!ans && index == 4) {
            for (int i = 0; i < 64; i++) {
                List<Character> list = operators.get(i);
                if (Math.abs(calc(calc(permutation[0], permutation[1], list.get(0)), calc(permutation[2], permutation[3], list.get(2)), list.get(1)) - 24)
                        < 0.001
                        || Math.abs(calc(calc(calc(permutation[0], permutation[1], list.get(0)), permutation[2], list.get(1)), permutation[3], list.get(1)) - 24)
                        < 0.001
                        || Math.abs(calc(calc(permutation[0], calc(permutation[1], permutation[2], list.get(1)), list.get(0)), permutation[3], list.get(2)) - 24)
                        < 0.001
                        || Math.abs(calc(permutation[0], calc(permutation[1], calc(permutation[2], permutation[3], list.get(2)), list.get(1)), list.get(0)) - 24)
                        < 0.001) {
                    ans = true;
                    return;
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (!marked[i]) {
                    permutation[index] = cards[i];
                    marked[i] = true;
                    backtrack(index + 1, permutation);
                    marked[i] = false;
                }
            }
        }
    }

    private double calc(double a, double b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
    }
}
