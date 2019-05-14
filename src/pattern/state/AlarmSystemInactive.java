package pattern.state;

// File: AlarmSystemInactive.java
// Describes the behavior of the alarm system in the state 
// AlarmSystemInactive
public class AlarmSystemInactive implements IStateAlarmSystem 
{
   // If a person has been detected, NO beep spend, 
   //as this would be disturbing in normal business operations.
   public void personRecognized()
   {
      System.out.println ("Stay calm.");
   }
}
