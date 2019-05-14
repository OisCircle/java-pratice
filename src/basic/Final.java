package basic;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/7/31
 */
public class Final {
	public static final int a = 0;

	public static final Integer integer = 0;

	public static final Apple APPLE=new Apple();
	public static void main(String[] args) {
		APPLE.setWeight(2);
		System.out.println(APPLE.getWeight());
	}
}

class Apple {
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	private int weight;
}