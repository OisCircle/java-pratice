package algorithm.leetcode.search;

import java.util.*;

/**
 * <p>
 * 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/8
 */
public class FrequencySortTest {
	public static void main(String[] args) {
		String s = "cccaaa";
		String s2 = "Aabb";
		System.out.println(frequencySort(s));
		System.out.println(frequencySort(s2));
		System.out.println(frequencySortDict(s));
		System.out.println(frequencySortDict(s2));
	}

	/**
	 * 解法1:
	 * a)添加到hashmap映射
	 * b)将hashmap根据value进行排序
	 * c)输出
	 */
	static String frequencySort(String s) {
		char[] chs = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>(s.length());
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(chs[i])) {
				map.put(chs[i], map.get(chs[i]) + 1);
			} else {
				map.put(chs[i], 1);
			}
		}
		ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		StringBuilder sb = new StringBuilder(s.length());
		for (Map.Entry<Character, Integer> e : entries) {
			int count = e.getValue();
			while (count > 0) {
				sb.append(e.getKey());
				count--;
			}
		}
		return sb.toString();
	}

	/**
	 * 解法2:
	 * a)添加到hashmap映射
	 * b)创建大小为len的char字典(dict)
	 * c)将map中的每个entry对应的value映射到dict下标,key映射到值,代表字母出现了多少次(下标:值)
	 * d)倒序输出
	 * e)注意!这种方法有一个bug,当aaaccc的时候,a3次,b也3次,导致字典中下标3的位置被覆盖!!!所以不可行
	 */
	static String frequencySortDict(String s) {
		char[] chs = s.toCharArray();
		int len = s.length();
		Map<Character, Integer> map = new HashMap<>(len);
		char[] dict = new char[len];
		for (int i = 0; i < len; i++) {
			if (map.containsKey(chs[i])) {
				map.put(chs[i], map.get(chs[i]) + 1);
			} else {
				map.put(chs[i], 1);
			}
		}
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			dict[e.getValue()] = e.getKey();
		}
		StringBuilder sb = new StringBuilder(len);
		for (int i = len - 1; i >= 0; i--) {
			int count = i;
			while (count > 0) {
				sb.append(dict[i]);
				count--;
			}
		}
		return sb.toString().trim();
	}
}
