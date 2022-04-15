package algorithm.tree;

/**
 * <p>
 *
 * </p>
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

	}

	static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	static boolean isSymmetric(TreeNode left, TreeNode right) {
		//为空，递归结束条件
		if (left == null && right == null) {
			return true;
		}
		//其中一个非空，说明不对称，递归结束
		if (left == null || right == null) {
			return false;
		}
		//值不一样，递归结束
		if (left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}
