package pattern.visitor;

// File: Clerk.java
class Clerk extends Staff
{
   private float salary;

   public Clerk (String firstName, String name, float salary)
   {
      super (firstName,name);
      this.salary = salary;
   }

   public float getSalary()
   {
      return salary;
   }

   public void accept (StaffVisitor v)
   {
      // to visit yourself
      v.visit (this);
   }
}
