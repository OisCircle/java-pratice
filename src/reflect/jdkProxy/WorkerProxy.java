package reflect.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/5/12
 */
public class WorkerProxy implements InvocationHandler {
	private Object target;

	public WorkerProxy(Object target) {
		this.target = target;
	}

	@SuppressWarnings("unchecked")
	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName() + " start");
		Object result = method.invoke(target, args);
		System.out.println(method.getName() + " done\n");
		return result;
	}

	public static void main(String[] args) {
		//保存生成的代理类的字节码文件
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		//test
		Worker worker = new WorkerProxy(new RealWorker()).getProxy();
		worker.sleep();
		worker.eat();
		worker.work();
	}
}
