package pattern.bridge;// File: ListPlayer.java
import java.util.ArrayList;

// Special abstraction
public class ListPlayer extends Player 
{
   private ArrayList<Integer> list;

   public ListPlayer(IPlayerImplementer impl, 
                                  ArrayList<Integer> list)
   {
      super(impl);
      this.list = list;
   }

   public void playAndTurnOff() // new function
   {
      for(int i : list)
      {
         impl.jump2Track (i);
         PlayData daten = impl.readData();
         System.out.println (daten);
      }
      impl.turnOff();
   }
}
