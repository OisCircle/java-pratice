package algorithm.leetcode.array;

/**
 * 剑指Offer专项突破版 第14题 字符串中的变位词
 * <p>
 * 变位词意思是单词中的字母出现次数一样，只不过是字母排序不一样，例如 abc cba acb
 * <p>
 * 输入s1，s2，判断s2中是否包含s1的某个变位词
 * <p>
 * eg：s1='ac' s2='dgcaf' 'ca'就是'ac'的变位词
 * <p>
 * 思路1 O（m+n）：先使用字符hash表记录s1中每个字符出现的次数，再遍历s2，如果s1，s2都有字符，则s1的字符map+1，s2的字符map-1，直到s1没有了，
 * <p>
 * 判断一次是否全0，之后，从s2继续遍历，s2的字符map+1，s2-s1.length下标的字符map-1，每一次循环都判断一次全0
 * <p>
 * 思路比较奇怪，目前找不到规律
 *
 * @author qiuchengquan
 * @since 2021/11/7
 */
public class CheckInclusionTest {

	public static void main(String[] args) {
		System.out.println(checkInclusion("ac", "dgcaf"));
	}

	public static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}
		int[] map = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			map[s1.charAt(i) - 'a']++;
			map[s2.charAt(i) - 'a']--;
		}
		if (checkAllZero(map)) {
			return true;
		}
		for (int i = s1.length(); i < s2.length(); i++) {
			map[s2.charAt(i - s1.length()) - 'a']++;
			map[s2.charAt(i) - 'a']--;
			if (checkAllZero(map)) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkAllZero(int[] map) {
		for (int count : map) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}
}
