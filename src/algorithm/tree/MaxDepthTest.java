package algorithm.tree;

import com.sun.media.sound.RIFFInvalidDataException;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/9
 */
public class MaxDepthTest {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode leaf1 = new TreeNode(1);
		TreeNode leaf2 = new TreeNode(1);
		root.left = leaf1;
		root.right = leaf2;
		TreeNode leaf3 = new TreeNode(1);
		TreeNode leaf4 = new TreeNode(1);
		leaf1.left = leaf3;
		leaf1.right = leaf4;
		TreeNode leaf5 = new TreeNode(1);
		TreeNode leaf6 = new TreeNode(1);
		leaf4.left = leaf5;
		leaf4.right = leaf6;
		TreeNode leaf7 = new TreeNode(1);
		leaf5.right = leaf7;

		System.out.println(maxDepth(root));

		System.out.println(maxDepth(leaf1));

		System.out.println(maxDepth(leaf5));

	}


	static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		//左边的树深度
		int left = maxDepth(root.left);
		//右边的树深度
		int right = maxDepth(root.right);
		//哪边深一点，返回哪边的深度
		return (left < right ? right + 1 : left + 1);
	}
}



