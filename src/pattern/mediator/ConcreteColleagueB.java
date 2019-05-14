package pattern.mediator;

// File: ConcreteColleagueB.java
public class ConcreteColleagueB extends Colleague 
{
   // Constructor
   public ConcreteColleagueB (Mediator v) 
   {
      super (v);
      System.out.println ("ConcreteColleagueB: instantiated");
   }

   // Called when another colleague changes
   public void methodB()
   {
      System.out.println 
         ("Concrete colleague is changed to methodB()" + 
          " as a result of the change of a colleague");
   }

   // Set new status
   public void changeState()
   {
      System.out.println
         ("ConcreteCollegeB has been modified by calling " + 
          " the method changeState(). ConcreteCollegeB informs the mediator.");
      super.changeState(); // informs intermediaries
   }
}
