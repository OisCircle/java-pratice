package pattern.bridge;

// File: CassettePlayer.java
// Concrete implementer
public class CassettePlayer implements IPlayerImplementer 
{
   private int currentTrack;

   public CassettePlayer()
   {
      System.out.println("Coil at the beginning back.");
      currentTrack = 1;
   }

   public void jump2Track (int songNummer)
   {
      int diff = songNummer - currentTrack;

      if (diff > 0 ) 
      {
         System.out.println ("Coil around " + diff + 
                             " Tracks ahead.");
      } 
      else 
      { 
         System.out.println ("Coil around " + (Math.abs (diff)+1) + 
                             " Tracks back.");
      }
      
      System.out.println ("Now we are at the right place " + 
                          "Place (song: " + songNummer + ")");
      currentTrack = songNummer;
   }

   public PlayData readData()
   {
      return new PlayData ("Cassette data");		
   }

   public void turnOff()
   {
      System.out.println ("Cassette player switched off.");
   }
}
