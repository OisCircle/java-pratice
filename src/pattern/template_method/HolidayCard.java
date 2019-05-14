package pattern.template_method;

// File: HolidayCard.java
abstract public class HolidayCard
{ 
   final public void mapWrite() // template method
   {
      writeText();
      additionalLetter(); // abstract method is called
   } 
     
   private void writeText() // output normal text
   {  
      System.out.println (
          "I arrived well at my holiday destination.");
      System.out.println (
          "The food tastes good and the area pleases me.");
      
   } 
   
   abstract protected void additionalLetter(); // insertion method
}
