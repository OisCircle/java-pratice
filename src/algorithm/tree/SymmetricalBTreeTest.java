package algorithm.tree;

/**
 * 是否是对称的树
 */
public class SymmetricalBTreeTest {

	public static void main(String[] args) {
		BTree t1 = new BTree(8);
		BTree t2 = new BTree(6);
		BTree t3 = new BTree(6);
		t1.left = t2;
		t1.right = t3;
		BTree t4 = new BTree(5);
		BTree t5 = new BTree(7);
		t2.left = t4;
		t2.right = t5;
		BTree t6 = new BTree(7);
		BTree t7 = new BTree(5);
		t3.left = t6;
		t3.right = t7;

		System.out.println(isSymmetrical(t1.left, t1.right));
	}

	static boolean isSymmetrical(BTree root1, BTree root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		return isSymmetrical(root1.left, root2.right)
		       && isSymmetrical(root1.right, root2.left);
	}


}




