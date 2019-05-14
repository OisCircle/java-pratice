package pattern.itertaror;

// File: StaffArray.java
// Implementing the IDatastructure
class StaffArray implements IDataStructure
{
   final int max = 10;
   Staff[] data = new Staff[max];
   int index = 0;

   //Implementing the getIterator () function
   //Returns the value specific to this data structure as a return value
   //Iterator back
   public IIterator getIterator()
   {
      return new StaffIterator (data, index);
   }

   //Function for adding a new employee
   public void add (Staff ma)
   {
      if(index < max - 1)
      {
         data[index++] = ma;
      }
   }
}
