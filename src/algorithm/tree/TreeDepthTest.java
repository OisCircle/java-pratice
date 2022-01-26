package algorithm.tree;

/**
 * <p>
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/20
 */
public class TreeDepthTest {
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
		System.out.println(treeDepth(t2));
		System.out.println(treeDepth(t5));
	}

	static int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
	}
}
