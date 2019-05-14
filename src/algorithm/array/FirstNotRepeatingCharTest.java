package algorithm.array;

import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * <p>
 * 剑指50题：第一个只出现一次的字符
 * 解法1：遍历每个字符，与后面字符都作比较，O(n^2)时间复杂度
 * 解法2：采用hashmap，第一次遍历统计每个字符出现的次数，第二次遍历获取第一个出现次数为1的字符
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/26
 */
public class FirstNotRepeatingCharTest {
	public static void main(String[] args) throws Exception{
		char[] arr = new char[]{'a', 'b', 'a', 'c', 'c', 'd', 'e', 'f', 'f'};
		char[] arr2 = new char[]{'a', 'a', 'a', 'c', 'c', 'd', 'd', 'f', 'f'};
		System.out.println(firstNotRepeating(arr));
		System.out.println(firstNotRepeating(arr2));
	}

	static char firstNotRepeating(char[] arr) throws Exception {
		if (arr != null) {
			//记录每个字符出现的次数
			int len = arr.length;
			HashMap<Character, Integer> map = new HashMap<>(len);
			for (int i = 0; i < len; i++) {
				Integer count = map.get(arr[i]);
				map.put(arr[i], count == null ? 1 : ++count);
			}
			for (int i = 0; i < len; i++) {
				Integer count = map.get(arr[i]);
				if (count == 1) {
					return arr[i];
				}
			}
		}
		throw new Exception("not exists");
	}
}
