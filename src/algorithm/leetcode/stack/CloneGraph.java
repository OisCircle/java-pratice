package algorithm.leetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author O
 * @since 2020/3/23
 */
public class CloneGraph {
    private static Map<Node, Node> visited = new HashMap<>();;

    public static void main(String[] args) {
        List<Node> neighbors1 = new ArrayList<>();
        List<Node> neighbors2 = new ArrayList<>();
        List<Node> neighbors3 = new ArrayList<>();
        List<Node> neighbors4 = new ArrayList<>();
        final Node node1 = new Node(1);
        final Node node2 = new Node(2);
        final Node node3 = new Node(3);
        final Node node4 = new Node(4);

        neighbors1.add(node2);
        neighbors1.add(node4);

        neighbors2.add(node1);
        neighbors2.add(node3);

        neighbors3.add(node2);
        neighbors3.add(node4);

        neighbors4.add(node1);
        neighbors4.add(node3);
        node1.neighbors = neighbors1;
        node2.neighbors = neighbors2;
        node3.neighbors = neighbors3;
        node4.neighbors = neighbors4;

        cloneGraph(node1);
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node copy = new Node(node.val, new ArrayList<>());
        visited.put(node, copy);
        for (Node n : node.neighbors) {
            copy.neighbors.add(cloneGraph(n));
        }
        return copy;
    }

    public static Node cloneGraph0(Node node) {
        if (null == node) {
            return node;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node copy = new Node(node.val, new ArrayList<>());
        visited.put(node, copy);
        for (Node n : node.neighbors) {
            copy.neighbors.add(cloneGraph0(n));
        }
        return copy;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}