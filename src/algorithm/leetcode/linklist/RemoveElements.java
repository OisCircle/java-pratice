package algorithm.leetcode.linklist;

/**
 * @author O
 * @since 2020/3/31
 */
public class RemoveElements {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        print(head);
        print(removeElements(head, 1));

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        print(a1);
        print(removeElements(a1, 1));

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        b1.next = b2;
        print(b1);
        print(removeElements(b1, 2));
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode sb=new ListNode(-1);
        sb.next = head;
        ListNode cur = sb;
        ListNode last = head;
        while (cur != null) {
            if (cur.val == val) {
                if (cur.next != null) {
                    last.next = cur.next;
                    cur = last;
                } else {
                    last.next = null;
                }
            }
            last = cur;
            cur = cur.next;
        }
        return sb.next;
    }
}
