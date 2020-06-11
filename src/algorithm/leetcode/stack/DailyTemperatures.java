package algorithm.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author O
 * @since 2020/3/22
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temps = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Arrays.stream(dailyTemperatures(temps)).forEach(System.out::print);
    }

    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res=new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
