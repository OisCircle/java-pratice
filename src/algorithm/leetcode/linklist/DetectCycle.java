package algorithm.leetcode.linklist;


/**
 * @author O
 * @since 2020/3/31
 */
public class DetectCycle {
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
        System.out.println(detectCycle(head).val);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null || head.next == null) {
            return false;
        }
        while (fast != null) {
            fast = fast.next;
            if (fast == slow) {
                return true;
            }
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) {
            return head;
        }
        ListNode entry = null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (true) {
            if (fast == slow) {
                System.out.println("找到环");
                break;
            }
            if (slow == null || fast == null || fast.next == null || fast.next.next == null) {
                System.out.println("不存在环，算法结束");
                return null;
            }
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        //找到了环，求环长度
        int len = 0;
        do {
            len++;
            fast = fast.next;
        } while (slow != fast);
        System.out.println("环长度：" + len);
        //一个指针先走len步，然后一起走，直到相遇
        slow = head;
        fast = head;
        while (len > 0) {
            fast = fast.next;
            len--;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        entry = slow;
        return entry;
    }
}
