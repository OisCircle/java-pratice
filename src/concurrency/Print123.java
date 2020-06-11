package concurrency;

import java.util.Random;

/**
 * @author O
 * @version 1.0
 * @date 2020/1/7
 */
public class Print123 {

    public static void main(String[] args) {
        Foo o = new Foo();
        Random r = new Random();
        new Thread(() -> {
            System.out.println("before..." + 1);
            try {
                Thread.sleep(r.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        new Thread(() -> {
            System.out.println("before..." + 2);
            try {
                Thread.sleep(r.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
        }).start();

        new Thread(() -> {
            System.out.println("before..." + 3);
            try {
                Thread.sleep(r.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3);
        }).start();


    }
}

class Foo {
    void print1() {
        System.out.println(1);
    }

    void print2() {
        System.out.println(2);
    }

    void print3() {
        System.out.println(3);
    }
}