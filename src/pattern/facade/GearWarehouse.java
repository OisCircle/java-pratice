package pattern.facade;

// File: GearWarehouse.java
public class GearWarehouse 
{
   int gearNumber = 0;
   public void stockFill (int number)
   {
      gearNumber = gearNumber + number;
      System.out.println ("Warehouse was around " + number +
                          " Gearbox increased.");
   }
    
   public void removeGear (int number)
   {
      gearNumber = gearNumber - number;
      System.out.println ("For the production were " + number +
                          " removed gearboxes.");
   }
}
