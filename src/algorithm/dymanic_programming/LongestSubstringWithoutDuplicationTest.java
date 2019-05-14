package algorithm.dymanic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * <p>
 * 剑指48题：最长不含重复字符的子字符串
 * 解法1：枚举所有子字符串，再挑选出最长不重复的字符串长度
 * 解法2：动态规划，要点：d（i和i上次出现的距离）<=f(i-1)?f(i)=d:f(i)=f(i-1)+1 else f(i)=f(i-1)+1
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/25
 */
public class LongestSubstringWithoutDuplicationTest {
	public static void main(String[] args) {
		char[] arr = new char[]{'a', 'r', 'a', 'b', 'c', 'a', 'c', 'f', 'r', 's', 's', 'f', 'f'};
		System.out.println(violent(arr));
		System.out.println(longestSubstringWithoutDuplicationDP(arr));
		System.out.println(longestSubstringWithoutDuplicationDP0(String.valueOf(arr)));
	}


	/**
	 * 动态规划，要点：d（i和i上次出现的距离）<=f(i-1)?f(i)=d:f(i)=f(i-1)+1
	 */
	static int longestSubstringWithoutDuplicationDP(char[] arr) {
		int len;
		if (arr == null || (len = arr.length) < 1) {
			return 0;
		}
		//记录字母以及上次出现的下标
		HashMap<Character, Integer> map = new HashMap<>(len);
		int[] records = new int[len];
		int d, max = 1;
		map.put(arr[0], 0);
		records[0] = 1;
		//1开始
		for (int i = 1; i < len; i++) {
			if (map.get(arr[i]) != null) {
				int lastIndex = map.get(arr[i]);
				d = i - lastIndex;
				//这一段赋值语句很重要
				if (d <= records[i - 1]) {
					//如果小于等于，说明d内是没有重复的arr【i】在里面的，超过d则有重复的arr【i】了，所以records【i】要从d开始计算
					records[i] = d;
				} else {
					//如果大于，说明records【i-1】内没有重复的arr【i】，因此直接records[i - 1] + 1就可以了
					records[i] = records[i - 1] + 1;
				}
			} else {
				records[i] = records[i - 1] + 1;
			}
			//刷新map
			map.put(arr[i], i);
			//同时记录最大值
			max = Math.max(max, records[i]);
		}
		return max;
	}

	/**
	 * 暴力解法
	 */
	static int violent(char[] arr) {
		if (arr == null || arr.length < 1) {
			return 0;
		}
		int max = 0, len = arr.length;
		char[] current;
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < len; i++) {
			set.clear();
			for (int j = i; j + i <= len; j++) {
				//每个子字符串进行查重
				current = Arrays.copyOfRange(arr, i, i + j);
				for (int k = 0; k < current.length; k++) {
					set.add(current[k]);
				}
				if (set.size() == current.length && current.length > max) {
					max = current.length;
				}
			}
		}
		return max;
	}

	static int longestSubstringWithoutDuplicationDP0(String s) {
		int len = s.length();
		if (s == null || len < 1) {
			return 0;
		}
		int max = 1, d;
		int lastAppearIndex;
		int[] records = new int[len];
		HashMap<Character, Integer> map = new HashMap<>(len);
		records[0] = 1;
		map.put(s.charAt(0), 0);
		for (int i = 1; i < len; i++) {
			char ch = s.charAt(i);
			if (map.get(ch) != null) {
				lastAppearIndex = map.get(ch);
				d = i - lastAppearIndex;
				if (d <= records[i - 1]) {
					records[i] = d;
				} else {
					records[i] = records[i - 1] + 1;
				}
			} else {
				records[i] = records[i - 1] + 1;
			}
			map.put(ch, i);
			if (records[i] > max) {
				max = records[i];
			}
		}
		return max;
	}
}
