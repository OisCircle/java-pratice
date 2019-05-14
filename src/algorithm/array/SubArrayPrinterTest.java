package algorithm.array;

/**
 * <p>
 * 打印所有子串
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/21
 */
public class SubArrayPrinterTest {
	public static void main(String[] args) {
		String str = "abcd";
		printAllSub0(str.toCharArray(), 0, "");
	}

	/**
	 * 从位置0开始，有两种决策1、要；2、不要
	 * 向后走，每个位置同样两种决策，递归
	 */
	static void printAllSub(char[] str, int i, String res) {
		if (i == str.length) {
			System.out.println(res);
		} else {
			//不要下标为i+1的字符
			printAllSub(str, i + 1, res);
			//要第i+1个字符
			printAllSub(str, i + 1, res + str[i]);
		}
	}

	static void printAllSub0(char[] arr, int index, String result) {
		if (index == arr.length) {
			System.out.println(result);
		} else {
			//选择i
			printAllSub0(arr, index + 1, result + arr[index]);
			//不选择i
			printAllSub0(arr, index + 1, result);
		}
	}
}
