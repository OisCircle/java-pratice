import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>
 * 样例输入:
 * 6
 * 1 1 2 2 2 2
 * 样例输出:
 * 3      	tip: [1, 1] [2, 2] [2, 2]
 * 样例输入:
 * 5
 * 1 1 1 2 2
 * 样例输出:
 * 0     		tip: [1 1 1] [2 2]
 * <p>
 * 样例输入:
 * 6
 * 1 1 1 2 2 2
 * 样例输出:
 * 2      	tip: [1 1 1] [2 2 2]
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class Main2 {
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int res = in.nextInt();
//		in.nextLine();
//		HashMap<Integer, Integer> map = new HashMap<>(res);
//		String str = in.nextLine();
//		String[] strs = str.split(" ");
//		for (int i = 0; i < res; i++) {
//			map.put(Integer.valueOf(strs[i]), map.getOrDefault(Integer.valueOf(strs[i]), 0) + 1);
//		}
//		res = main(map);
//		System.out.println(String.valueOf(res));

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(2, 4);

		System.out.println(main(map));

		HashMap<Integer, Integer> map2 = new HashMap<>();
		map2.put(1, 3);
		map2.put(2, 2);

		System.out.println(main(map2));

		HashMap<Integer, Integer> map3 = new HashMap<>();
		map3.put(1, 3);
		map3.put(2, 3);

		System.out.println(main(map3));

		HashMap<Integer, Integer> map4 = new HashMap<>();
		map4.put(1, 3);
		map4.put(2, 3);

		System.out.println(main(map4));

		HashMap<Integer, Integer> map5 = new HashMap<>();
		map5.put(1, 3);
		map5.put(2, 3);

		System.out.println(main(map5));
	}

	static int main(HashMap<Integer, Integer> map) {
		int res = 1;
		int minCount = Integer.MAX_VALUE, minColor = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() < minCount) {
				minCount = entry.getValue();
				minColor = entry.getKey();
			}
		}
		if (minCount <= 1) {
			return 0;
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getKey() != minColor) {
				if (entry.getValue() % minCount != 0) {
					return 0;
				} else {
					res += entry.getValue() / minCount;
				}
			}
		}
		return res;
	}
}
