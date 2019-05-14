package jvm;

public class Test2 {
	int age = 3;
	public static int height = 100;
	public static final int weight = 50;
	String string = "hello";

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c;
		c = add(a, b);
	}

	public static int add(int num1, int num2) {
		try {
			return num1 + num2;
		} catch (Exception e) {
			return -1;
		}
	}

	class Test3 {
		int a = 1;
		int b = 2;

		public int add() {
			return a + b;
		}
	}
}
