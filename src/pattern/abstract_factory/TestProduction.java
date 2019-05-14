package pattern.abstract_factory;

// File: TestProduction.java
public class TestProduction
{
   static ProductionMachine machine = new ProductionMachine();
   static Box box1 = new Box(5);
   static Box box2 = new Box(3);
   
   public static void main (String[] args)
   {
      machine.setFactory (new ConcreteFactoryM6()); 
      machine.completeBox(box1);
      box1.showContent();

      System.out.println();
      
      machine.setFactory (new ConcreteFactoryM10()); 
      machine.completeBox(box2);      
      box2.showContent();
   }
}
