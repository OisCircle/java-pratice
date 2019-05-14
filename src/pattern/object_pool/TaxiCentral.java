package pattern.object_pool;// File: TaxiCentral.java
import java.util.Vector;

public class TaxiCentral 
{
   private int size = 2;  // Unfortunately there are only 2 taxis
   private static TaxiCentral taxiCentral = new TaxiCentral();
   private Vector<Taxi> taxis;
   
   private TaxiCentral()
   {
      taxis = new Vector<Taxi> (size);
      
      for (int i = 1; i <= size; i++) 
         taxis.add (new Taxi (i));
      System.out.println ("New taxi center with " + size 
         + " managed taxis generated.");
   }
   
   public static TaxiCentral getCentral() 
   {
      return taxiCentral;
   }
   
   public synchronized Taxi taxiRequest()
   {
      if (taxis.size() > 0)
      {
         Taxi taxi = taxis.get (0);
         taxis.remove (taxi);
         return taxi;
      }
      // No taxi free
      return null;
   }
   
   public synchronized void taxiSharing (Taxi taxi)
   {
      taxis.add (taxi);
   }
}
