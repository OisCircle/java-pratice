package pattern.state;

// File: AlarmSystem.java
// Context over which the alarm system is controlled 
public class AlarmSystem 
{
   IStateAlarmSystem active = new AlarmSystemActivated();
   IStateAlarmSystem inactive = new AlarmSystemInactive();
   IStateAlarmSystem state = null;         
   
   public AlarmSystem()
   {       
      state = inactive; // starting state      
   }
   
   public void turnOn()
   {
      setState(active);    
   }

   public void turnOff()
   {
      setState(inactive);    
   }   
   
   public void personRecognized()
   {
      state.personRecognized();
   }

   private void setState (IStateAlarmSystem newState)
   {
      state = newState;
   }
}
