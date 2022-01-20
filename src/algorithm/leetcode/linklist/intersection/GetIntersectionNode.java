package algorithm.leetcode.linklist.intersection;

/**
 * 相交链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/linked-list/jjbj2/
 *
 * @author O
 * @since 2020/3/31
 */
public class GetIntersectionNode {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(5);
        ListNode c2 = new ListNode(6);
        a1.next = a2;
        a2.next = a3;
        c1.next = c2;
        a3.next = c1;
        b1.next = c1;
        print(a1);
        print(b1);
        System.out.println(getIntersectionNode2(a1, b1).val);
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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //找出两个长度
        int lenA = 0, lenB = 0;
        ListNode cur = headA;
        while (cur != null) {
            lenA++;
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            lenB++;
            cur = cur.next;
        }
        //长的先走，然后一起走，直到相遇
        int gap = Math.abs(lenA - lenB);
        cur = lenA > lenB ? headA : headB;
        while (gap-- > 0) {
            cur = cur.next;
        }
        ListNode a = lenA > lenB ? cur:headA;
        ListNode b = lenA > lenB ? headB : cur;
        while (a != b) {
            //如果没有相交
            if (a == null || b == null) {
                return null;
            }
            a = a.next;
            b = b.next;
        }
        return a;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        //控制只交换轨道一次
        boolean aChanged = false, bChanged = false;
        //任意一个走完还是没相等说明没有AB链表相交
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
            if (a == null && !aChanged) {
                a = headB;
                aChanged = true;
            }
            if (b == null && !bChanged) {
                bChanged = true;
                b = headA;
            }
        }
        return null;
    }
}
