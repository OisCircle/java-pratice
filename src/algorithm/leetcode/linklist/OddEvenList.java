package algorithm.leetcode.linklist;

/**
 * @author O
 * @since 2020/4/1
 */
public class OddEvenList {
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
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        print(n0);

        print((oddEvenList(n0)));

        System.out.println("-------------");


        ListNode a0 = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(6);
        ListNode a6 = new ListNode(7);
        ListNode a7 = new ListNode(8);

        a0.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

        print(a0);

        print((oddEvenList(a0)));

        System.out.println("-------------");

        ListNode b0 = new ListNode(1);
        ListNode b1 = new ListNode(2);

        b0.next = b1;

        print(b0);

        print((oddEvenList(b0)));
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //偶
        ListNode ou = head.next;
        //奇
        ListNode ji = head;
        //head
        ListNode ouHead = ou;
        ListNode jiHead = ji;
        while (ou != null && ji != null) {
            if (ou.next == null) {
                break;
            }
            ji.next = ou.next;
            ji = ji.next;
            if (ji.next == null) {
                ou.next = null;
                break;
            }
            ou.next = ji.next;
            ou = ou.next;
        }
        ji.next = ouHead;
        return jiHead;
    }
}
