package algorithm.tree;

import java.util.*;

import apple.laf.JRSUIUtils;

/**
 * <p>
 * 广度优先遍历
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/11
 */
public class BfsTest {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode leaf1 = new TreeNode(1);
		TreeNode leaf2 = new TreeNode(2);
		TreeNode leaf3 = new TreeNode(3);
		TreeNode leaf4 = new TreeNode(4);
		TreeNode leaf5 = new TreeNode(5);
		TreeNode leaf6 = new TreeNode(6);

		root.left = leaf1;
		root.right = leaf2;
		leaf1.left = leaf3;
		leaf1.right = leaf4;
		leaf4.left = leaf5;
		leaf5.right = leaf6;

		bfs(root);
		System.out.println("\n-------------------");
//		bfs(leaf2);
//		System.out.println("\n-------------------");
//		bfs(leaf3);
//		System.out.println("\n-------------------");
//		bfs(leaf4);
//		System.out.println("\n-------------------");
//		bfs(null);

		levelOrder2(root).stream().forEach(System.out::println);
	}

	static void bfs(TreeNode root) {
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		TreeNode node;
		//入队，输出，同时判断左右子树是否存在，存在则入队
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.print(node.val + " -> ");
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}


	/**
	 * 层序遍历，输出每行
	 */
	static List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		TreeNode node = root;
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		TreeNode last = root;
		TreeNode nextLast = null;
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			list.add(node.val);
			if (node.left != null) {
				queue.offer(node.left);
				nextLast = node.left;
			}
			if (node.right != null) {
				queue.offer(node.right);
				nextLast = node.right;
			}
			if (node == last) {
				result.add(list);
				list = new ArrayList<>();
				last = nextLast;
			}
		}
		return result;
	}


	/**
	 * 层序遍历
	 *
	 * lineEnd记录当前层的最后一个元素
	 *
	 * nextLast记录下一层的最后一个元素
	 */
	static List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		TreeNode node;
		TreeNode nextLast = root;
		TreeNode lineEnd = root;
		//入队，输出，同时判断左右子树是否存在，存在则入队
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (node.left != null) {
				queue.offer(node.left);
				nextLast = node.left;
			}
			if (node.right != null) {
				queue.offer(node.right);
				nextLast = node.right;
			}
			list.add(node.val);
			if (node == lineEnd) {
				res.add(list);
				list = new ArrayList<>();
				lineEnd = nextLast;
			}
		}
		return res;
	}
}
