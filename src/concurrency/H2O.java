package concurrency;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
 * <p>
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * <p>
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * <p>
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * <p>
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * <p>
 * 换句话说:
 * <p>
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。 书写满足这些限制条件的氢、氧线程同步代码。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: water = "HOH" 输出: "HHO" 解释: "HOH" 和 "OHH" 依然都是有效解。 示例 2:
 * <p>
 * 输入: water = "OOHHHH" 输出: "HHOHHO" 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/building-h2o 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class H2O {

	AtomicInteger count = new AtomicInteger(0);

	private BlockingQueue<Integer> hQueue = new LinkedBlockingDeque<>(2);
	private BlockingQueue<Integer> oQueue = new LinkedBlockingDeque<>(1);

	public H2O() {

	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hQueue.put(1);
		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
		releaseHydrogen.run();
		if (count.incrementAndGet() == 3) {
			count.set(0);
			hQueue.clear();
			oQueue.clear();
		}
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		//注意这里put方法才会阻塞
		oQueue.put(1);
		// releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		if (count.incrementAndGet() == 3) {
			//set0 操作必须放在前面，不然先释放再set 0 会导致重复设置
			count.set(0);
			hQueue.clear();
			oQueue.clear();
		}
	}
}