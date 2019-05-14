package algorithm.tree;

/**
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/20
 */
public class IsBalancedTest {
	public static void main(String[] args) {

	}

	/**
	 * 解法1:一遍获取深度,一遍判断,treeDepth()函数会造成重复计算
	 */
	static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1) {
			return isBalanced(root.left) && isBalanced(root.right);
		}
		return false;
	}

	private static int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(treeDepth(root.left) + 1, treeDepth(root.right) + 1);
	}

	/**
	 * 解法2:自下而上计算(后序遍历),当发现当前节点不平衡的时候,直接返回深度
	 */
	static boolean isBalanced0(TreeNode root) {
		return getDepth(root) != -1;
	}

	private static int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getDepth(root.left);
		if (left == -1) {
			return -1;
		}
		int right = getDepth(root.right);
		if (right == -1) {
			return -1;
		}
		return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
	}
}
