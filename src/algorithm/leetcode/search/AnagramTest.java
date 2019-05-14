package algorithm.leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/7
 */
public class AnagramTest {
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
		System.out.println(isAnagramBitmap(s, t));
	}

	/**
	 * 解法1：hashmap记录字母出现的次数，然后再去除重复，时间复杂度O(n),空间复杂度O(n)
	 */
	static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int len = s.length();
		Map<Character, Integer> map = new HashMap<>(len);
		for (int i = 0; i < len; i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		int count;
		for (int i = 0; i < len; i++) {
			if (map.containsKey(t.charAt(i))) {
				count = map.get(t.charAt(i));
				if (count > 1) {
					map.put(t.charAt(i), count - 1);
				} else {
					map.remove(t.charAt(i));
				}
			}
		}
		return map.isEmpty();
	}

	/**
	 * 解法2:利用只有小写字母的性质,使用bitmap记录字母出现的下标
	 * 时间复杂度O(n),空间复杂度O(1)
	 * 最优解
	 */
	static boolean isAnagramBitmap(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int len = s.length();
		int[] chars = new int[26];
		for (int i = 0; i < len; i++) {
			chars[s.charAt(i) - 'a'] += 1;
			chars[t.charAt(i) - 'a'] -= 1;
		}
		for (int i = 0; i < 26; i++) {
			if (chars[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
