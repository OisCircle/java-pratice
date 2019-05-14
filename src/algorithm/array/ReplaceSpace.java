package algorithm.array;

/**
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/12
 */
public class ReplaceSpace {
	public static void main(String[] args) {
		System.out.println(replaceSpace(new StringBuffer("a b c")));
		System.out.println(replaceSpace(new StringBuffer("    a")));
		System.out.println(replaceSpace(new StringBuffer("a    ")));
		System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
	}

	static String replaceSpace(StringBuffer str) {
		char[] s = str.toString().toCharArray();
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			if (s[i] == ' ') {
				res += "%20";
			} else {
				res += s[i];
			}
		}
		return res;
	}
}
