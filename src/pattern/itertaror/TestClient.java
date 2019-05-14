package pattern.itertaror;

// File: TestClient.java
public class TestClient
{ 
   private static StaffArray maListe;

   static
   {
      //Create employee list
      maListe = new StaffArray();

      //Add employees to the list
      maListe.add (new Staff ("Herman", "Hinz", 
                  "MMI-Entwicklung", 3250.00, 1)); 
      maListe.add (new Staff ("Thomas", "Kunz", 
                  "MMI-Entwicklung", 3050.00, 2)); 
      maListe.add (new Staff ("Heinz", "Mueller", 
                  "Unit Tests", 3450.00, 3)); 
      maListe.add (new Staff ("Hans", "Maier", 
                  "Unit Tests", 3400.00, 4)); 
      maListe.add (new Staff ("Max", "Muster", 
                  "Unit Tests", 3500.00, 5)); 
      maListe.add (new Staff ("Peter", "Schmidt", 
                  "Requirements Engineering", 3700.00, 6)); 
   }

   public static void main(String[] args)
   {
      //Bring iterator and go through list
      IIterator iter = maListe.getIterator();

      while (iter.hasNext())
      {
         Staff elem = iter.next();
         elem.print();
      }
   }
}
