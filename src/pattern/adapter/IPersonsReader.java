package pattern.adapter;// File: IPersonsReader.java
import java.util.Vector;
public interface IPersonsReader
{
   // has as a return value a vector of persons
   public Vector<Person> readPersons();
}
