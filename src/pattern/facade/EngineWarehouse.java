package pattern.facade;

// Datei: MotorLager.java
public class EngineWarehouse 
{
   int engineNumber = 0;
    
   public void stockFill (int number)
   {
      engineNumber = engineNumber + number;
      System.out.println ("Warehouse was around " + number +
                          " engines increased.");
   }
    
   public void removeEngine (int number)
   {
      engineNumber = engineNumber - number;
      System.out.println ("For the production were " + number +
                          " engines removed.");
   }
}
