package algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 剑指34题
 * 打印出所有从根到节点和为k的节点
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/15
 */
public class FindPathTest {
	public static void main(String[] args) {
//		TreeNode head = new TreeNode(10);
//		TreeNode leaf1 = new TreeNode(5);
//		TreeNode leaf2 = new TreeNode(12);
//		TreeNode leaf3 = new TreeNode(4);
//		TreeNode leaf4 = new TreeNode(7);
//		head.left = leaf1;
//		head.right = leaf2;
//		leaf1.left = leaf3;
//		leaf1.right = leaf4;
//
//		findPath(head, 22);

		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(12);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(10);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t4.left = t6;

		findPath(t1, 22);
	}

	static void findPath(TreeNode head, int value) {
		if (head == null) {
			System.out.println("head is null");
			return;
		}
		findPathCore2(head, value, new ArrayList<>(), 0);
	}

	static void findPathCore(TreeNode node, int value, List<TreeNode> path, int current) {
		current += node.val;
		path.add(node);
		//返回条件1：找到路径
		if (current == value) {
			print(path);
			path.remove(path.size() - 1);
			return;
		}
		//返回条件2：是根节点而且没有找到路径
		if (node.left == null && node.right == null) {
			path.remove(path.size() - 1);
			return;
		}
		//递归左右直接点查找路径
		if (node.left != null) {
			findPathCore(node.left, value, path, current);
		}
		if (node.right != null) {
			findPathCore(node.right, value, path, current);
		}
		//恢复现场
		path.remove(path.size() - 1);
	}

	static void findPathCore2(TreeNode node, int value, List<TreeNode> path, int current) {
		//校验null避免下面递归的时候判断null
		if (node == null) {
			return;
		}
		current += node.val;
		path.add(node);
		if (current == value) {
			print(path);
			path.remove(path.size() - 1);
			return;
		}
		//剪枝逻辑，大于的，就不递归下去了，没必要
		if (current <= value) {
			findPathCore2(node.left, value, path, current);
			findPathCore2(node.right, value, path, current);
		}
		path.remove(path.size() - 1);
	}

	static void print(List<TreeNode> path) {
		System.out.println("find path:");
		path.forEach(node -> System.out.print(node.val + " -> "));
		System.out.println();
	}
}
