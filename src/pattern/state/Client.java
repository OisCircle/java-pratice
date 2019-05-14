package pattern.state;

// File: Client.java
public class Client 
{    
   public static void main (String[] args)
   {
      AlarmSystem a = new AlarmSystem();
              
      System.out.println ("Disable the system...");
      System.out.println ("In customer business that bothers.");
      a.turnOff();
        
      System.out.println ("Person recognized.");
      a.personRecognized();
        
      System.out.println ("End of working day.");
      System.out.println ("Activate the alarm system.");
      a.turnOn();
        
      System.out.println ("Person recognized.");
      a.personRecognized();        
   }
}
