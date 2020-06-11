package algorithm.list_node;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/9
 */
public class HasCircleListNodeTest {
    //1.一快一慢找出环
    //2.一停一搜找出环长度（本题不要求这一步骤）
    //3.一个指针先走n步找出入口（本题不要求这一步骤）
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        head.next = l2;
//		l2.next = head;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        //true
        System.out.println(hasCycle(head));
        //2
        System.out.println(findCircleEntry(head));
        head.next = l2;
        l2.next = head;
        l3.next = null;
        l4.next = null;
        //1
        System.out.println(findCircleEntry(head));
        //null
        head.next = null;
        System.out.println(findCircleEntry(head));

    }

    static ListNode findCircleEntry(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == pHead) {
            return pHead;
        }
        ListNode entry = null;
        ListNode slow = pHead;
        ListNode fast = pHead.next;
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
        slow = pHead;
        fast = pHead;
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

    static boolean hasCycle(ListNode head) {


        if (head == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
        } while (slow != fast);

        return true;
    }

}
