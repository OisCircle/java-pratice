package algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author O
 * @since 2020/3/23
 */
public class EvalRPN {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}) == 9);
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}) == 6);
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}) == 22);
    }

    public static int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }
        Stack<String> s = new Stack<>();
        s.push(tokens[0]);
        s.push(tokens[1]);
        for (int i = 2; i < tokens.length; i++) {
            final int b, a;
            switch (tokens[i]) {
                case "+":
                    b = Integer.valueOf(s.pop());
                    a = Integer.valueOf(s.pop());
                    s.push(String.valueOf(a + b));
                    break;
                case "-":
                    b = Integer.valueOf(s.pop());
                    a = Integer.valueOf(s.pop());
                    s.push(String.valueOf(a - b));
                    break;
                case "*":
                    b = Integer.valueOf(s.pop());
                    a = Integer.valueOf(s.pop());
                    s.push(String.valueOf(a * b));
                    break;
                case "/":
                    b = Integer.valueOf(s.pop());
                    a = Integer.valueOf(s.pop());
                    s.push(String.valueOf(a / b));
                    break;
                default:
                    s.push(tokens[i]);
                    break;
            }
        }
        return Integer.valueOf(s.pop());
    }
}
