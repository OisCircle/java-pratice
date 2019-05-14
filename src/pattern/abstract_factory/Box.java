package pattern.abstract_factory;

// File: Box.java
public class Box 
{ 
   private int number; 
   private int numberOfScrews = 0;
   private int numberOfNuts = 0;
   private IScrew[] screws; 
   private INut[] nuts; 

   Box (int size) 
   {
      number = size;
      screws = new IScrew[number];
      nuts = new INut[number];
   }

   int getNubmer()
   {
      return number;
   }
   
   public void putScrewIn(IScrew screw) 
   {
      if (numberOfScrews == number) // if already full
      {
         return;
      }
      else
      {
         numberOfScrews++;
         screws[numberOfScrews-1] = screw;
      }
   }

   public void putNutIn(INut nut) 
   {
      if (numberOfNuts == number) // if already full
      {
         return;
      }
      else
      {
          numberOfNuts++;
          nuts[numberOfNuts-1] = nut;
      }
   }

   public void showContent() 
   {
      int i;
      for (i = 0; i < numberOfScrews; i++)
      {
         screws[i].print();
      }
      for (i = 0; i < numberOfNuts; i++)
      {
         nuts[i].print();
      }
   }
}
