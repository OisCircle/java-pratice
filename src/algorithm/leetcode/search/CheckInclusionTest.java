package algorithm.leetcode.search;

import java.util.HashMap;

/**
 * <p>
 * algorithm.leetcode:字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/2
 */
public class CheckInclusionTest {
	public static void main(String[] args) {
		System.out.println(checkInclusion0("abc", "eiddacbcaoo"));
		System.out.println(checkInclusion0("ooa", "eiddacbcaoo"));
		System.out.println(checkInclusion0("abcde", "eiddacbcaoo"));
	}

	/**
	 * 解法2：不使用hashmap，使用“滑动窗口”，用类似bitmap的做法来记录26个字母的次数
	 */
	static boolean checkInclusion0(String s1, String s2) {
		if (s1 == null || s1.length() < 1 || s2 == null || s2.length() < 1 || s1.length() > s2.length()) {
			return false;
		}
		int len1 = s1.length();
		int len2 = s2.length();
		int[] chCount = new int[26];
		int[] check;
		//初始化
		for (int i = 0; i < len1; i++) {
			chCount[s1.charAt(i) - 'a']++;
		}
		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			//构造比较的数组
			check = new int[26];
			for (int j = i; j < i + len1; j++) {
				check[s2.charAt(j) - 'a']++;
			}
			//比较出现的次数
			for (int j = 0; j < 26; j++) {
				if (chCount[j] != check[j]) {
					break;
				}
				if (j == 25) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 解法1：使用hashmap，超出时间限制了
	 */
	static boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s1.length() < 1 || s2 == null || s2.length() < 1 || s1.length() > s2.length()) {
			return false;
		}
		//记录每个char出现的次数
		HashMap<Character, Integer> map = new HashMap<>(s1.length());
		buildMap(s1, map);
		for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
			if (map.get(s2.charAt(i)) != null) {
				for (int j = i; j < i + s1.length(); j++) {
					//map中存在char则-1，减到0则删除元素，不存在char则break，然后rebuild
					Integer count = map.get(s2.charAt(j));
					if (count != null && count >= 1) {
						count -= 1;
						if (count == 0) {
							map.remove(s2.charAt(j));
						} else {
							map.put(s2.charAt(j), count);
						}
					} else {
						buildMap(s1, map);
						break;
					}
					if (map.size() == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static void buildMap(String s1, HashMap<Character, Integer> map) {
		map.clear();
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if (map.get(ch) != null) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
	}
}
