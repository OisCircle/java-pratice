package algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

	public static void main(String[] args) {
		System.out.println(countPrimes(2));
		System.out.println(countPrimes(10));

	}

	static int countPrimes(int n) {
		if (n <= 2) {
			return 0;
		}
		boolean[] b = new boolean[n];
		for (int i = 0; i < b.length; ++i) {
			b[i] = true;
		}
		int count = 0;
		for (int i = 2; i < n; ++i) {
			if (b[i]) {
				count++;
				for (int j = 2; j * i < n; ++j) {
					b[j * i] = false;
				}
			}
		}
		return count;
	}

	//未完成
	@Deprecated
	static int myAtoi(String str) {
		int index = firstNotEmpty(str);
		//判断只有+-号的情况，和找不到的情况
		if (index == -1 || (index == str.length() - 1 && !Character.isDigit(str.charAt(index)))) {
			return 0;
		}
		char first = str.charAt(index);
		if (!Character.isDigit(first) && first != '-' && first != '+') {
			return 0;
		}
		//如果有多个符号，要考虑进去
		while (index < str.length() - 1 && (str.charAt(index + 1) == '+' || str.charAt(index + 1) == '-')) {
			index++;
		}

		int start = index, end = Character.isDigit(str.charAt(index)) ? index : index + 1;
		while (end < str.length() && Character.isDigit(str.charAt(end))) {
			end++;
		}
		int result;
		String numberStr = str.substring(start, end);
		try {
			result = Integer.valueOf(numberStr);
		} catch (NumberFormatException e) {
			result = numberStr.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		return result;
	}

	static int firstNotEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return -1;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				return i;
			}
		}
		return -1;
	}

	public static int strStr(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			for (int j = 0; j < needle.length(); j++) {
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}
				if (j == needle.length() - 1) {
					return i;
				}
			}
		}
		return -1;
	}

	static String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		int count = 1;
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		q1.offer(1);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			while (!q1.isEmpty()) {
				offerNumber(q1, q2);
			}
			count++;
			if (count == n) {
				break;
			}
			while (!q2.isEmpty()) {
				offerNumber(q2, q1);
			}
			count++;
			if (count == n) {
				break;
			}
		}
		Queue<Integer> q = q1.isEmpty() ? q2 : q1;
		StringBuilder sb = new StringBuilder(q.size());
		for (int num : q) {
			sb.append(num);
		}
		return sb.toString();
	}

	static void offerNumber(Queue<Integer> one, Queue<Integer> other) {
		while (!one.isEmpty()) {
			int num = one.poll();
			int count = 1;
			while (!one.isEmpty() && one.peek() == num) {
				count++;
				one.poll();
			}
			if (count != 1) {
				other.offer(count);
				other.offer(num);
			} else {
				other.offer(1);
				other.offer(num);
			}
		}
	}

	static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length < 1) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		if (strs[0].isEmpty()) {
			return "";
		}
		int shortestIndex = 0;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < strs[shortestIndex].length()) {
				shortestIndex = i;
			}
		}
		String shortest = strs[shortestIndex];
		StringBuilder sb = new StringBuilder(shortest.length());
		for (int i = 0; i < shortest.length(); i++) {
			char c = shortest.charAt(i);
			if (sameChar(strs, i, c)) {
				sb.append(c);
			} else {
				return sb.toString();
			}
		}
		return sb.toString();
	}

	static boolean sameChar(String[] strs, int index, char c) {
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].charAt(index) != c) {
				return false;
			}
		}
		return true;
	}

	private static void print(int[] nums) {
		Arrays.stream(nums).forEach(System.out::print);
		System.out.println();
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i1 = m - 1, i2 = n - 1;
		for (int i = m + n - 1; i >= 0; i++) {
			nums1[i] = nums1[i1] > nums2[i2] ? nums1[i1--] : nums2[i2--];
		}
	}
}