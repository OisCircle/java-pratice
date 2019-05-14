package pattern.factory_method;

// File: ConcreteProductA.java
public class ConcreteProductA extends Product
{
   private String x = "A";
   
   void print()
   {
      System.out.println ("x = " + x);
   }
}
