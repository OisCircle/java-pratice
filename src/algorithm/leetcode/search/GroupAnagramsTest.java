package algorithm.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/8
 */
public class GroupAnagramsTest {
	public static void main(String[] args) {
		String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(s));
		System.out.println(groupAnagramsHashMap(s));
	}

	/**
	 * 解法1:从左往右遍历两层,添加过的要标记.时间复杂度接近O(n^3),空间复杂度O(n)
	 * 超时!!!
	 */
	static List<List<String>> groupAnagrams(String[] strs) {
		int len = strs.length;
		List<List<String>> res = new ArrayList<>();
		boolean[] visited = new boolean[len];
		for (int i = 0; i < len; i++) {
			if (visited[i]) {
				continue;
			}
			List<String> list = new ArrayList<>();
			visited[i] = true;
			list.add(strs[i]);
			for (int j = i + 1; j < len; j++) {
				if (visited[j]) {
					continue;
				}
				if (isAnagrams(strs[i], strs[j])) {
					visited[j] = true;
					list.add(strs[j]);
				}
			}
			res.add(list);
		}
		return res;
	}

	/**
	 * bitmap来去重,利用小写字母范围的特性,否则要用hashmap去重
	 */
	static boolean isAnagrams(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		char[] chs1 = a.toCharArray();
		char[] chs2 = b.toCharArray();
		int[] dict = new int[26];
		for (int i = 0; i < chs1.length; i++) {
			dict[chs1[i] - 'a'] += 1;
			dict[chs2[i] - 'a'] -= 1;
		}
		for (int i = 0; i < 26; i++) {
			if (dict[i] != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 解法2:使用hashmap,注意每个字母异位词排序后都是一样的结果,可以利用这个特性,将排序后的字符串作为key,原字符串作为list中的内容
	 * 时间复杂度:排序O(mlogm),遍历一次记录hashmap,O(n),遍历keysetO(k),总时间复杂度O(nmklogm),空间复杂度O(k)
	 */
	static List<List<String>> groupAnagramsHashMap(String[] strs) {
		int len = strs.length;
		List<List<String>> res = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>(len / 2);
		for (int i = 0; i < len; i++) {
			char[] chs = strs[i].toCharArray();
			Arrays.sort(chs);
			String str = Arrays.toString(chs);
			if (map.containsKey(str)) {
				map.get(str).add(strs[i]);
			} else {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				map.put(str, list);
			}
		}
		for (String key : map.keySet()) {
			res.add(map.get(key));
		}
		return res;
	}
}
