import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

/**
 * @author O
 * @version 1.0
 * @date 2019/8/27
 */
public class Main {
    private static volatile int a=1;
    public static void main(String[] args) throws Exception {
        CompletableFuture.runAsync(()->{
            while (true) {
                if (a == 1) {
                    System.out.println("a = 1");
                } else {
                    System.out.println("a = 2");
                    break;
                }
            }
        });
        Thread.sleep(100L);
        a=2;
    }
}
