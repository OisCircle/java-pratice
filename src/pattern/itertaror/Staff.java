package pattern.itertaror;

// File: Staff.java
class Staff
{
   private String firstName;
   private String Surname;

   private double salary;
   private int personalNo;

   private String Department;

   public Staff (String firstName, String surname, String 
 department, double salary, int personNo)
   {
      this.firstName = firstName;
      this.Surname = surname;
      this.Department = department;
      this.salary = salary;
      this.personalNo = personNo;
   }

   // Methods for setting and reading employee attributes
   // Here only the method is exemplary print():
   public void print()
   {
      System.out.println (firstName + " " + Surname + ", " + 
         personalNo + ", " + Department + ", " + salary);
   }
}

