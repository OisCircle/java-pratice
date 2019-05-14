package pattern.adapter;// File: CSVReader.java
import java.io.*;
import java.util.Vector;

public class CSVReader
{  
   // has as return value a vector of the type of a string array
   public Vector<String []> readPersonalFile (String file)
   {   
      Vector<String []> persons = new Vector<String[]>();
      try
      {
         BufferedReader input = 
                  new BufferedReader (new FileReader(file));
         String strLine;

         while ((strLine = input.readLine()) != null)
         {
            String[] splitted = strLine.split (",");
            if (splitted.length >= 2)
               persons.add(new String [] 
                                 {splitted[0], splitted[1]});
         }
         input.close();
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
      }
      return persons;
   }
}
