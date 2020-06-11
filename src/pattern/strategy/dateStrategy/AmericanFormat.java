package pattern.strategy.dateStrategy;

// File: AmericanFormat.java
public class AmericanFormat implements IDateFormat
{
   public void dateOutput (int day, int month, int year) 
   {
      System.out.println ("American Format: " 
            + (month > 9 ? month : "0" + month) 
            + "/" 
            + (day > 9 ? day : "0" + day) 
            + "/" 
            + year);
   }
}
