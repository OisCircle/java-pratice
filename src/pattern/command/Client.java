package pattern.command;

// File: Client.java
public class Client 
{
   public static void main (String[] args)
   {
      LightSwitch aSwitch = new LightSwitch();
      LightSource aLight = new LightSource();
   
      ICommand lightOn = new LightOnCommand (aLight);
      ICommand lightOff = new LightOffCommand (aLight);
   
      aSwitch.saveCommand (lightOn);
      aSwitch.activate();
      
      aSwitch.saveCommand (lightOff);
      aSwitch.activate();
   }
}
