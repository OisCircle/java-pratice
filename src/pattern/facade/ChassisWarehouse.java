package pattern.facade;

// File: ChassisWarehouse.java
public class ChassisWarehouse 
{
   int chassisNumber = 0;
   
   public void stockFill (int number)
   {
      chassisNumber = chassisNumber + number;
      System.out.println ("Warehouse was around " + number +
                          " chassis increased.");
   }
    
   public void removeChassis (int number)
   {
      chassisNumber = chassisNumber - number;
      System.out.println ("For the production were " + number +
                          " removed chassis.");
   }
}
