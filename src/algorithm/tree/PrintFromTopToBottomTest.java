package algorithm.tree;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 简单的广度优先遍历
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/16
 */
public class PrintFromTopToBottomTest {
	public static void main(String[] args) {


	}

	static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			res.add(node.val);
			if (node.left != null) {
				q.offer(node.left);
			}
			if (node.right != null) {
				q.offer(node.right);
			}
		}
		return res;
	}
}
