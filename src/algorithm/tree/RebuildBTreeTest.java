package algorithm.tree;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/13
 */
public class RebuildBTreeTest {
	public static void main(String[] args) {
		int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

		BfsTest.bfs(rebuild(pre, 0, pre.length, in, 0, in.length));

	}


	static TreeNode rebuild(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
		if (inStart == inEnd) {
			return null;
		}
		TreeNode current = new TreeNode(preOrder[preStart]);
		int index = 0;
		for (int i = 0; i < inOrder.length; i++) {
			if (preOrder[preStart] == inOrder[i]) {
				index = i;
				break;
			}
		}
		preStart++;
		current.left = rebuild(preOrder, preStart, preStart + index - inStart + 1,
				inOrder, inStart, index);
		current.right = rebuild(preOrder, preStart + index - inStart, preEnd,
				inOrder, index + 1, inEnd);
		return current;


	}
}
