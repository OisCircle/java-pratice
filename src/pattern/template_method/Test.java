package pattern.template_method;

// File: Test.java
// Test class
public class Test
{ 
   public static void main (String args[])
   { 
      System.out.println ("Card to the friends:");
      HolidayCardToFriends card2Friends = 
                        new HolidayCardToFriends();
      card2Friends.mapWrite(); // In doing so, you call a 
                               // rewriting method.
      System.out.println();
      System.out.println ("Card to the company:");
      HolidayCardToCompany card2Firm = new HolidayCardToCompany();
      card2Firm.mapWrite();   // In doing so, you call a
                              // rewriting method.
   }
}