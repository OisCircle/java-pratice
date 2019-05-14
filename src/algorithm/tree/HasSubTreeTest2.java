package algorithm.tree;

/**
 * <p>
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/15
 */
public class HasSubTreeTest2 {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(8);
		TreeNode t2 = new TreeNode(8);
		TreeNode t3 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		TreeNode t4 = new TreeNode(9);
		TreeNode t5 = new TreeNode(2);
		t2.left = t4;
		t2.right = t5;
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		t5.left = t6;
		t5.right = t7;

		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(2);
		t8.left = t9;
		t8.right = t10;
		System.out.println(hasSubTree(t1, t8));
		System.out.println(compareTree(t2, t8));
	}

	private static boolean hasSubTree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		//如果值相等则递归对比
		if (root1.val == root2.val) {
			//一样则返回true
			if (compareTree(root1, root2)) {
				return true;
			}
		}
		//否则继续左子树右子树对比
		if (root1.left != null && root1.right != null) {
			return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
		} else if (root1.left != null) {
			return hasSubTree(root1.left, root2);
		} else if (root1.right != null) {
			return hasSubTree(root1.right, root2);
		}else{
			return false;
		}
	}

	private static boolean compareTree(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true;
		} else if (r2 == null) {
			return true;
		} else if (r1 != null) {
			if (r1.val == r2.val) {
				return compareTree(r1.left, r2.left) && compareTree(r1.right, r2.right);
			}
		}
		return false;
	}
}
