package algorithm.leetcode.linklist;

/**
 * @author O
 * @since 2020/4/29
 */
public class Flatten {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    private static void print(Node head) {
        Node cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val + " -> ");
            cur = cur.next;
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 4, sb.length());
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        //1 -> 2 -> 3 -> 7 -> 8 -> 11 -> 12 -> 9 -> 10 -> 4 -> 5 -> 6
        test0();
        //1 -> 3 -> 2
        test1();
        //
        test2();
    }

    private static void test0() {
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 2;
        Node n3 = new Node();
        n3.val = 3;
        Node n4 = new Node();
        n4.val = 4;
        Node n5 = new Node();
        n5.val = 5;
        Node n6 = new Node();
        n6.val = 6;
        Node n7 = new Node();
        n7.val = 7;
        Node n8 = new Node();
        n8.val = 8;
        Node n9 = new Node();
        n9.val = 9;
        Node n10 = new Node();
        n10.val = 10;
        Node n11 = new Node();
        n11.val = 11;
        Node n12 = new Node();
        n12.val = 12;

        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        n5.next = n6;
        n6.prev = n5;
        n3.child = n7;
        n7.next = n8;
        n8.prev = n7;
        n8.next = n9;
        n9.prev = n8;
        n9.next = n10;
        n10.prev = n9;
        n8.child = n11;
        n11.next = n12;
        n12.prev = n11;

        print(flatten(n1));
    }

    private static void test1() {
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 2;
        Node n3 = new Node();
        n3.val = 3;

        n1.next = n2;
        n2.prev = n1;
        n2.next = null;
        n1.child = n3;
        n3.next = null;

        print(flatten(n1));
    }

    private static void test2() {
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 2;
        Node n3 = new Node();
        n3.val = 3;

        n1.child = n2;
        n2.child = n3;

        print(flatten(n1));
    }

    public static Node flatten(Node head) {
        recursive(head);
        return head;
    }

    private static Node recursive(Node n) {
        while (n != null) {
            if (n.child != null) {
                Node next = n.next;
                n.next = n.child;
                n.child.prev = n;
                Node prev = recursive(n.child);
                n.child = null;
                if (next != null) {
                    next.prev = prev;
                    prev.next = next;
                }
            } else if (n.next == null) {
                break;
            }
            n = n.next;
        }
        return n;
    }
}
