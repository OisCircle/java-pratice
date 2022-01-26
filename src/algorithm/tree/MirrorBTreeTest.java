package algorithm.tree;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/4
 */
public class MirrorBTreeTest {
	public static void main(String[] args) {
		BTree t1 = new BTree(8);
		BTree t2 = new BTree(6);
		BTree t3 = new BTree(10);
		t1.left = t2;
		t1.right = t3;
		BTree t4 = new BTree(5);
		BTree t5 = new BTree(7);
		t2.left = t4;
		t2.right = t5;
		BTree t6 = new BTree(9);
		BTree t7 = new BTree(11);
		t3.left = t6;
		t3.right = t7;

		mirrorlize2(t1);
	}

	static void mirrorlize(BTree tree) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null) {
			return;
		}
		System.out.println("swap : " + tree.left.val + " and " + tree.right.val);
		BTree temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		if (tree.left != null) {
			mirrorlize(tree.left);
		}
		if (tree.right != null) {
			mirrorlize(tree.right);
		}
	}

	static void mirrorlize2(BTree cur) {
		if (cur == null) {
			return;
		}
		swap(cur);
		mirrorlize2(cur.left);
		mirrorlize2(cur.right);
	}

	private static void swap(BTree cur) {
		if (cur == null) {
			return;
		}
		if (cur.left == null && cur.right == null) {
			return;
		}
		System.out.println(String.format("before: node %s left %s right %s", cur.val, cur.left == null ? "null" : cur.left.val, cur.right == null ? "null" : cur.right.val));
		BTree t = cur.left;
		cur.left = cur.right;
		cur.right = t;
		System.out.println(String.format("after: node %s left %s right %s", cur.val, cur.left == null ? "null" : cur.left.val, cur.right == null ? "null" : cur.right.val));
	}
}
