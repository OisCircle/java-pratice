import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "111");
		map.put(2, "222");
		map.put(3, "333");

		Set<Map.Entry<Integer, String>> entries = map.entrySet();
		for (Map.Entry<Integer, String> e : entries) {
			System.out.println(e.getValue());
			System.out.println();
		}
	}
}