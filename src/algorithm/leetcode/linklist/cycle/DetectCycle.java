package algorithm.leetcode.linklist.cycle;


/**
 * 环形链表 II
 * <p>
 * https://leetcode-cn.com/leetbook/read/linked-list/jjhf6/
 *
 * @author O
 * @since 2020/3/31
 */
public class DetectCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        print(head);
        n3.next = n1;
//        System.out.println(hasCycle(head));
        System.out.println(detectCycle(head));
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //fast走得快，走到了null说明没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        //代码走到这里说明两个指针首次相遇

        //一个从头开始走，一个一直转圈，相遇的点代表环的入口
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
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
}
