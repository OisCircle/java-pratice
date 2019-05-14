package algorithm.leetcode.search;

/**
 * <p>
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "algorithm.leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/10
 */
public class FirstUniqChar {
	/**
	 * 解法1:由于字符串中只包含小写字母,可以使用bitmap记录对应下标的出现次数
	 * a)第一遍遍历dict,记录次数
	 * b)第二遍遍历字符串,获取对应dict中出现一次的,存在则返回下标
	 */
	public int firstUniqChar(String s) {
		char[] dict = new char[26];
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			dict[chs[i] - 'a'] += 1;
		}
		for (int i = 0; i < chs.length; i++) {
			if (dict[chs[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}
