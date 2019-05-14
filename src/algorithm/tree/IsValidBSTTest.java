package algorithm.tree;

/**
 * <p>
 * 未完成
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/17
 */
public class IsValidBSTTest {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode leaf1 = new TreeNode(1);
		TreeNode leaf2 = new TreeNode(4);
		TreeNode leaf3 = new TreeNode(-1);
		TreeNode leaf4 = new TreeNode(2);
		TreeNode leaf5 = new TreeNode(3);
		TreeNode leaf6 = new TreeNode(5);

		root.left = leaf1;
		root.right = leaf2;
		leaf1.left = leaf3;
		leaf1.right = leaf4;
		leaf2.left = leaf5;
		leaf2.right = leaf6;

		System.out.println(isValidBST(root));
	}

	static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return false;
		}


		return isValidBST(root.left) && isValidBST(root.right);
	}

	static boolean isValidBST0(TreeNode root, int topValue) {
		return false;
	}
}
