package pattern.visitor;// File: Company.java
import java.util.ArrayList;
import java.util.List;

// This class represents a company and contains its staff.
class Company
{
   private List<Staff> personal;

   public Company()
   {
      this.personal = new ArrayList<Staff>();
      initializeSampleData();
   }

   private void initializeSampleData()
   {
      // Clerk Team 1
      ArrayList<Staff> team1 = new ArrayList<Staff>();

      team1.add 
             (new Clerk("Markus","Mueller ", 48200.0f));
      team1.add 
             (new Clerk("Silvia","Neustedt", 45500.0f));

      // Clerk Team 2
      ArrayList<Staff> team2 = new ArrayList<Staff>();
      
      team2.add 
             (new Clerk ("Alexandra","Weiss", 37120.0f));
      team2.add 
             (new Clerk ("Michael","Kienzle", 35500.0f));

      // Team Leaders
      TeamLeader chef1, chef2;

      chef1 = 
        new TeamLeader ("Frank", "Hirschle", 40000.0f, 400.0f,
                        "Team 1");
      chef2 = 
        new TeamLeader ("Corinna", "Steib", 35000.0f, 350.0f,
         "Team 2");

      // all persons in the staff list
      this.personal.add (chef1);
      this.personal.add (chef2);
      this.personal.addAll (team1);
      this.personal.addAll (team2);
   }

   public List<Staff> getPersonal()
   {
      return personal;
   }
}
