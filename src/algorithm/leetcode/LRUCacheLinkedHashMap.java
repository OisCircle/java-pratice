package algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * 通过LinkedHashMap实现LRU
 * https://blog.csdn.net/xiongxianze/article/details/80232078
 * https://www.jianshu.com/p/b8b00da28a49
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/26
 */
public class LRUCacheLinkedHashMap<K, V> {
	public static void main(String[] args) {
		LRUCacheLinkedHashMap<Integer, String> cache = new LRUCacheLinkedHashMap<>(2);
		System.out.println(cache.get(1));
		cache.put(1, "cache1");
		cache.put(2, "cache2");
		cache.get(2);
		cache.put(3, "cache3");
		System.out.println(cache.get(2));
	}

	private int capacity = 2;
	private LinkedHashMap<K, V> map = null;

	public LRUCacheLinkedHashMap(int capacity) {
		this.capacity = capacity;
		//accessOrder:true,为了让get的时候,将元素放到链表头部
		map = new LinkedHashMap(capacity, 0.75F, true) {
			//主要重写这个方法,return true代表移除最老的元素
			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				if (capacity + 1 == map.size()) {
					return true;
				}
				return false;
			}
		};
	}

	public V get(K key) {
		return map.get(key);
	}

	public void put(K key, V value) {
		map.put(key, value);
	}

}
