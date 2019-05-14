package pattern.factory_method;

// File: ConcreteFactoryA.java
public class ConcreteFactoryA extends Factory
{
   public Product generatingProduct() // Overwriting the factory method
   {
      return new ConcreteProductA();
   }
}
