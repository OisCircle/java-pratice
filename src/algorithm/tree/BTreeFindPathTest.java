package algorithm.tree;

import java.util.Vector;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/5
 */
public class BTreeFindPathTest {
	public static void main(String[] args) {
		BTree root = new BTree(1);
		int expectedNum = 20;
		//... create trees
		findPath(root, expectedNum);


	}

	static void findPath(BTree root, int expectedNum) {
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		int currentNum = 0;
		Vector<BTree> path = new Vector<>();
		path.add(root);
		findPathCore(root, expectedNum, currentNum, path);
	}

	static void findPathCore(BTree node, int expectedNum, int currentNum, Vector<BTree> path) {
		currentNum += node.val;
		path.add(node);
		boolean isLeaf = node.left == null && node.right == null;
		if (isLeaf && currentNum == expectedNum) {
			printPath(path);
		}
		if (node.left != null) {
			findPathCore(node.left, expectedNum, currentNum, path);
		}
		if (node.right != null) {
			findPathCore(node.right, expectedNum, currentNum, path);
		}
		//返回父节点之前要删除该节点并减去当前节点的值（在这里不用手动减currentNum的值，因为回到父节点的值就是没有加过的）
		path.remove(node);
	}


	static void printPath(Vector<BTree> path) {

	}


}
