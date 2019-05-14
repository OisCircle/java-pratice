package algorithm.leetcode;

import java.util.HashMap;

/**
 * <p>
 * 注意这里默认尾部是旧数据，头部是新数据
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/2
 */
public class LRUCache2 {
	private int capacity, size;
	private HashMap<Integer, DNode> cache;
	private DNode head;
	private DNode tail;

	private static class DNode {
		DNode() {
		}

		DNode(int key, int value) {
			this.key = key;
			this.value = value;
		}

		DNode pre;
		DNode next;
		int key;
		volatile int value;
	}

	public static void main(String[] args) {
		LRUCache2 cache = new LRUCache2(3);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.get(1);
		cache.get(2);
		cache.get(3);
		cache.get(4);
	}


	public LRUCache2(int capacity) {
		size = 0;
		this.capacity = capacity;
		cache = new HashMap<>(capacity);
		head = new DNode();
		tail = new DNode();
		head.next = null;
		head.pre = tail;
		tail.next = tail;
		tail.pre = null;
	}

	public int get(int key) {
		DNode node = cache.get(key);
		if (node == null) {
			System.out.println("get : " + key + " ... but no value");
			return -1;
		} else {
			moveToHead(node);
			print(tail, head);
			return node.value;
		}
	}

	private void moveToHead(DNode node) {
		remove(node);
		DNode preHead = head.pre;
		preHead.next = node;
		node.pre = preHead;
		node.next = head;
		head.pre = node;
	}

	private void remove(DNode node) {
		DNode pre = node.pre;
		DNode next = node.next;
		pre.next = next;
		next.pre = pre;
		//in case of memory leak
		node.next = null;
		node.pre = null;
	}

	private void appendHead(DNode node) {
		DNode preHead = head.pre;
		preHead.next = node;
		node.pre = preHead;
		node.next = head;
		head.pre = node;
	}

	public void put(int key, int value) {
		DNode node = cache.get(key);
		if (node != null) {
			moveToHead(node);
			node.value = value;
		} else {
			if (size >= capacity) {
				//remove tail
				size--;
				cache.remove(tail.next.key);
				remove(tail.next);
			}
			//create
			node = new DNode(key, value);
			cache.put(key, node);
			size++;
			//append head
			appendHead(node);
		}
		System.out.println("put (" + node.key + "," + node.value + ")... current nodes:");
		print(tail, head);
	}

	private static void print(DNode tail, DNode head) {
		DNode n = tail.next;
		while (n != head) {
			System.out.print("(" + n.key + "," + n.value + ")" + "->");
			n = n.next;
		}
		System.out.println();
	}
}
