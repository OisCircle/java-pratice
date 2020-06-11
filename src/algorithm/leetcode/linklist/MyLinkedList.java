package algorithm.leetcode.linklist;

class MyLinkedList {
    public static void main(String[] args) {
        final MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        print();
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        print();
        System.out.println(list.get(1));

        System.out.println("-----------------");

        final MyLinkedList list1 = new MyLinkedList();
        list1.addAtHead(4);
        list1.get(1);
        list1.addAtHead(1);
        list1.addAtHead(5);
        list1.deleteAtIndex(3);
        list1.addAtHead(7);
        list1.get(3);
        list1.get(3);
        list1.get(3);
        list1.addAtHead(3);
        list1.deleteAtIndex(4);
    }


    private static void print() {
        Node cur = head.next;
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

    private static Node head;

    private class Node {
        Node() {

        }

        Node(int val) {
            this.val = val;
        }

        int val;
        Node next;
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new Node();
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node cur = head;
        while (index-- >= 0) {
            if (cur == null || cur.next == null) {
                return -1;
            }
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head.next;
        head.next = n;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node tail = new Node(val);
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = tail;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node cur = head;
        while (index-- > 0) {
            cur = cur.next;
        }
        if (cur != null) {
            Node n = new Node(val);
            n.next = cur.next;
            cur.next = n;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node pre = head;
        Node cur;
        while (index-- > 0 && pre != null) {
            pre = pre.next;
        }
        if (pre != null && pre.next != null) {
            cur = pre.next;
            pre.next = cur.next;
            cur.next = null;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */