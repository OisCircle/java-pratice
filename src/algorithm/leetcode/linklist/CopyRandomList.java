package algorithm.leetcode.linklist;

import java.util.HashMap;

/**
 * @author O
 * @since 2020/5/5
 */
public class CopyRandomList {
    private static HashMap<Node, Node> dict = new HashMap<>();

    public static void main(String[] args) {
        test0();
        test1();
    }

    static void test0() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n1.random = n2;
        n2.random = n2;
        final Node copy = copyRandomList(n1);
        final Node copy1 = copyRandomList1(n1);
        System.out.println(copy.val);
        System.out.println(copy.random.val);

        System.out.println(copy.next.val);
        System.out.println(copy.next.random.val);
    }

    static void test1() {
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> dict = new HashMap<>();
        Node cur = head;
        Node newHead = null;
        newHead = new Node(cur.val);
        Node copy = newHead;
        cur = cur.next;
        dict.put(head, newHead);
        //copy next
        while (cur != null) {
            copy.next = new Node(cur.val);
            copy = copy.next;
            dict.put(cur, copy);
            cur = cur.next;
        }
        //copy random
        cur = head;
        copy = newHead;
        while (cur != null) {
            if (cur.random != null) {
                copy.random = dict.get(cur.random);
            }
            cur = cur.next;
            copy = copy.next;
        }
        return newHead;
    }

    public static Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        if (dict.containsKey(head)) {
            return dict.get(head);
        }
        Node copy = new Node(head.val);
        dict.put(head, copy);
        copy.next = copyRandomList1(head.next);
        copy.random = copyRandomList1(head.random);
        return copy;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
