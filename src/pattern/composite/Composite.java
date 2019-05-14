package pattern.composite;// File: Composite.java
import java.util.ArrayList;
import java.util.Iterator;
public class Composite extends Node
{
   ArrayList<Node> childElements = new ArrayList<Node>();
   public Composite (String name)
   {
      super (name);
   }
   
   
   public void add (Node comp)
   {
      this.childElements.add (comp);
   }
   
   public void remove (Node comp)
   {
      //go through all child elements
      for (Iterator<Node> iter = childElements.iterator();
            iter.hasNext();)
      {
         Node f = (Node) iter.next();
         if (f instanceof Composite)
         {
            ((Composite) f).remove (comp);
         }
      }
      childElements.remove (comp);
   }

   public void operation()
   {
      String formatString;
      // Calculate the new output level
      level++;
      // Compute the format string for the output of
      // Spaces according to the reached level
      formatString = "%" + (level * 2) + "s";
      // Output of the spaces
      System.out.printf (formatString, "");
      // Output of a plus sign followed by the name of the component
      System.out.println ("+ " + super.getName() + "");
      // Calling the operation for all child elements
      for (Iterator<Node> iter = childElements.iterator();
            iter.hasNext();)
      {
         Node f = (Node) (iter.next());
         f.operation();
      }
      // Reset output level
      --level;
   }
}
