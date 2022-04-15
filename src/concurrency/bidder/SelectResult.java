package concurrency.bidder;

/**
 * @author qiuchengquan
 * @since 2022/3/27
 */
public class SelectResult {

	public SelectResult(Long curPrice) {
		this.curPrice = curPrice;
	}

	private Long curPrice;
	private Joiner lastJoiner;
	private Joiner joiner;

	public Joiner getLastJoiner() {
		return lastJoiner;
	}

	public void setLastJoiner(Joiner lastJoiner) {
		this.lastJoiner = lastJoiner;
	}

	public Joiner getJoiner() {
		return joiner;
	}

	public void setJoiner(Joiner joiner) {
		this.joiner = joiner;
	}

	public Long getCurPrice() {
		return curPrice;
	}

	public void setCurPrice(Long curPrice) {
		this.curPrice = curPrice;
	}
}
