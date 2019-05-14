package pattern.decorator;

// File: Convertible.java
class Convertible implements IAuto
{
   public void showDetails()
   {
      System.out.print ("Convertible");
   }

   public int getCosts()
   {
      return 50000;
   }
}
