package pattern.bridge;

// File: Player.java
// Abstraction
public class Player
{
   protected IPlayerImplementer impl;

   public Player (IPlayerImplementer impl)
   {
      this.impl = impl;
   }

   public void playOff (int songNumber) 
   {
      impl.jump2Track (songNumber);
      PlayData dat = impl.readData();		
      // Output data
      System.out.println (dat);
   }

   public void turnOff()
   {
      impl.turnOff();
   }
}

