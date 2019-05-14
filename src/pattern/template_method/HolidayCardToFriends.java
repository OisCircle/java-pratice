package pattern.template_method;

// File: HolidayCardToFriends.java
public class HolidayCardToFriends extends HolidayCard
{                                // A derived class that 
   public void additionalLetter() // overrides the abstract method. 
   {
      System.out.println ("I do a lot of sports.");
   }
}
