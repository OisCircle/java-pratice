package pattern.strategy.dogCatCompare;

/**
 * @author O
 * @since 2020/6/11
 */
public class Dog implements IComparable<Dog> {
    private int age;

    public Dog(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Dog dog) {
        if (age > dog.age) {
            return 1;
        } else if (age == dog.age) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(age);
    }
}
