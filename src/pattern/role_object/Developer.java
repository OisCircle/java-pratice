package pattern.role_object;

// File: Developer.java
public class Developer
{
   private Staff staff;
   private String project;

   public Developer (String project)
   {
      this.project = project;
   }

   public String getDepartmentName()
   {
      return "Development";
   }

   public void printProject()
   {
      System.out.println (staff.getName() + " "
            + "is currently working on: " + project);
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
