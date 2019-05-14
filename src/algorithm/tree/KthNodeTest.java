package algorithm.tree;

/**
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/20
 */
public class KthNodeTest {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(8);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		KthNodeTest test = new KthNodeTest();
		test.KthNode(n1, 3);
		System.out.println(test.node.val);
	}

	/**
	 * 注意这里不能用static修饰,否则cur会有问题
	 */
	int cur = 0;
	/**
	 * 使用全局遍历,比较好理解
	 */
	TreeNode node;

	/**
	 * 思路:中序遍历中的第k个就是我们要的结果,这里要注意两个判断非空的语句,通过这种方式来判断函数需不需要再递归下去
	 */
	void KthNode(TreeNode pRoot, int k) {
		if (k < 1) {
			return;
		}
		if (pRoot == null) {
			return;
		}
		//cur<k判断是为了避免全部遍历
		if (cur < k) {
			KthNode(pRoot.left, k);
		}
		//到达k则赋值
		if (++cur == k) {
			node = pRoot;
		}
		if (cur < k) {
			KthNode(pRoot.right, k);
		}
	}
}
