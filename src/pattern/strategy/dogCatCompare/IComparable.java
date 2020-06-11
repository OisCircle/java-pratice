package pattern.strategy.dogCatCompare;

/**
 * 使用泛型T，避免类型强制转换出错
 */
public interface IComparable<T> {
    int compareTo(T t);
}
