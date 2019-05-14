package pattern.decorator;

// File: Limousine.java
class Limousine implements IAuto
{
   public void showDetails()
   {
       System.out.print ("Limousine");
   }
   public int getCosts()
   {
      return 35000;
   }
}
