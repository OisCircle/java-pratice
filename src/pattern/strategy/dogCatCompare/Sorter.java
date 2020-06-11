package pattern.strategy.dogCatCompare;

import java.util.Arrays;

/**
 * @author O
 * @since 2020/6/11
 */
public class Sorter {
    public void sort(IComparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                //选择出最小的数字
                int selected = i;
                if (arr[selected].compareTo(arr[j]) > 0) {
                    selected = j;
                }
                swap(arr, selected, i);
            }
        }
    }

    private void swap(IComparable[] arr, int a, int b) {
        IComparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
