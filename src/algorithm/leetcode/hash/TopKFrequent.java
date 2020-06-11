package algorithm.leetcode.hash;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author O
 * @since 2020/3/17
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4};
        int[] nums2 = new int[]{1, 1, 2};
        int[] nums3 = new int[]{1};
        System.out.println(topKFrequent(nums1, 3));
        System.out.println(topKFrequent(nums2, 1));
        System.out.println(topKFrequent(nums3, 1));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        final List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // return 0;  // 降序
                return o2.getValue().compareTo(o1.getValue()); // 降序
            }
        });
        list.forEach(System.out::println);
        return list.subList(0, k).stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        //小顶堆
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        for (int key : count.keySet()) {
            heap.add(key);
            //如果小顶堆大小超过k个，频率最小的出去（小顶堆特性）
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }

    public static List<Integer> topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        //大顶堆
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
        heap.addAll(count.keySet());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(heap.poll());
        }
        return list;
    }
}
