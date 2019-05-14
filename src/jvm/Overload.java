package jvm;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/16
 */
public class Overload {
	public static void type(Object arg) {
		System.out.println("object");
	}
	public static void type(char arg) {
		System.out.println("char");
	}
	public static void type(int arg) {
		System.out.println("int");
	}
	public static void type(long arg) {
		System.out.println("long");
	}
	public static void type(float arg) {
		System.out.println("float");
	}
	public static void type(double arg) {
		System.out.println("double");
	}
	public static void type(char... arg) {
		System.out.println("char...");
	}
	public static void type(Character arg) {
		System.out.println("Character");
	}
	public static void type(Serializable arg) {
		System.out.println("Serializable");
	}

	public static void main(String[] args) {
		type('a');
	}
}
