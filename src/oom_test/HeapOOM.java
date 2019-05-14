package oom_test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 堆区域的oom异常
 * 运行前要先设置低vm参数
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/2
 */
public class HeapOOM {
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		while (true) {
			list.add(new OOMObject());
			System.out.println("add...");
		}
	}
}

class OOMObject {
	List<String> strings = new ArrayList<>();
}
