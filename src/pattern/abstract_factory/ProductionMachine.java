package pattern.abstract_factory;

public class ProductionMachine
{ 
   private IAbstractFactory factory = null; 

   public void setFactory (IAbstractFactory factory)
   { 
       this.factory = factory; 
   } 

   public void completeBox(Box box) 
   { 
      int i;

      for (i = 0; i <= box.getNubmer(); i++)
      { 
         box.putScrewIn(factory.produceScrew());
         box.putNutIn(factory.produceNut());
      }
   }
}
