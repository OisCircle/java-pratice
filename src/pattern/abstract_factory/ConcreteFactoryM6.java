package pattern.abstract_factory;

// File: ConcreteFactoryM6.java
public class ConcreteFactoryM6 implements IAbstractFactory 
{ 
   public IScrew produceScrew()
   { 
      return new ScrewM6(); 
   } 

   public INut produceNut() 
   { 
      return new NutM6(); 
   } 
}
