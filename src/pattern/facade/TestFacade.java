package pattern.facade;

// File: TestFacade.java
public class TestFacade 
{
   public static void main (String[] args) 
   {
      WarehouseFacade facade = new WarehouseFacade();
      
      // Warehouses are filled by warehouse management.
      facade.fillAllStocks(10);
      
      // Parts are removed through production.
      facade.productionPartsRemoval(5);
   }
}
