package pattern.command;

// File: LightSwitch.java
// Light switch is a caller class and stores a command
public class LightSwitch 
{
   private ICommand command; // Reference to command

   public void saveCommand (ICommand command)
   {
      this.command = command;
   }

   public void activate()
   {
      command.execute();
   }
}
