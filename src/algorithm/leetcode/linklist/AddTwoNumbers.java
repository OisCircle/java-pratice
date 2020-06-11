package algorithm.leetcode.linklist;


/**
 * @author O
 * @since 2020/4/28
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        //7 -> 0 -> 8
        test0();
        //8 -> 9 -> 9 -> 1
        test1();
        //0 -> 1 -> 0 -> 1
        test2();
        //2 -> 2 -> 2
        test3();
        //2 -> 0 -> 1
        test4();
    }

    private static void test0() {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l11.next = l12;
        l12.next = l13;

        l21.next = l22;
        l22.next = l23;

        print(addTwoNumbers(l11, l21));
    }

    public static void test1() {
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);

        l11.next = l12;
        l12.next = l13;

        l21.next = l22;
        l22.next = l23;

        print(addTwoNumbers(l11, l21));
    }

    public static void test2() {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(1);

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);

        l11.next = l12;

        l21.next = l22;
        l22.next = l23;

        print(addTwoNumbers(l11, l21));
    }

    public static void test3() {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(1);

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(1);
        ListNode l23 = new ListNode(1);

        l11.next = l12;
        l12.next = l13;

        l21.next = l22;
        l22.next = l23;

        print(addTwoNumbers(l11, l21));
    }

    public static void test4() {
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(7);

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(2);

        l11.next = l12;

        l21.next = l22;

        print(addTwoNumbers(l11, l21));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode last = null;
        boolean carry = false;
        ListNode t;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                final int val = l2.val + (carry ? 1 : 0);
                t = new ListNode(val % 10);
                carry = val > 9;
            } else if (l2 == null) {
                final int val = l1.val + (carry ? 1 : 0);
                t = new ListNode(val % 10);
                carry = val > 9;
            } else {
                final int val = l1.val + l2.val + (carry ? 1 : 0);
                if (val > 9) {
                    t = new ListNode(val % 10);
                    carry = true;
                } else {
                    t = new ListNode(val % 10);
                    carry = false;
                }
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (res == null) {
                res = t;
                last = t;
            } else {
                last.next = t;
                last = t;
            }
        }
        //不要忘了最后的进位
        if (carry) {
            t = new ListNode(1);
            last.next = t;
        }
        return res;
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}