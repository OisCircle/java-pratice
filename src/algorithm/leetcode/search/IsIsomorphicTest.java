package algorithm.leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/7
 */
public class IsIsomorphicTest {
	public static void main(String[] args) {
		String s = "paper", t = "title";
		String s2 = "foo", t2 = "bar";
		String s3 = "ab", t3 = "aa";
		System.out.println(isIsomorphicBitMap(s, t));
		System.out.println(isIsomorphicBitMap(s2, t2));
		System.out.println(isIsomorphicBitMap(s3, t3));
	}

	/**
	 * 解法1:使用两个hashmap,paper={1,2,1,3,4},title={1,2,1,3,4}
	 * 利用上述性质,计算字母在第几个出现,如果出现次序不同则不是同构的
	 */
	static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int len = s.length();
		char[] char1 = s.toCharArray();
		char[] char2 = t.toCharArray();
		Map<Character, Integer> map1 = new HashMap<>(len);
		Map<Character, Integer> map2 = new HashMap<>(len);
		int existCount1 = 1;
		int existCount2 = 1;
		for (int i = 0; i < len; i++) {
			if (!map1.containsKey(char1[i])) {
				map1.put(char1[i], existCount1++);
			}
			if (!map2.containsKey(char2[i])) {
				map2.put(char2[i], existCount2++);
			}
			if (!map1.get(char1[i]).equals(map2.get(char2[i]))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 解法2:使用两个256位的bitmap,因为ascii码有256个
	 */
	static boolean isIsomorphicBitMap(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int len = s.length();
		char[] char1 = s.toCharArray();
		char[] char2 = t.toCharArray();
		int[] map1 = new int[256];
		int[] map2 = new int[256];
		for (int i = 0; i < len; i++) {
			if (map1[char1[i]] != map2[char2[i]]) {
				return false;
			}
			map1[char1[i]] = i + 1;
			map2[char2[i]] = i + 1;
		}
		return true;
	}
}
