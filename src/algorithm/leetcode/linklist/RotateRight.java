package algorithm.leetcode.linklist;

/**
 * @author O
 * @since 2020/4/29
 */
public class RotateRight {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void print(ListNode head) {
        ListNode cur = head;
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

    private static void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        print(n1);
        print(rotateRight(n1, 2));
    }

    private static void test2() {
        ListNode n1 = new ListNode(1);
        print(n1);
        print(rotateRight(n1, 2));
    }

    private static void test3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        print(n1);
        print(rotateRight(n1, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode n = head;
        while (n != null) {
            n = n.next;
            len++;
        }
        int count = (k % len) % len;
        System.out.println("count: " + count);
        if (count == 0) {
            return head;
        }
        count = len - count;
        ListNode cur = head;
        while (--count > 0) {
            cur = cur.next;
        }
        ListNode node = cur;
        cur = cur.next;
        ListNode newHead = cur;
        node.next = null;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }
}

