package concurrency.bidder;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 参与竞拍的人
 *
 * @author qiuchengquan
 * @since 2022/3/27
 */
public class Joiner {

	private SelectResult selectResult;

	//举牌
	public void raise(AtomicReference<Joiner> flag) {
		if (id <= 2) {
			try {
				Thread.sleep(50L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//给不起价格，不参与竞拍
		if (this.price <= selectResult.getCurPrice()) {
			System.out.println(id + " 金额超出预期 放弃竞拍");
			return;
		}
		//CAS争取设置自己为举牌人
		flag.compareAndSet(null, this);
	}

	public Joiner(Long id, Long price, SelectResult selectResult) {
		this.selectResult = selectResult;
		this.id = id;
		this.price = price;
	}

	boolean tryLock(ReentrantLock lock) {
		return lock.tryLock();
	}

	private Long id;
	//心理预期的出价
	private Long price;

	public Long getId() {
		return id;
	}


	public Long getPrice(SelectResult selectResult) {
		return Math.min(price, selectResult.getCurPrice() + 1);
	}
}
