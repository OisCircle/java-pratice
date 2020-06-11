package algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * @author O
 * @since 2020/3/22
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(((int) '('));
        System.out.println(((int) ')'));
        System.out.println(((int) '['));
        System.out.println(((int) ']'));
        System.out.println(((int) '{'));
        System.out.println(((int) '}'));

        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(!isValid("(]"));
        System.out.println(!isValid("([)]"));
        System.out.println(isValid("{[]}"));

    }

    public static boolean isValid(String s) {
        final char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chs[0]);
        for (int i = 1; i < chs.length; i++) {
            char c = chs[i];
            if (!stack.isEmpty() && match(c, stack.peek())) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static boolean match(char a, char b) {
        if (a == ')') {
            return b == '(';
        }
        if (a == ']') {
            return b == '[';
        }
        if (a == '}') {
            return b == '{';
        }
        return false;
    }
}
