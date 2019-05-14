package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/3
 */
public class RestoreIPAddress {
	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));
		System.out.println("----");
		System.out.println(restoreIpAddresses("3762854"));
		System.out.println("----");
		System.out.println(restoreIpAddresses("010010"));
	}

	/**
	 * 思路：IP地址每个段都有规律，0~255，三位数字最多
	 * a)第一层循环进行三次，判断数字可行（check）则基于该数字再继续判断下一个段
	 * b)第二层循环也进行三次,最多,判断是否能组成一个段,可以则再进入下一个循环
	 * c)第三层循环判断剩下两个段是否能搭配成两个段,可以则result添加一个结果
	 * d)注意多个0的段是不存在的
	 */
	static List<String> restoreIpAddresses(String s) {
		if (s == null) {
			return null;
		}
		int len = s.length();
		if (len < 4 || len > 12) {
			return Collections.emptyList();
		}
		String strA, strB, strC, strD;
		List<String> res = new ArrayList<>(2 * len);
		for (int i = 0; i < 3; i++) {
			strA = s.substring(0, i + 1);
			if (!check(strA)) {
				continue;
			}
			for (int j = i + 1; j <= i + 3 && j < len; j++) {
				strB = s.substring(i + 1, j + 1);
				if (!check(strB)) {
					continue;
				}
				for (int k = j + 1; k <= j + 3 && k + 1 < len; k++) {
					strC = s.substring(j + 1, k + 1);
					strD = s.substring(k + 1, len);
					if (check(strC) && check(strD)) {
						res.add(strA + '.' + strB + '.' + strC + '.' + strD);
					}
				}
			}
		}
		return res;
	}

	static boolean check(String str) {
		if (str.startsWith("0") && str.length() == 1 || !str.startsWith("0")) {
			int num = Integer.valueOf(str);
			return num >= 0 && num < 256;
		}
		return false;
	}

}