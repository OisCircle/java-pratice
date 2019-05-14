package pattern.factory_method;

// File: ConcreteProductB.java
public class ConcreteProductB extends Product
{
   private String x = "B";

   void print()
   {
      System.out.println ("x = " + x);
   }
}
