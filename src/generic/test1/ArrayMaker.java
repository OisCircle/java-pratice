package generic.test1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Supplier;

public class ArrayMaker<T> {
    private Class<String> kind;

    public ArrayMaker(Class<String> kind) {
        this.kind = kind;
    }

    String[] create(int size) {
        return (String[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}