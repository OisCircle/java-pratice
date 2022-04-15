package concurrency.bidder;

import java.util.Arrays;
import java.util.List;

/**
 * 这天面的一道面试题，模拟竞选，拍卖物品，每个人举牌，说出自己的价格
 *
 * 关键点第一是，用乐观锁，模拟并发举牌
 *
 * 第二点，用CountDownLatch来等待所有人举牌动作结束
 *
 * @author qiuchengquan
 * @since 2022/3/27
 */
public class BidderMain {

	public static void main(String[] args) throws InterruptedException {
		//竞选结果，每个人都需要感知当前价格和上次的竞选人是谁
		SelectResult selectResult = new SelectResult(0L);

		Joiner joiner1 = new Joiner(1L, 1L, selectResult);
		Joiner joiner2 = new Joiner(2L, 2L, selectResult);
		Joiner joiner3 = new Joiner(3L, 3L, selectResult);

		Host host = new Host();
		List<Joiner> joinerList = Arrays.asList(joiner1, joiner2, joiner3);

		while (true) {
			//开始竞选
			Joiner raiser = host.next(joinerList, selectResult);

			if (raiser == null) {
				System.out.println("无人举牌");
			}

			//竞选结束，没有人报价，结束
			if (raiser == null) {
				break;
			}

			selectResult.setJoiner(raiser);

			Long price = raiser.getPrice(selectResult);
			if (raiser != null) {
				System.out.println(raiser.getId() + "举牌 报价 " + price);
			}

			selectResult.setCurPrice(price);

			Thread.sleep(3000L);
		}

		System.out.println(String.format("竞选结束 最终 竞选人：%s 出价：%s", selectResult.getJoiner().getId(), selectResult.getCurPrice()));
	}

}
