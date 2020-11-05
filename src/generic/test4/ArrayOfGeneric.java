package generic.test4;

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            gia = (Generic<Integer>[]) new Object[SIZE];
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        // Runtime type is the raw (erased) type:
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
        System.out.println(gia[0].getClass().getSimpleName());
//        gia[1] = (Generic<Integer>) new Object(); // Compile-time error
        // Discovers type mismatch at compile time:
//         gia[2] = new Generic<>();
    }
}