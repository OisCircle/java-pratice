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
public class JsonSystemAdapter implements DogAdapter {
	private JsonSystem jsonSystem = new JsonSystem();

	@Override
	public Dog resolveDog() {
		String jsonStr = jsonSystem.saleDog();
		//resolve into dog...
		Dog dog = new Dog();
		dog.setName("json-doggy");
		dog.setAge(2);
		return dog;
	}
}
