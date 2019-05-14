package pattern.bridge;

// File: IPlayerImplementer.java
// Implementer as interface
public interface IPlayerImplementer 
{
   // jump to track song number
   public void jump2Track(int songNumber);

   // reads the data to play ...
   public PlayData readData();

   // turns off the device ...
   public void turnOff();
}
