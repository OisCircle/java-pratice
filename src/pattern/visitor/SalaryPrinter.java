package pattern.visitor;

// File: SalaryPrinter.java
class SalaryPrinter extends StaffVisitor
{
   public SalaryPrinter()
   {
      System.out.print("***************************************");
      System.out.println("****************************");
      System.out.println("                               Payroll");
      System.out.print("Position" + "\t" + "Firstname" + "\t" + 
         "Name" + "\t" + "\t");
      System.out.println("Salary" + "\t" + "      Bonus");
      System.out.print("***************************************");
      System.out.println("****************************");
   }

   public void visit(TeamLeader t)
   {
      String firstName;
      String name;
      if (t.getFirstName().length() < 8)
         firstName = t.getFirstName().concat("\t");
      else firstName = t.getFirstName();

      if (t.getName().length() < 8)
         name = t.getName().concat("\t");
      else name = t.getName();

      System.out.print("Leader " + t.getTeamName() + "\t"
         + firstName + "\t" + name + "\t");
      System.out.printf("%7.2f", t.getBasicSalary());
      System.out.printf("%11.2f", t.getBonus());
      System.out.println();
   }

   public void visit(Clerk s)
   {
      String firstName;
      String name;
      if (s.getFirstName().length() < 8)
         firstName = s.getFirstName().concat("\t");
      else firstName = s.getFirstName();

      if (s.getName().length() < 8)
         name = s.getName().concat("\t");
      else name = s.getName();

      System.out.print("Clerk" + "\t\t" + firstName + "\t" + 
         name + "\t");
      System.out.printf("%7.2f", s.getSalary());
      System.out.println("       ---");
   }
}
