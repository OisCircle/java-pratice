package pattern.proxy;

// File: ProxyFileAccess.java
public class ProxyFileAccess implements IFileAccess
{
   String name;
   IFileAccess realFile;
   public ProxyFileAccess(String name)
   {
      this.name = name;
      System.out.println("Instantiated representative object.");
   }

   public String getContent() 
   {
      if(realFile == null)
      {
         System.out.println("Content is not available locally.");
         // The real file object is created.
         realFile = new FileAccess(name);
      }
      return realFile.getContent();
   }

   public String getName() 
   {
      return name;
   }
}
