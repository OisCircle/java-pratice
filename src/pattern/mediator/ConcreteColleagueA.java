package pattern.mediator;

// File: ConcreteColleagueA.java
public class ConcreteColleagueA extends Colleague 
{
   // Constructor
   public ConcreteColleagueA (Mediator v) 
   {
      super (v);
      System.out.println ("ConcreteColleagueA: instantiated");
   }

   // Called when another colleague changes
   public void methodA()
   {
      System.out.println 
         ("Concrete colleague is changed to methodA()" +
          "as a result of the change of a colleague");
   }

   // Set new status
   public void changeState()
   {
      System.out.println
         ("ConcreteCollegeA has been modified by calling" + 
          " the method changeState(). ConcreteColleagueA" + 
          " informs the mediator. ");
      super.changeState(); // informs Intermediaries
   }
}
