package concurrency.bidder;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


/**
 * 主持人
 *
 * @author qiuchengquan
 * @since 2022/3/27
 */
public class Host {

	//通知，选择一个人
	public Joiner next(List<Joiner> joinerList, SelectResult selectResult) {
		AtomicReference<Joiner> flag = new AtomicReference<>(null);

		joinerList = joinerList.stream()
			//上次举牌的人不允许再次举牌
			.filter(joiner -> selectResult.getJoiner() == null
			                  || !selectResult.getJoiner().getId().equals(joiner.getId()))
			.collect(Collectors.toList());

		CountDownLatch waiter = new CountDownLatch(joinerList.size());
		joinerList.parallelStream()
			//并发通知举牌
			.forEach(joiner -> {
				joiner.raise(flag);
				waiter.countDown();
			});

		try {
			waiter.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return flag.get();
	}
}
