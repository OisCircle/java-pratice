package pattern.proxy;

// File: FileAccess.java
public class FileAccess implements IFileAccess
{
   String name;

   public FileAccess (String name)
   {
      this.name = name;
      System.out.println ("Instantiated real object.");
   }

   public String getName() 
   {
      return this.name;
   }

   public String getContent() 
   {
      //Simulation of a file read operation
      return ("Data from " + name);
   }
}
