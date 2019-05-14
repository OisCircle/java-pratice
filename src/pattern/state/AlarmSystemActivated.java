package pattern.state;

// File: AlarmSystemActivated.java
// Describes the behavior of the alarm system in the state 
// AlarmSystemActivated
public class AlarmSystemActivated implements IStateAlarmSystem 
{
   // If a person has been detected, give an audible signal. 
   public void personRecognized()
   {
      System.out.println ("RING RING");
   }
}
