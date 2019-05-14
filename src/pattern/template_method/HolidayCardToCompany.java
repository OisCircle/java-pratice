package pattern.template_method;

// File: HolidayCardToCompany.java
public class HolidayCardToCompany extends HolidayCard
{                                // Another derived class.
   public void additionalLetter() // The abstract method
                                  //  was rewritten.
   {
      System.out.println ("I am looking forward to work again.");
   }
}
