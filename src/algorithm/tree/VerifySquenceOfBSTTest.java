package algorithm.tree;

/**
 * <p>
 * 验证是否是后序遍历的二叉搜索树
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/16
 */
public class VerifySquenceOfBSTTest {
	public static void main(String[] args) {
		System.out.println(verifySquenceOfBST(new int[]{3, 5, 4, 7, 9, 8, 6}));
		System.out.println(verifySquenceOfBST(new int[]{3, 4, 5}));
	}

	/**
	 * 思路:递归回合{最右边是root,先从左到右找第一个大于等于root的下标i,再验证i到root是否都大于root,是则进入下一个递归回合,否则返回false}
	 */
	static boolean verifySquenceOfBST(int[] sequence) {
		int len = sequence.length;
		if (len < 1) {
			return false;
		}
		return judge(sequence, 0, len - 1);
	}

	private static boolean judge(int[] seq, int left, int right) {
		if (left >= right) {
			return true;
		}
		int i = 0;
		//i代表从左到右第一个大于等于root的下标
		while (i < right && seq[i] < seq[right]) {
			i++;
		}
		for (int j = i + 1; j < right; j++) {
			if (seq[j] < seq[right]) {
				return false;
			}
		}
		return judge(seq, left, i - 1) && judge(seq, i, right - 1);
	}

}
