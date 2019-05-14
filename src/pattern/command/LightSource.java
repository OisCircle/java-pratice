package pattern.command;

// File: LightSource.java
// Light Source is a receiver class with two actions
public class LightSource 
{
   public void on()
   {
      System.out.println ("Light was switched on!");
   }

   public void off()
   {
      System.out.println ("Light was switched off!");
   }
}
