package pattern.composite;// File: Node.java
import java.util.ArrayList;
public abstract class Node
{
   private String name = "";
   static int level = 0;          // Counter for output level
   
   public Node (String name)
   {
      this.name = name;
   }

   public abstract void operation();
  
   public String getName()
   {
      return this.name;
   }
}
