package pattern.strategy;

// File: EuropeanFormat.java
public class EuropeanFormat implements IDateFormat
{
   public void dateOutput (int day, int month, int year) 
   {
      System.out.println ("European format: " 
            + (day > 9 ? day : "0" + day) 
            + "." 
            + (month > 9 ? month : "0" + month) 
            + "." 
            + year);
   }
}
