package jvm;

import java.io.*;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/18
 */
public class ParentDelegationDestroyTest {
	static class RightClassLoader extends ClassLoader {
		@Override
		public Class<?> findClass(String name) {

			InputStream is = null;
			byte[] data = null;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				is = new FileInputStream(new File("C:\\GitHubRepositories\\Learn-Java\\out\\production\\learn-java\\jvm\\Test.class"));
				int c = 0;
				while (-1 != (c = is.read())) {
					baos.write(c);
				}
				data = baos.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return this.defineClass(name, data, 0, data.length);
		}
	}

	static class WrongClassLoader extends ClassLoader {
		@Override
		public Class<?> loadClass(String name) throws ClassNotFoundException {
			try {
				String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
				System.out.println("fileName: " + fileName);
				System.out.println(this.getClass().getClassLoader());
				InputStream inputStream = this.getClass().getResourceAsStream(fileName);
				if (inputStream == null) {
					return super.loadClass(name);
				}
				byte[] b = new byte[inputStream.available()];
				inputStream.read(b);
				return defineClass(name, b, 0, b.length);
			} catch (Exception e) {
				throw new ClassNotFoundException(name);
			}
		}
	}

	public static void main(String[] args) {
		RightClassLoader loader = new RightClassLoader();
		WrongClassLoader loader1 = new WrongClassLoader();
		Class clazz;
		Class clazz1;
		try {
			clazz = loader.loadClass("jvm.Test");
			Object object = clazz.newInstance();

			clazz1 = loader1.loadClass("jvm.Test");
			Object object1 = clazz1.newInstance();

			System.out.println(object instanceof jvm.Test);
			System.out.println(object1 instanceof jvm.Test);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
