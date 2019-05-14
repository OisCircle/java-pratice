package pattern.singleton;

// File: ToolTipManager2.java
final public class ToolTipManager2
{
   private static ToolTipManager2 instance = new ToolTipManager2();

   private ToolTipManager2() 
   {
      System.out.println ("ToolTipManager2 generated.");
   }

   public static ToolTipManager2 getInstance() 
   {
     System.out.println ("ToolTipManager2::getInstance()");
     return instance;
   }

   public void operation() 
   {
      // actual functionality of the singleton
      System.out.println ("operation() called.");
   }
}
