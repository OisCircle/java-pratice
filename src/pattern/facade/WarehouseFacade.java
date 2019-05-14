package pattern.facade;

// File: WarehouseFacade.java
public class WarehouseFacade 
{    
   private ChassisWarehouse fw;
   private GearWarehouse g;
   private EngineWarehouse m;
   
   WarehouseFacade()
   {
      fw = new ChassisWarehouse();
      g = new GearWarehouse();
      m = new EngineWarehouse();
   }
   
   public void fillAllStocks (int number)
   {
      System.out.println ("Stocks of all warehouses are filled.");
      fw.stockFill (number);
      g.stockFill (number);
      m.stockFill(number);
      System.out.println();
   }
   
   public void productionPartsRemoval (int number)
   {
      System.out.println ("All of the production " +
                          "necessary parts are removed.");
      fw.removeChassis (number);
      g.removeGear (number);
      m.removeEngine (number);
      System.out.println();
   }
}
