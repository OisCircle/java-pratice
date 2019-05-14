package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/20
 */
public class FirstNotRepeatingCharTest2 {
	public static void main(String[] args) {
		System.out.println(firstNotRepeatingChar("abcdabcdeabcdffgh"));
		System.out.println(firstNotRepeatingChar("abcd"));
		System.out.println(firstNotRepeatingChar("aabbcc"));
	}

	/**
	 * 思路:
	 * 1)hashmap记录次数
	 * 2)遍历
	 */
	static int firstNotRepeatingChar(String str) {
		char[] chs = str.toCharArray();
		int len = chs.length;
		Map<Character, Integer> map = new HashMap<>(len);
		for (int i = 0; i < len; i++) {
			map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);
		}
		for (int i = 0; i < len; i++) {
			if (map.getOrDefault(chs[i], 0) == 1) {
				return i;
			}
		}
		return -1;
	}
}
