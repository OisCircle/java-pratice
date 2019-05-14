package pattern.object_pool;

// File: Taxi.java
public class Taxi 
{
   private Passenger passenger;
   private int nummer = 0;
   
   public Taxi (int nummer) 
   {
      this.nummer = nummer;
   }
   
   public int getNummer()
   {
      return nummer;
   }

   public void passengerGetOff()
   {
      System.out.println ("From taxi " + this.getNummer() 
         + " is a passenger " + passenger.getName() 
         + " get off.");
      passenger = null;
   }

   public void passengerGetOn (Passenger passenger) 
   {
      this.passenger = passenger;
      
      System.out.println ("In Taxi " + this.getNummer() 
         + " is a passenger " + passenger.getName() 
         + " get in.");
   }
}
