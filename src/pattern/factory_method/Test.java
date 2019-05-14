package pattern.factory_method;

// File: Test.java
public class Test
{
   public static void main (String args[])
   {
      Factory factory;
      Product product;

      System.out.println ("Hello");
      
      factory = new ConcreteFactoryA();
      product = factory.generatingProduct();
      product.print();

      factory = new ConcreteFactoryB();
      product = factory.generatingProduct();
      product.print();
   }
}
