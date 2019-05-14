package pattern.observer;

// File: TestObserver.java
public class TestObserver 
{
   public static void main (String[] args) 
   {
      Newsletter newsletter = new Newsletter();
      Subscriber andreas = new Subscriber ("Andreas");
      Subscriber birgit = new Subscriber ("Birgit");

      newsletter.attach (andreas);
      newsletter.attach (birgit);
      newsletter.anotherMessage ("News 1");
      System.out.println();

      newsletter.detach (andreas);
      newsletter.anotherMessage ("News 2");

      newsletter.detach (birgit);
      newsletter.anotherMessage ("News 3");
   }
}
