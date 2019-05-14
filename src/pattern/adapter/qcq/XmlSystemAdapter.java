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
public class XmlSystemAdapter implements DogAdapter {
	private XmlSystem xmlSystem = new XmlSystem();

	@Override
	public Dog resolveDog() {
		String xmlStr = xmlSystem.saleDog();
		//resolve into Dog...
		Dog dog = new Dog();
		dog.setName("xml-doggy");
		dog.setAge(1);
		return dog;
	}
}
