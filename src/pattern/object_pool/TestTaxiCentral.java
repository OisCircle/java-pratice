package pattern.object_pool;

// File: TestTaxiCentral.java
public class TestTaxiCentral 
{
   public static void main (String[] args)
   {
      TaxiCentral taxiCentral = TaxiCentral.getCentral();
      
      Passenger hans = new Passenger ("Hans");
      Passenger anna = new Passenger ("Anna");
      Passenger klaus = new Passenger ("Klaus");
      
      hans.taxiEntered (taxiCentral);
      anna.taxiEntered (taxiCentral);
      klaus.taxiEntered (taxiCentral);
      
      hans.taxiLeave (taxiCentral);
      klaus.taxiEntered (taxiCentral);

      anna.taxiLeave (taxiCentral);
      klaus.taxiLeave (taxiCentral);
   }
}
