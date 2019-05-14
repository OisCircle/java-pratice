package algorithm.greedy;

import java.util.Arrays;

/**
 * <p>
 * Dijkstra算法：单源最短路径
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/5/3
 */
public class Dijkstra {
	private static final int UNREACHED = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int n = 5;
		//源点
		int src = 0;
		//邻接矩阵，UNREACHED代表不可达
		int[][] map = new int[][]{
				{UNREACHED, 2, 5, UNREACHED, UNREACHED},
				{UNREACHED, UNREACHED, 2, 6, UNREACHED},
				{UNREACHED, UNREACHED, UNREACHED, 7, 1},
				{UNREACHED, UNREACHED, 2, UNREACHED, 4},
				{UNREACHED, UNREACHED, UNREACHED, UNREACHED, UNREACHED}
		};
		//前驱，用来跟踪路径
		int[] pre = new int[n];
		//标志位，记录某城市已经被计算过最短路径
		boolean[] flag = new boolean[n];
		//最短路径
		int[] dist = new int[n];

		//1.初始化源点到各点的最短路径
		for (int i = 0; i < n; i++) {
			dist[i] = map[src][i];
			if (dist[i] == UNREACHED) {
				pre[i] = UNREACHED;
			} else {
				pre[i] = src;
			}
		}
		//自己到自己为0
		dist[src] = 0;
		//源点被访问
		flag[src] = true;
		//2.
		for (int i = 1; i < n; i++) {
			//在集合中寻找距离源点source最近的顶点t
			int temp = Integer.MAX_VALUE;
			int t = src;
			for (int j = 0; j < n; j++) {
				if (!flag[j] && dist[j] < temp) {
					t = j;
					temp = dist[j];
				}
			}
			if (t == src) {
				System.out.println("can't find...");
				return;
			}
			flag[t] = true;
			//更新与t邻接的顶点到源点src的距离
			for (int j = 0; j < n; j++) {
				if (!flag[j] && map[t][j] != UNREACHED) {
					if (dist[t] + map[t][j] < dist[j]) {
						dist[j] = dist[t] + map[t][j];
						pre[j] = t;
					}
				}
			}
		}
		System.out.println(Arrays.toString(pre));
		System.out.println(Arrays.toString(dist));
	}
}
