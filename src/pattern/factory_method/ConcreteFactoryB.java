package pattern.factory_method;

// File: ConcreteFactoryB.java
public class ConcreteFactoryB extends Factory
{
   public Product generatingProduct() // Overwriting the factory method
   {
      return new ConcreteProductB();
   }
}
