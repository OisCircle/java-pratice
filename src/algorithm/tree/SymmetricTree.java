package algorithm.tree;

/**
 * 非递归解法，可以考虑回文字符串的判断，广度优先遍历每一层，每一层都是回文字符串就是对称树
 *
 * @author O
 * @version 1.0
 * @since 2019/3/9
 */
public class SymmetricTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode leaf1 = new TreeNode(2);
		TreeNode leaf2 = new TreeNode(2);
		root.left = leaf1;
		root.right = leaf2;
		TreeNode leaf3 = new TreeNode(3);
		TreeNode leaf4 = new TreeNode(4);
		leaf1.left = leaf3;
		leaf1.right = leaf4;
		TreeNode leaf5 = new TreeNode(4);
		TreeNode leaf6 = new TreeNode(3);
		leaf2.left = leaf5;
		leaf2.right = leaf6;

		System.out.println(isSymmetric(root));
		System.out.println(isSymmetric1(root));

	}

	static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	/**
	 * 方法定义：左右两颗树是否是对称的
	 * <p>
	 * 左右值相等，并且a的左子树与b的右子树对称，a的右子树与b左子树对称
	 */
	static boolean isSymmetric(TreeNode left, TreeNode right) {
		//为空，递归结束条件
		if (left == null && right == null) {
			return true;
		}
		//其中一个非空，说明不对称，递归结束
		if (left == null || right == null) {
			return false;
		}
		//对称了，但是值不一样，递归结束
		if (left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}

	static boolean isSymmetric1(TreeNode cur) {
		if (cur == null) {
			return true;
		}
		return isSymmetric1(cur.left, cur.right);
	}

	static boolean isSymmetric1(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		if (a.val != b.val) {
			return false;
		}
		return isSymmetric1(a.left, b.right) && isSymmetric1(a.right, b.left);
	}
}
