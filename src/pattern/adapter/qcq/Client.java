package pattern.adapter.qcq;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/11/24
 */
public class Client {
	public static void main(String[] args) {
		DogAdapter dogAdapter =new XmlSystemAdapter();
		Dog xmlDog = dogAdapter.resolveDog();

		System.out.println(xmlDog);

		dogAdapter = new JsonSystemAdapter();
		Dog jsonDog = dogAdapter.resolveDog();
		System.out.println(jsonDog);
	}
}
