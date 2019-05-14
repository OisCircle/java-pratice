package algorithm.array;

/**
 * <p>
 * 先扫描空格个数，再创建新数组，java不像c++可以从后面继续申请空间。所以只能创建新数组来实现O（n）时间复杂度和空间复杂度
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/13
 */
public class ReplaceBlankTest {
	public static void main(String[] args) {
		char[] arr1 = new char[]{'a', 'b', 'c', ' ', 'd', 'e', ' '};
		char[] arr2 = new char[]{' ', 'b', 'c', ' ', 'd', 'e', ' '};
		char[] arr3 = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' '};
		char[] arr4 = new char[]{'a', 'b', 'c', 'd', 'd', 'e', 'f'};
		char[] arr5 = new char[]{' ', 'a'};
		char[] arr6 = null;

		System.out.println(replaceBlank(arr1));
		System.out.println(replaceBlank(arr2));
		System.out.println(replaceBlank(arr3));
		System.out.println(replaceBlank(arr4));
		System.out.println(replaceBlank(arr5));
		System.out.println(replaceBlank(arr6) == null);
	}

	static char[] replaceBlank(char[] arr) {
		if (arr == null) {
			return null;
		}
		char[] result = null;
		int count = 0;
		int arrIndex = 0;
		int resultIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			count += arr[i] == ' ' ? 1 : 0;
		}
		result = new char[arr.length + count];

		while (arrIndex != arr.length) {
			if (arr[arrIndex] != ' ') {
				result[resultIndex] = arr[arrIndex];
			} else {
				//这里已经加了一次
				result[resultIndex++] = '&';
				result[resultIndex] = '&';
			}
			resultIndex++;
			arrIndex++;
		}
		return result;
	}

}
