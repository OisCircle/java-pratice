package pattern.itertaror;

// File: StaffIterator.java
class StaffIterator implements IIterator
{
   int size=0;
   int index=0;
   Staff data[];

   //Constructor with array and number of elements
   public StaffIterator(Staff ma[], int s)
   {
      data = ma;
      size = s;
   }

   //Implementing hasNext()
   public boolean hasNext()
   {
      return index < size;
   }

   //Implementing next()
   public Staff next()
   {
      return data[index++];
   }
}
