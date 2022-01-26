package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * MirrorBTreeTest一样的题目
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/15
 */
public class MirrorTest {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t2.left = t4;
		t2.right = t5;
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t3.left = t6;
		t3.right = t7;
		print(t1);
		mirrorify(t1);
		print(t1);
	}

	private static void mirrorify(TreeNode root) {
		if (root != null) {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			if (root.left != null) {
				mirrorify(root.left);
			}
			if (root.right != null) {
				mirrorify(root.right);
			}
		}
	}

	private static void print(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.println(node.val);
			if (node.left != null) {
				q.offer(node.left);
			}
			if (node.right != null) {
				q.offer(node.right);
			}
		}
	}
}
