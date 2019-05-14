package algorithm.tree;


/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/3
 */
public class HasSubTreeTest {
	public static void main(String[] args) {
		BTree t1 = new BTree(8);
		BTree t2 = new BTree(8);
		BTree t3 = new BTree(7);
		t1.left = t2;
		t1.right = t3;
		BTree t4 = new BTree(9);
		BTree t5 = new BTree(2);
		t2.left = t4;
		t2.right = t5;
		BTree t6 = new BTree(4);
		BTree t7 = new BTree(7);
		t5.left = t6;
		t5.right = t7;

		BTree t8 = new BTree(8);
		BTree t9 = new BTree(9);
		BTree t10 = new BTree(2);
		t8.left = t9;
		t8.right = t10;
		System.out.println(hasSubTree(t1, t8));

		BTree t11 = new BTree(1);
		BTree t12 = new BTree(2);
		t9.left = t11;
		t9.right = t12;

		BTree t13 = new BTree(1);
		BTree t14 = new BTree(2);
		t4.left = t13;
		t4.right = t14;
		BTree t15 = new BTree(8);
		BTree t16 = new BTree(8);
		BTree t17 = new BTree(8);
		BTree t18 = new BTree(8);
		BTree t19 = new BTree(8);
		BTree t20 = new BTree(8);

		System.out.println(hasSubTree(t1, t8));

		System.out.println(hasSubTree(null, null));
		System.out.println(hasSubTree(t1, null));
		System.out.println(hasSubTree(null, t8));
	}

	static boolean hasSubTree(BTree main, BTree sub) {
		boolean result = false;
		if (main == null) {
			return false;
		}
		if (sub == null) {
			return false;
		}
		if (main.val == sub.val) {
			result = compareRecursively(main, sub);
		}
		if (!result) {
			result = hasSubTree(main.left, sub);
		}
		if (!result) {
			result = hasSubTree(main.right, sub);
		}

		return result;
	}

	static boolean compareRecursively(BTree main, BTree sub) {
		//这个判断要放在上面
		if (sub == null) {
			return true;
		}
		//这个判断要放在下面
		if (main == null) {
			return false;
		}
		if (main.val != sub.val) {
			return false;
		}
		return compareRecursively(main.left, sub.left) && compareRecursively(main.right, sub.right);
	}
}

