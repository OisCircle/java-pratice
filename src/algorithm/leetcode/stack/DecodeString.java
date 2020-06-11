package algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author O
 * @since 2020/3/24
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("10[a]"));
    }

    public static String decodeString(String s) {
        if (s.isEmpty()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        final char[] chs = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char c : chs) {
            if (c == ']') {
                char cur;
                StringBuilder encode = new StringBuilder();
                StringBuilder mid = new StringBuilder();
                StringBuilder digit = new StringBuilder();
                while ((cur = stack.pop()) != '[') {
                    encode.append(cur);
                }
                int time;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    digit.append(stack.pop());
                }
                time = Integer.valueOf(digit.reverse().toString());
                while (time-- > 0) {
                    mid.append(encode.toString());
                }
                for (char ch : mid.reverse().toString().toCharArray()) {
                    stack.push(ch);
                }
            } else {
                stack.push(c);
            }
        }
        for (char ch : stack) {
            res.append(ch);
        }
        return res.toString();
    }
}
