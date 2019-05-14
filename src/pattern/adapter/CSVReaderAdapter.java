package pattern.adapter;// File: CSVLeserAdapter.java
import java.util.Vector;

public class CSVReaderAdapter implements IPersonsReader
{
   private String file;
   
   public CSVReaderAdapter(String file) 
   {
      this.file = file;
   }

   public Vector<Person> readPersons() 
   {
      CSVReader reader = new CSVReader();
      Vector<String []> persons = 
    		  reader.readPersonalFile(file);
      Vector<Person> personVector = new Vector<Person>();

      for (String [] person : persons)
         personVector.add (new Person(person [0], person [1]));
      return personVector;
   }
}
