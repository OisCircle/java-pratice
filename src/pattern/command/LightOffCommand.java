package pattern.command;

// This class represents a concrete command class
public class LightOffCommand implements ICommand
{
   private LightSource light;

   public LightOffCommand (LightSource light)
   {
      this.light = light;
   }

   public void execute() //Definition of Method execute()
   {
	   light.off();
   }
}
