package pattern.observer;

// File: Subscriber.java
public class Subscriber implements IObserver
{
   private String name;

   public Subscriber (String name)
   {
      this.name = name;
   }

   public void upDate (IObservable b) 
   {
      System.out.println ("New message for " + name + ".");
      System.out.println ("Message: " + b.getState());
   }
}
