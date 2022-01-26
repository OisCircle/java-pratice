package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 深度优先遍历
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/11
 */
public class DfsTest {
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

		dfs(root);
		System.out.println("\n-------------------");
		dfsRec(root);
		System.out.println("\n-------------------");
		dfs(leaf2);
		System.out.println("\n-------------------");
		dfs(leaf3);
		System.out.println("\n-------------------");
		dfs(leaf4);
		System.out.println("\n-------------------");
		dfs(null);
	}

	static void dfs(TreeNode root) {
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = null;
		stack.push(root);
		//先入右子树
		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.println(node.val + " -> ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	static void dfsRec(TreeNode cur) {
		if (cur == null) {
			return;
		}
		System.out.println(cur.val);
		dfsRec(cur.left);
		dfsRec(cur.right);
	}
}
