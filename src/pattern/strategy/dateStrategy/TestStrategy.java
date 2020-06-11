package pattern.strategy.dateStrategy;

// File: TestStrategy.java
public class TestStrategy 
{
   public static void main (String[] args)
   {
      Date date = new Date (21, 9, 1985);
     
      date.setFormat(new EuropeanFormat());
      date.output();
      
      date.setFormat (new AmericanFormat());
      date.output();
   }
}
