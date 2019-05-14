package pattern.adapter;// File: TestAdapter.java
import java.util.Vector;

public class TestAdapter
{
   public static void main (String[] args)
   {
      IPersonsReader leser = new CSVReaderAdapter ("C:\\GitHubRepositories\\Learn-Java\\src\\pattern\\adapter\\Personen.csv");
      Vector<Person> personen = leser.readPersons();
	   for (Person person : personen) {
		   person.print();
	   }
   }
}
