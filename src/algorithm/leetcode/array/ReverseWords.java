package algorithm.leetcode.array;

/**
 * @author O
 * @since 2020/3/30
 */
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("abc def"));
        System.out.println(reverseWords("gogo"));
        System.out.println(reverseWords(""));
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        int len = s.length();
        int last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= len; i++) {
            if (i == len || s.charAt(i) == ' ') {
                for (int j = i - 1; j >= last; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
                last = i + 1;
                i++;
            }
        }
        sb.deleteCharAt(len);
        return sb.toString();
    }
}
