package algorithm.backtrack;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 * 思路：深度优先搜索+搜索过程中使用HashMap建立序列化key，并判断重复
 * @author O
 * @since 2020/3/15
 */
public class FindDuplicateSubtrees {
    private static Map<String, Integer> serialMap;
    private static List<TreeNode> res;

    public static void main(String[] args) {
        //test
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;

        System.out.println(findDuplicateSubtrees(root));
        System.out.println(serialMap);
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialMap = new HashMap<>();
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        serial(root);
        return res;
    }

    private static String serial(TreeNode n) {
        String str;
        if (n == null) {
            return "#";
        } else {
            str = n.val + serial(n.left) + serial(n.right);
        }
        serialMap.put(str, serialMap.getOrDefault(str, 0) + 1);
        if (serialMap.get(str) == 2) {
            res.add(n);
        }
        return str;
    }
}
