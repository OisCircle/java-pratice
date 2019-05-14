package pattern.adapter;

// File: Person.java
public class Person
{
   private String surname;
   private String name;
   
   public Person (String surname, String name)
   {
      this.surname = surname;
      this.name = name;
   }

   public void print()
   {
      System.out.println (name + " " + surname);
   }
}
