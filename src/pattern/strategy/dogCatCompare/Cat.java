package pattern.strategy.dogCatCompare;

/**
 * @author O
 * @since 2020/6/11
 */
public class Cat implements IComparable<Cat> {
    private int weight;

    public Cat(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Cat cat) {
        if (weight > cat.weight) {
            return 1;
        } else if (weight == cat.weight) {
            return 0;
        } else {
            return -1;
        }
    }
}
