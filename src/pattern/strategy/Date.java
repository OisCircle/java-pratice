package pattern.strategy;

// File: Date.java
public class Date
{
   private IDateFormat format = null;
   private int day, month, year = 0;
   
   public Date (int day, int month, int year) 
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }
   
   public void setFormat (IDateFormat format) 
   {
      this.format = format;
   }
   
   public void output() 
   {
      // calls the outputDate () method of the object,
      // on the format shows.
      format.dateOutput (day, month, year);
   }
}
