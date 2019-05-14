package pattern.proxy;

// File: TestProxy.java
public class TestProxy 
{
   public static void main (String[] args) 
   {
      // The proxy object is generated.
      ProxyFileAccess pFile = 
                         new ProxyFileAccess ("TestDatei.dat");
      System.out.println();
      System.out.println("Name: " + pFile.getName()); 
      System.out.println("Content: " + pFile.getContent());
      System.out.println();
      System.out.println("Content: " + pFile.getContent()); 
   }
}
