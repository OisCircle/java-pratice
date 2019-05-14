package pattern.visitor;

// File: TeamLeader.java
class TeamLeader extends Staff 
{
   private String teamName;
   private float basicSalary;
   private float bonus;

   public TeamLeader (String firstName, String name, 
                      float basicSalary, float bonus, 
                      String teamName)
   {
      super (firstName,name);
      this.basicSalary = basicSalary;
      this.bonus = bonus;
      this.teamName = teamName;
   }

   public String getTeamName()
   {
      return teamName;
   }

   public void setTeamName(String teamName)
   {
      this.teamName = teamName;
   }

   public float getBasicSalary()
   {
      return this.basicSalary;
   }

   public void setBasicSalary (float basicSalary)
   {
      this.basicSalary = basicSalary;
   }

   public float getBonus()
   {
      return this.bonus;
   }

   public void setBonus (float bonus)
   {
      this.bonus = bonus;
   }

   public void accept (StaffVisitor v)
   {
      // to visit yourself
      v.visit (this);
   }
}
