package pattern.strategy.dogCatCompare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author O
 * @since 2020/6/11
 */
public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1));
        dogs.add(new Dog(3));
        dogs.add(new Dog(2));
        System.out.println(dogs);
        Dog[] arr = new Dog[3];
        arr[0] = dogs.get(0);
        arr[1] = dogs.get(1);
        arr[2] = dogs.get(2);
        sorter.sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
