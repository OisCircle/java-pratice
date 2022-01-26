package algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 先序中序后序 循环/递归 遍历
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/12
 */
public class BTreeTraversalTest {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode leaf1 = new TreeNode(1);
		TreeNode leaf2 = new TreeNode(2);
		TreeNode leaf3 = new TreeNode(3);
		TreeNode leaf4 = new TreeNode(4);
		TreeNode leaf5 = new TreeNode(5);
		TreeNode leaf6 = new TreeNode(6);
		TreeNode leaf7 = new TreeNode(7);

		root.left = leaf1;
		root.right = leaf2;
		leaf1.left = leaf3;
		leaf1.right = leaf4;
		leaf2.left = leaf5;
		leaf2.right = leaf6;
		leaf4.left = leaf7;

//		preOrderRecursive(root);
//		preOrderLoop(root);
//		inOrderRecursive(root);
//		inOrderLoop(root);
//		inOrderLoop0(root);
		postOrderRecursive(root);
		postOrderStack(root);
//		postOrderLoop(root);

	}

	//先序遍历
	static void preOrderRecursive(TreeNode root) {
		System.out.println("\npreOrderRecursive");
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		preOrderRecursive0(root);
	}

	static void preOrderRecursive0(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " -> ");
		preOrderRecursive0(root.left);
		preOrderRecursive0(root.right);
	}

	static void preOrderLoop(TreeNode root) {
		System.out.println("\npreOrderLoop");
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		TreeNode node;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(node.val + " -> ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	//中序遍历
	static void inOrderRecursive(TreeNode root) {
		System.out.println("\ninOrderRecursive");
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		inOrderRecursive0(root);
	}

	static void inOrderRecursive0(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderRecursive0(root.left);
		System.out.print(root.val + " -> ");
		inOrderRecursive0(root.right);
	}

	static void inOrderLoop(TreeNode root) {
		System.out.println("\ninOrderLoop");
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		//向左下角一直走，边走边压栈，然后输出栈，再判断右边有没有，有则进入右边，再继续往左下角走，重复
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			System.out.print(node.val + " -> ");
			node = node.right;
		}
	}

	static void inOrderLoop0(TreeNode root) {
		System.out.println("\ninOrderLoop0");
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				System.out.print(root.val + " -> ");
				root = root.right;
			}

		}
	}

	//后序遍历
	static void postOrderRecursive(TreeNode root) {
		System.out.println("\npostOrderRecursive");
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		postOrderRecursive0(root);
	}

	static void postOrderRecursive0(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrderRecursive0(root.left);
		postOrderRecursive0(root.right);
		System.out.print(root.val + " -> ");
	}

	static void postOrderLoop(TreeNode root) {
		System.out.println("\npostOrderLoop");
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		//当前访问节点，上次访问节点
		TreeNode currentNode, lastNode;
		currentNode = root;
		lastNode = null;

		while (currentNode != null) {
			stack.push(currentNode);
			currentNode = currentNode.left;
		}
		while (!stack.isEmpty()) {
			currentNode = stack.pop();
			if (currentNode.right == null || currentNode.right == lastNode) {
				System.out.print(currentNode.val + " -> ");
				lastNode = currentNode;
			} else {
				//根节点再次入栈
				stack.push(currentNode);
				//进入右子树，此时肯定右子树一定不为空
				currentNode = currentNode.right;
				while (currentNode != null) {
					stack.push(currentNode);
					currentNode = currentNode.left;
				}
			}
		}
	}
	/**
	* 这个方法非常巧妙！先左右入栈，list添加，最后倒序输出list
	*/
	static void postOrderStack(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			//和传统先序遍历不一样，先将左结点入栈
			if (node.left != null) {
				stack.push(node.left);
			}
			//后将右结点入栈
			if (node.right != null) {
				stack.push(node.right);
			}
			//逆序添加结点值
			res.add(node.val);
		}
		Collections.reverse(res);
		System.out.println();
		System.out.println(res);
		System.out.println();
	}

}
