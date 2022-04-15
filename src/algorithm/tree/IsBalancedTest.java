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

	private static boolean IS_BALANCED = true;

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(12);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;

		System.out.println(treeDepth(t1));
		System.out.println(isBalanced(t1));
		System.out.println(isBalanced(t2));
		System.out.println(isBalanced2(t1));
		System.out.println(isBalanced2(t2));
		System.out.println(isBalanced1(t1));
		System.out.println(isBalanced1(t2));
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

	static boolean isBalanced2(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1) {
			return false;
		}
		return isBalanced2(root.left) && isBalanced2(root.right);
	}

	private static int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
	}

	private static int treeDepthEasy(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int curDepth = 1;
		return Math.max(treeDepthEasy(root.left), treeDepthEasy(root.right)) + curDepth;
	}

	/**
	 * 解法2:自下而上计算(后序遍历),当发现当前节点不平衡的时候,直接返回深度
	 * <p>
	 * 这个实现没看懂，太乱，下面的isBalanced1比较好理解
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

	static boolean isBalanced1(TreeNode cur) {
		IS_BALANCED = true;
		getDepth1(cur);
		return IS_BALANCED;
	}

	/**
	 * 方法定义：获取这个节点的深度
	 */
	static int getDepth1(TreeNode cur) {
		if (cur == null) {
			return 0;
		}
		int leftDepth = getDepth1(cur.left);
		int rightDepth = getDepth1(cur.right);
		//如果深度差超过1，则说明这个节点下的子树不平衡
		if (Math.abs(leftDepth - rightDepth) > 1) {
			IS_BALANCED = false;
		}
		//返回当前节点长度最大的子树，再加上当前节点占用一个长度
		return Math.max(leftDepth, rightDepth) + 1;
	}
}
