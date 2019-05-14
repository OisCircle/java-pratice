package pattern.visitor;// File: StaffManager.java
import java.util.List;

public class StaffManager
{
   public static void main (String[] args)
   {
      // Initialize
      Company firm = new Company();
      List<Staff> staffList = firm.getPersonal();

      // Create visitor object for the list
      SalaryPrinter visitor = new SalaryPrinter();

      // Iterate over the list and make visits 
      for (Staff staff: staffList)
      {
         staff.accept (visitor);
      }
   }
}
