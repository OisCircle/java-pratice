package algorithm.array.palindrome;

/**
 * <p>
 * 京京和东东是好朋友。东东很喜欢回文。回文是指从前往后读和从后往前读是一样的词语。京京准备给东东一个惊喜,
 * 先取定一个字符串s,然后在后面附上0个或者更多个字母形成回文,京京希望这个回文越短越好。请帮助京京计算他
 * 能够得到的最短的回文长度。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/12
 */
public class PalindromeAttach {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		while (sc.hasNext()) {
//			String s = sc.nextLine();
//			print(s);
//		}
		print("aba");
		print("a");
		print("abab");
		print("abcdea");
	}

	/**
	 * 思路:获取一个反转字符串,从左到右与原字符串逐个对比
	 *
	 * 		abab
	 * 		 baba
	 *
	 * 		 上面那种情况就是最短长度，可以看到中间的一定是每个都相等的，下面的反转字符串挨个移动即可
	 */
	static void print(String s) {
		if (s == null || s.length() < 1) {
			return;
		}
		int len = s.length();
		String reverse = "";
		for (int i = len - 1; i >= 0; i--) {
			reverse += s.charAt(i);
		}
		for (int i = 0; i < len; i++) {
			for (int rIndex = 0, sIndex = i; sIndex < len; sIndex++, rIndex++) {
				if (s.charAt(sIndex) != reverse.charAt(rIndex)) {
					break;
				} else if (sIndex == len - 1) {
					//对比到最后一个了，说明前面的都相等，是最短回文串
					System.out.println(len + (len - rIndex - 1));
					return;
				}
			}
		}
		System.out.println(len * 2);
	}
}
