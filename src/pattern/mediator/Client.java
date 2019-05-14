package pattern.mediator;

// File: Client.java
public class Client
{
   public static void main (String[] args)
   {
      // initialization
      System.out.println ("initialization:");
      ConcreteMediator ConcreteMediator =
         new ConcreteMediator();
      ConcreteColleagueA colleagueA = new 
         ConcreteColleagueA (ConcreteMediator);
      ConcreteMediator.setColleagueA (colleagueA);
      ConcreteColleagueB colleagueB = new 
         ConcreteColleagueB (ConcreteMediator);
      ConcreteMediator.setColleagueB(colleagueB);

      // Change colleagueA
      System.out.println ("\nChange colleagueA:");
      colleagueA.changeState();

      // Change colleaguesB
      System.out.println ("\nChange colleagueB:");
      colleagueB.changeState();
   }
}
