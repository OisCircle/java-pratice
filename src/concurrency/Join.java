package concurrency;

/**
 * <p>
 * 正常来说主线程会立马结束，控制台停止打印"finished in ..."，但是用了join就是等待他结束，再运行下面的代码
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/7/26
 */
public class Join {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main thread alive : " + Thread.currentThread().isAlive());
		DoThings doThings = new DoThings();
		doThings.start();

		Thread.yield();
		Thread.yield();
		doThings.join();
		System.out.println("main thread alive : " + Thread.currentThread().isAlive());
	}
}

class DoThings extends Thread{
	@Override
	public void run(){
		Long b=0L;
		Long start = System.currentTimeMillis();
		System.out.println("start do ...");
		for (int i = 0; i <= 10000000; ++i) {
			b++;
//			Thread.yield();
		}
		System.out.println("finished in ... "+(System.currentTimeMillis()-start));
	}
}