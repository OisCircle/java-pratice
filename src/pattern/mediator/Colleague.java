package pattern.mediator;

// File: Colleague.java
public abstract class Colleague
{
   // instance variable
   private Mediator mediator; // Reference to the intermediary

   // Constructor
   public Colleague (Mediator v)
   {
      mediator = v;
   }

   // Will be overridden by the deriving classes
   public void changeState()
   {
      mediator.changeOccurred (this); // Brokers informed
   }
}
