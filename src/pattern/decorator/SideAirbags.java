package pattern.decorator;

// File: SideAirbags.java
class SideAirbags extends Equipment
{
   public SideAirbags(IAuto pIAuto)
   {
      super (pIAuto);
   }
   
   public void showDetails() // "decorates" the details
   {
      auto.showDetails();
      System.out.print(", Side Airbags");
   }
   
   public int getCosts() // "decorates" the costs
   {
      return auto.getCosts() + 1000;
   }
}
