package algorithm.tree;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/19
 */
public class BSTtoDNodeTest {
	private static TreeNode last = null;
	private static TreeNode first = null;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(9);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
//		convert1(n1);
//		System.out.println(n1);

		act(n1);
	}

	/**
	 * 解法1:BST中序遍历的结果就是排序数组,先遍历到数组,再遍历,修改指针
	 */
	static TreeNode convert(TreeNode pRootOfTree) {
		TreeNode node = pRootOfTree;
		if (node == null) {
			return null;
		}
		List<TreeNode> list = new ArrayList<>();
		convert0(node, list);
		list.get(0).left = null;
		for (int i = 0; i < list.size() - 1; i++) {
			TreeNode cur = list.get(i);
			TreeNode next = list.get(i + 1);
			cur.right = next;
			next.left = cur;
		}
		return null;
	}


	private static void convert0(TreeNode cur, List<TreeNode> list) {
		if (cur == null) {
			return;
		}
		convert0(cur.left, list);
		list.add(cur);
		convert0(cur.right, list);
	}

	/**
	 * 解法2:在中序遍历的过程中拼接双向链表
	 */
	static TreeNode convert1(TreeNode pRootOfTree) {
		TreeNode node = pRootOfTree;
		if (node == null) {
			return null;
		}
		convert2(node, null);
		node = pRootOfTree;
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	static TreeNode convert2(TreeNode cur, TreeNode pre) {
		//中序递归终止条件
		if (cur == null) {
			return null;
		}
		if (cur.left != null) {
			//将pre作为下一个要遍历的节点的前驱
			pre = convert2(cur.left, pre);
		}
		cur.left = pre;
		if (pre != null) {
			pre.right = cur;
		}
		//下面要遍历右子树,所以将本节点作为下一个节点的前驱
		pre = cur;
		if (cur.right != null) {
			pre = convert2(cur.right, cur);
		}
		return pre;
	}

	static void act(TreeNode cur) {
		Consumer<TreeNode> consume1 = mid -> {
			if (last == null) {
				first = mid;
			}
			if (last != null) {
				last.right = mid;
			}
			last = mid;
		};

		Consumer<TreeNode> consume2 = mid -> {

		};

		mid(cur, consume1);

		while (first != null) {
			System.out.print(first.val);
			first = first.right;
		}
	}

	//使用中序遍历通用模型，再改造一下，每个打印的目标，链接下一个目标即可
	static void mid(TreeNode cur, Consumer<TreeNode> consumer) {
		Stack<TreeNode> stack = new Stack<>();
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			if (!stack.isEmpty()) {
				TreeNode mid = stack.pop();
				System.out.println(mid.val);
				//自定义逻辑，其它都是中序遍历通用逻辑
				consumer.accept(mid);
				cur = mid.right;
			}
		}
	}
}