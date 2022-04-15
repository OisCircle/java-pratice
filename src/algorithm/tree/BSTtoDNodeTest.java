package algorithm.tree;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

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
		convert1(n1);
		System.out.println(n1);
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
	/**
	* 中序遍历是 2 3 4 5 7 8 9，pre要传null，也就是 null 2 3 4 5 7 8 9，所以要处理pre == null的情况，2的pre是null
	*/
	static TreeNode convert2(TreeNode cur, TreeNode pre) {
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
}