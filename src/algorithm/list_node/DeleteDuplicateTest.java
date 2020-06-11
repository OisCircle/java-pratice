package algorithm.list_node;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class DeleteDuplicateTest {
    public static void main(String[] args) {
        test(listNode -> {
            System.out.println("去重之前");
            listNode.print();
            System.out.println("去重之后");
            deleteDuplication2(listNode).print();
        });

        test(listNode -> {
            System.out.println("去重之前");
            listNode.print();
            System.out.println("去重之后");
            deleteDuplication3(listNode).print();
        });
    }

    static void test(Consumer<ListNode> consumer) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(4);
        ListNode l8 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        consumer.accept(l1);
    }

    /**
     * TODO unfinished
     * 删除重复节点，重复的节点只保留一个
     * 思路1：
     * 第1次遍历，使用set记录所有数据
     * 第2次遍历：在set中查询到，则添加纪录并删除set里面的数据，在set中查询不到则忽略
     * 注意：这是处理未排序的链表，题目要求是排序链表，所以应该看思路2
     */
    static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        Set<Integer> set = new HashSet<>();
        ListNode node = pHead;
        while (node != null) {
            set.add(node.val);
            node = node.next;
        }
        node = pHead;
        ListNode newHead = node;
        while (node != null) {
            if (set.contains(node.val)) {
                set.remove(node.val);
                newHead.val = node.val;
                node = node.next;
            } else {

            }
        }
        return null;
    }

    /**
     * 删除重复节点，重复的节点只保留一个
     * 思路2：在排序链表中，应该直接让其指向不重复的下一个
     * 时间复杂度：O（n）
     */
    static ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode node = pHead.next;
        ListNode pre = pHead;
        int current = pHead.val;
        while (node != null) {
            while (current == node.val && node.next != null) {
                node = node.next;
            }
            pre.next = node;
            pre = pre.next;
            node = node.next;
            current = pre.val;
        }
        return pHead;
    }

    /**
     * 删除重复节点，重复的节点不保留
     * 链表已排序
     * 思路3：
     */
    static ListNode deleteDuplication3(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = pHead;
        //指向已确定不重复的节点
        ListNode pre = newHead;
        //指向下一个已确定不重复的节点
        ListNode cur = newHead.next;
        while (cur != null) {
            //如果相等
            if (cur.next != null && cur.val == cur.next.val) {
                //跳过相同的
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

}
