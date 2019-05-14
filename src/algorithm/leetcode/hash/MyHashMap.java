package algorithm.leetcode.hash;

class MyHashMap {
	private static final int BUCKET_SIZE = 5;

	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		System.out.println(map.get(1));
		map.put(1, 10);
		System.out.println(map.get(1));
		map.put(1, 100);
		System.out.println(map.get(1));
		map.put(2, 20);
		System.out.println(map.get(2));
		map.remove(1);
		System.out.println(map.get(1));
	}

	private static class Entry {
		/**
		 * 构建并链接两边，首节点不存值
		 */
		Entry(int key, int value, Entry pre, Entry next) {
			this.key = key;
			this.value = value;
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
		int value;
		Entry pre;
		Entry next;
	}

	private static Entry[] entries;

	/**
	 * Initialize your data structure here.
	 */
	public MyHashMap() {
		entries = new Entry[BUCKET_SIZE];
		for (int i = 0; i < BUCKET_SIZE; i++) {
			entries[i] = new Entry(0, 0, null, null);
		}
	}

	/**
	 * value will always be non-negative.
	 */
	public void put(int key, int value) {
		int i = key % BUCKET_SIZE;
		Entry entry = entries[i];
		while (entry.next != null) {
			entry = entry.next;
			if (entry.key == key) {
				entry.value = value;
				return;
			}
		}
		new Entry(key, value, entry, null);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
	 */
	public int get(int key) {
		int i = key % BUCKET_SIZE;
		Entry entry = entries[i].next;
		while (entry != null) {
			if (entry.key == key) {
				return entry.value;
			}
			entry = entry.next;
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping for the key
	 */
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
}