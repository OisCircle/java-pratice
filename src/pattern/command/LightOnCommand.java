package pattern.command;

// File: LightOnCommand.java
// This class represents a concrete command class
public class LightOnCommand implements ICommand
{
   private LightSource light;

   public LightOnCommand (LightSource light)
   {
      this.light = light;
   }

   public void execute() //Definition of Method execute()
   {
      light.on();
   }
}
