package jvm;

public class NotInitialization {
	public static void main(String[] args) {
		System.out.println(PassiveRef.HELLOWORLD);

		print();
		PassiveRef[] refs=new PassiveRef[10];
	}

	static void print() {
		System.out.println(PassiveRef.HELLOWORLD);
	}
}