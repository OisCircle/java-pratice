package pattern.visitor;

// File: Staff.java
abstract class Staff
{
   protected int	 personalNumber;
   private static int numberOfStaffs = 0;
   protected String name;
   protected String firstName;

   Staff (String firstName, String name)
   {
      this.personalNumber = numberOfStaffs++;
      this.firstName = firstName;
      this.name = name;
   }
   
   public int getPersonalNumber()
   {
      return personalNumber;
   }

   public String getName()
   {
      return name;
   }

   public void setName (String name)
   {
      this.name = name;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName (String firstName)
   {
      this.firstName = firstName;
   }

   public String toString()
   {
      return ("PersonalNo."+ this.personalNumber + "Name:" +
               this.firstName + " " + this.name);
   }

   public abstract void accept (StaffVisitor v);
}
