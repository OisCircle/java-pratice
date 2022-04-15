package algorithm.tree;

/**
 * <p>
 * 树镜像化，前序遍历，每个节点下的左右子节点都交换即可，如果左右子节点都是null就不要交换了
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


		mirrorlize(t1);
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


}
