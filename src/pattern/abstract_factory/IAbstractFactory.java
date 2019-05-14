package pattern.abstract_factory;

// File: IAbstractFactory.java
// IAbstractFactory has two methods. Each generates 
// an instance of a product (IMutter and ISchraube). 
public interface IAbstractFactory 
{ 
   public IScrew produceScrew(); 
   public INut produceNut(); 
}
