package pattern.bridge;

// File: CDSpieler.java
// Concrete implementer
public class CDPlayer implements IPlayerImplementer 
{
   public void jump2Track (int songNummer)
   {
      // Browse contents of the CD ...
      System.out.println ("Search Table of Contents");
      // Jump to the beginning of the song on the CD ...
      System.out.println ("Jump to song " + songNummer +
                          " by positioning the laser.");
   }

   public PlayData readData()
   {
      return new PlayData ("CD-Data");
   }

   public void turnOff()
   {
      System.out.println ("CD player turned off.");
   }
}

