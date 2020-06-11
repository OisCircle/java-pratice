package algorithm.leetcode.hash;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
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
 *
 * 思路
 *
 * 假设每棵子树都有一个唯一标识符：只有当两个子树的 id 相同时，认为这两个子树是相同的。
 *
 * 一个节点 node 的左孩子 id 为 x，右孩子 id 为 y，那么该节点的 id 为 (node.val, x, y)。
 *
 * 算法
 *
 * 如果三元组 (node.val, x, y) 第一次出现，则创建一个这样的三元组记录该子树。如果已经出现过，则直接使用该子树对应的 id。
 *
 * @since 2020/3/15
 */
public class FindDuplicateSubtrees {
    private static int t;
    private static Map<String, Integer> idMap;
    private static Map<Integer, Integer> countMap;
    private static List<TreeNode> res;

    public static void main(String[] args) {
        //test
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n3 = new TreeNode(4);
        TreeNode n2 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;

        findDuplicateSubtrees(root);
        System.out.println("idMap   keys: "+idMap.keySet().toString());
        System.out.println("idMap values: "+idMap.values().toString());
        System.out.println("countMap   keys: "+countMap.keySet().toString());
        System.out.println("countMap values: "+countMap.values().toString());
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        idMap = new HashMap<>();
        countMap = new HashMap<>();
        res = new ArrayList<>();
        t = 1;
        lookup(root);
        return res;
    }

    private static int lookup(TreeNode n) {
        if (n == null) {
            return 0;
        }
        System.out.println(n.val);
        String serial = n.val + "," + lookup(n.left) + "," + lookup(n.right);
        int uid = idMap.computeIfAbsent(serial, k -> t++);
        countMap.put(uid, countMap.getOrDefault(uid, 0) + 1);
        if (countMap.get(uid) == 2) {
            res.add(n);
        }
        return uid;
    }
}
