package algorithm.leetcode.hash;

/**
 * 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * 示例:
 * <p>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 *
 * @author O
 * @version 1.0
 * @since 2019/4/10
 */
class MyHashSet {
	private static final int BUCKET_SIZE = 10000;

	private static class Entry {
		/**
		 * 构建并链接两边，首节点不存值
		 */
		Entry(int key, Entry pre, Entry next) {
			this.key = key;
			this.pre = pre;
			this.next = next;
			if (pre != null) {
				pre.next = this;
			}
			if (next != null) {
				next.pre = this;
			}
		}

		int key;
		Entry pre;
		Entry next;
	}

	private static Entry[] entries;

	public static void main(String[] args) {
		MyHashSet set = new MyHashSet();
		set.add(1);
		set.add(2);
		System.out.println(set.contains(1));
		System.out.println(set.contains(3));
		set.add(2);
		System.out.println(set.contains(2));
		set.remove(2);
		System.out.println(set.contains(2));
	}

	/**
	 * Initialize your data structure here.
	 */
	public MyHashSet() {
		entries = new Entry[BUCKET_SIZE];
		for (int i = 0; i < BUCKET_SIZE; i++) {
			entries[i] = new Entry(0, null, null);
		}
	}

	public void add(int key) {
		int i = key % BUCKET_SIZE;
		Entry entry = entries[i];
		while (entry.next != null) {
			entry = entry.next;
			if (entry.key == key) {
				return;
			}
		}
		new Entry(key, entry, null);
	}

	public void remove(int key) {
		int i = key % BUCKET_SIZE;
		Entry entry = entries[i].next;
		while (entry != null && entry.key != key) {
			entry = entry.next;
		}
		if (entry != null) {
			Entry pre = entry.pre;
			Entry next = entry.next;
			pre.next = next;
			if (next != null) {
				next.pre = pre;
			}
			entry.next = null;
			entry.pre = null;
		}
	}

	/**
	 * Returns true if this set contains the specified element
	 */
	public boolean contains(int key) {
		int i = key % BUCKET_SIZE;
		Entry entry = entries[i].next;
		while (entry != null) {
			if (entry.key == key) {
				return true;
			}
			entry = entry.next;
		}
		return false;
	}
}