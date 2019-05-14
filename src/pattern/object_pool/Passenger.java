package pattern.object_pool;

// File: Passenger.java
public class Passenger 
{
   private String name = "";
   private Taxi taxi;

   public Passenger (String name)
   {
      this.name = name;
   }
   
   public String getName()
   {
      return name;
   }
   public void taxiEntered (TaxiCentral taxiCentral)
   {
      taxi = taxiCentral.taxiRequest();
      
      if (taxi == null) // There is no free taxi available
         System.out.println ("For passenger " + this.getName() 
            + " there is no free taxi available.");
      else
         taxi.passengerGetOn (this);
   }

   public void taxiLeave (TaxiCentral taxiZentrale)
   {
      if (taxi != null)
      {
         taxi.passengerGetOff();
         taxiZentrale.taxiSharing (taxi);
      }
   }
}
