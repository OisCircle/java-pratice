package pattern.observer;
// File: Newsletter.java
import java.util.Vector;

public class Newsletter implements IObservable 
{
   private Vector<IObserver> subscribers = new Vector<IObserver>();

   private String message;

   public void anotherMessage (String newMessage)
   {
      message = newMessage;
      Notify();
   }

   public void detach (IObserver observer) 
   {
      subscribers.remove (observer);
   }

   public void attach (IObserver observer) 
   {
      subscribers.add (observer);
   }

   private void Notify() 
   {
      for (IObserver observer : subscribers)    	  
      {
         observer.upDate (this);
      }
   }
   public String getState() 
   {
      return message;
   }
}
