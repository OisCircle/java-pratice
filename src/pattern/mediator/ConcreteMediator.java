package pattern.mediator;

// File: ConcreteMediator.java
public class ConcreteMediator extends Mediator
{
   // Instance variables
   private ConcreteColleagueA colleagueA;
   private ConcreteColleagueB colleagueB;

   // Constructor
   public ConcreteMediator() 
   {
      System.out.println("ConcreteMediator: instantiated");
   }

   // In case of changes, the changed colleague calls these Broker Method.
   public void changeOccurred (Colleague k)
   {
      if (k == (Colleague)colleagueA)
      {
         System.out.println
            ("ConcreteMediator: inform colleagueB");
         colleagueB.methodB();
      }
      else if (k == (Colleague)colleagueB) 
      {
         System.out.println
            ("ConcreteMediator: inform colleagueA");
         colleagueA.methodA();
      }
   }
	
   //Set methods for colleagues
   public void setColleagueA (ConcreteColleagueA kka)
   {
      colleagueA = kka;
   }

   public void setColleagueB (ConcreteColleagueB kkb)
   {
      colleagueB = kkb;
   }
}
