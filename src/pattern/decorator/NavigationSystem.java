package pattern.decorator;

// File: NavigationSystem.java
class NavigationSystem extends Equipment
{
   public NavigationSystem (IAuto pIAuto)
   {
      super (pIAuto);
   }

   public void showDetails() // "decorates" the details
   {
      auto.showDetails();
      System.out.print (", Navigation System");
   }

   public int getCosts() // "decorates" the costs
   {
      return auto.getCosts() + 2500;
   }
}
