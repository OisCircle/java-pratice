package pattern.role_object;

// File: Sales.java
public class Sales
{
   private Staff staff;
   int sales;

   public Sales (int sales)
   {
      this.sales = sales;
   }

   public String getDepartmentName()
   {
      return "Sale";
   }

   public void printSales()
   {
      System.out.println ("Current sales of "
            + staff.getName() + ": " + sales + " Euro.");
   }

   public Staff getStaff()
   {
      return staff;
   }

   public void setStaff (Staff staff)
   {
      this.staff = staff;
   }
}
