package pattern.role_object;

// File: TestRole.java
public class TestRole
{
   public static void main (String[] args)
   {
      // Core objects are generated
      Staff maier = new Staff ("Maier");
      Staff schulze = new Staff ("Schulze");
      
      // Role objects of the development department
      Developer developer1 = new Developer ("Product 2.0");
      Developer developer2 = new Developer ("Product Addon 1.0");

      // Assignment of roles to the core objects
      developer1.setStaff (schulze);
      developer2.setStaff (maier);

      //Output of the projects
      System.out.println ("\nCurrent projects of the employees: ");
      developer1.printProject();
      developer2.printProject();

      // A core object plays another role
      System.out.println ("\nSchulze receives additional tasks in sales:");
      Sales sales1 = new Sales (15000);
      sales1.setStaff (schulze);

      // Output of sales figures
      System.out.println ("\nOnly Schulze is in the sales department");
      sales1.printSales();
   }
}
