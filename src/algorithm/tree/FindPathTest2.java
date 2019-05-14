package algorithm.tree;

import java.util.ArrayList;

/**
 * <p>
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/16
 */
public class FindPathTest2 {
	public static void main(String[] args) {
//		TreeNode t1 = new TreeNode(1);
//		TreeNode t2 = new TreeNode(2);
//		TreeNode t3 = new TreeNode(4);
//		TreeNode t4 = new TreeNode(4);
//		TreeNode t5 = new TreeNode(5);
//		TreeNode t6 = new TreeNode(2);
//		TreeNode t7 = new TreeNode(7);
//
//		t1.left = t2;
//		t1.right = t3;
//		t2.left = t4;
//		t2.right = t5;
//		t3.left = t6;
//		t3.right = t7;
//		System.out.println(findPath(t1, 7));


		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(12);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;

		System.out.println(findPath(t1, 15));
	}

	static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		findPath0(res, new ArrayList<>(), root, target, 0);
		return res;
	}

	static void findPath0(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, TreeNode node, int target, int cur) {
		cur += node.val;
		path.add(node.val);
		//这里的判断要注意!因为定义为:{从树的根结点开始往下一直到叶结点所经过的结点形成一条路径}
		//虽然有的没有到达叶节点就等于target了,这种情况要放弃
		if (cur == target && node.left == null && node.right == null) {
			res.add(new ArrayList<>(path));
		} else if (cur < target) {
			//左右分别递归查找
			if (node.left != null) {
				findPath0(res, path, node.left, target, cur);
			}
			if (node.right != null) {
				findPath0(res, path, node.right, target, cur);
			}
		}
		//恢复现场
		path.remove(path.size() - 1);
	}
}
