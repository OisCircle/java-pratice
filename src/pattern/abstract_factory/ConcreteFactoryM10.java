package pattern.abstract_factory;

// File: ConcreteFactoryM10.java
public class ConcreteFactoryM10 implements IAbstractFactory 
{ 
   public IScrew produceScrew()
   { 
      return new ScrewM10(); 
   } 

   public INut produceNut() 
   { 
      return new NutM10(); 
   } 
}
