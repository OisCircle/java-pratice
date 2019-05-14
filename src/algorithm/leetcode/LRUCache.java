package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用hashmap+双向链表实现，注意指针的操作，以及双向链表两个初始化的head和tail节点是必须的，为了统一操作
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/14
 */
public class LRUCache {
	private static class DLinkedNode {
		int key;
		int val;
		DLinkedNode next;
		DLinkedNode last;
	}

	private Map<Integer, DLinkedNode> cache = new HashMap<>();
	private int capacity;
	private DLinkedNode head, tail;
	private int count;

	public LRUCache(int capacity) {
		System.out.println("初始化...");
		this.capacity = capacity;
		count = 0;
		head = new DLinkedNode();
		head.next = null;
		tail = new DLinkedNode();
		tail.last = null;
		head.last = tail;
		tail.next = head;
	}

	private void moveToHead(DLinkedNode node) {
		System.out.println("开始移动至头节点: " + node.val);
		removeMiddle(node);
		appendHead(node);
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		//cache没有
		if (node == null) {
			System.out.println("获取: " + key + " 失败");
			return -1;
		}
		System.out.println("获取: " + key + " 成功, value: " + node.val);
		//cache存在，挪到head
		moveToHead(node);
		return node.val;
	}

	//放到头节点
	private void appendHead(DLinkedNode node) {
		System.out.println("放到头节点: " + node.val);
		node.next = head;
		node.last = head.last;
		head.last.next = node;
		head.last = node;
	}

	//去除中间节点
	private void removeMiddle(DLinkedNode node) {
		System.out.println("去除中间节点: " + node.val);
		DLinkedNode next = node.next;
		DLinkedNode last = node.last;
		last.next = next;
		next.last = last;
		node.next = null;
		node.last = null;
	}

	private DLinkedNode removeLast() {
		DLinkedNode last = tail.next;
		removeMiddle(last);
		return last;
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		//cache未命中，
		if (node == null) {
			System.out.println("put未命中: " + value);
			node = new DLinkedNode();
			node.key = key;
			node.val = value;
			cache.put(key, node);

			appendHead(node);
			count++;
			if (count > capacity) {
				//同时还要移除hashmap里面的东西
				cache.remove(tail.next.key);
				removeMiddle(tail.next);
				count--;
			}
		} else {
			System.out.println("put命中: " + value);
			//cache命中，更新值，还要移动到前面
			node.val = value;
			moveToHead(node);
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.get(1);
		cache.put(1, 10);
		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);
		cache.put(2, 20);
		cache.put(2, 20);
		cache.put(1, 10);

	}
}
