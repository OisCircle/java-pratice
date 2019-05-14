package algorithm.array;

import java.util.ArrayList;

/**
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/19
 */
public class PermutationTest {
	public static void main(String[] args) {
		System.out.println(permutation("abc"));
	}

	/**
	 * 涉及回溯法,暂时不会
	 */
	static ArrayList<String> permutation(String str) {
		ArrayList<String> list = new ArrayList<>();
		int len = str.length();


		return list;
	}

}
