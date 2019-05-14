package pattern.composite;

// File: Leaf.java
public class Leaf extends Node
{
   public Leaf (String name)
   {
      super (name);
   }
   
   public void operation()
   {
      String formatString;
      // Compute the format string for the output of
      // spaces according to the reached level
      formatString = "%" + (level * 2) + "s";
      // Output of the spaces
      System.out.printf (formatString, "");
      // Output of a minus sign followed by the name of the node
      System.out.println (" - " + super.getName());
   }
}
