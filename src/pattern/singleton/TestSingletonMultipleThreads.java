package pattern.singleton;

// File: TestSingletonMultipleThreads.java
public class TestSingletonMultipleThreads 
{
   public static void main (String[] args) 
   {
      SingletonTestThread s1 = new SingletonTestThread ("Thread 1");
      SingletonTestThread s2 = new SingletonTestThread ("Thread 2");
      SingletonTestThread s3 = new SingletonTestThread ("Thread 3");
        
      s1.start();
      s2.start();
      s3.start();
   }
}
