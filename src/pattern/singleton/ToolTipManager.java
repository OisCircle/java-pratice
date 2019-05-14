package pattern.singleton;

// File: ToolTipManager.java
final class ToolTipManager
{
   private static ToolTipManager instance; 

   private ToolTipManager() 
   {
      System.out.println ("New singleton generated.");
   }

   public static ToolTipManager getInstance()
   {
      if (instance == null) 
      {
         instance = new ToolTipManager();         
      }
      return instance;
   }

   public void operation()
   {
      // actual functionality of the singleton
      System.out.println ("operation() called.");
   }
}
