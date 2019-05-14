package pattern.bridge;// File: Client.java
import java.util.ArrayList;

public class Client 
{
   public static void main (String[] args) 
   {
      Player a = new Player (new CDPlayer());
      a.playOff (3);

      Player b = new Player (new CassettePlayer());
      b.playOff (5);

      ArrayList<Integer> playlist = new ArrayList<Integer>();
      playlist.add (1);
      playlist.add (9);
      playlist.add (3);

      ListPlayer l = new ListPlayer(new CDPlayer(), playlist);
      // This client uses both the abstraction and the special abstraction 
      l.playAndTurnOff();
   }
}
