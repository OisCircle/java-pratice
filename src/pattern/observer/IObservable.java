package pattern.observer;

// File: IObservable.java
public interface IObservable 
{
   public void attach(IObserver observer);
   public void detach(IObserver observer);
   public String getState();
}
