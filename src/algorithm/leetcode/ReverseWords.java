package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/3
 */
public class ReverseWords {
	public static void main(String[] args) {
//		System.out.println(reverseWords0("i am qcq"));
//		System.out.println(reverseWords0("!!! is circle!!"));
//		System.out.println(reverseWords0("i"));
//		System.out.println(reverseWords0(""));
		System.out.println(reverseWords0("a good   example"));

	}

	/**
	 * 这是自己分割单词的方法
	 */
	static String reverseWords(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		List<String> wordList = new ArrayList<>();
		int start = 0, end;
		for (int i = 0; i < s.length(); i++) {
			//计算出一个单词的start和end
			if (s.charAt(i) != ' ') {
				start = i;
				end = start + 1;
				while (end < s.length() && s.charAt(end) != ' ') {
					end++;
				}
				//从end开始继续找单词
				i = end;
				wordList.add(s.substring(start, end));
			}
		}
		//倒置
		String result = "";
		for (int i = wordList.size() - 1; i >= 0; i--) {
			result += wordList.get(i);
			if (i > 0) {
				result += " ";
			}
		}
		return result;
	}

	/**
	 * 使用String API分割单词并对调数组
	 */
	static String reverseWords0(String s) {
		String[] words = s.trim().split(" ");
		int len = words.length;
		for (int i = 0; i < len / 2; i++) {
			String temp = words[i];
			words[i] = words[len - i - 1];
			words[len - i - 1] = temp;
		}
		String result = "";
		for (int i = 0; i < len; i++) {
			if (!words[i].isEmpty()) {
				result += words[i];
				if (i < len - 1) {
					result += " ";
				}
			}
		}
		return result;
	}
}
