package pattern.decorator;

// File: AirConditioner.java
class AirConditioner extends Equipment
{
   public AirConditioner(IAuto pIAuto) 
   {
      super(pIAuto);
   }
   
   public void showDetails() // "decorates" the details
   {
      auto.showDetails();
      System.out.print (", Air Conditioner");
   }
    
   public int getCosts() // "decorates" the costs
   {
      return auto.getCosts() + 1500;
   }
}
