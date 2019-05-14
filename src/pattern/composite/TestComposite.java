package pattern.composite;

// File: TestCompound.java
public class TestComposite
{
   public static void main (String[] args)
   {
      System.out.println ("Test program for composite pattern");
      System.out.println ("");

      // Structure of the object structure
      Composite comp = new Composite ("Composite level 1");
      Composite comp11 = 
         new Composite ("Composite level 11");
      Composite comp12 = 
         new Composite ("Composite level 12");
      Composite comp121 = 
         new Composite ("Composite level 121");
   
      comp.add (comp11);
      comp.add (comp12);
   
      comp12.add (comp121);
   
      Leaf leaf111 = new Leaf ("Leaf111");
      Leaf leaf112 = new Leaf ("Leaf112");
   
      Leaf leaf121 = new Leaf ("Leaf121");
      Leaf leaf122 = new Leaf ("Leaf122");
      Leaf leaf123 = new Leaf ("Leaf123");
   
      Leaf leaf1211 = new Leaf ("Leaf1211");
   
      comp11.add (leaf111);
      comp11.add (leaf112);
   
      comp12.add (leaf121);
      comp12.add (leaf122);
      comp12.add (leaf123);
   
      comp121.add (leaf1211);

      // Calling the operation for the compound
      System.out.println("First edition of the composite operation");
      System.out.println();
      comp.operation();
   
      // Modification of the object structure
      comp12.remove (leaf122);
      comp12.remove (comp121);
   
      // renewed call of the operation for the compound
      System.out.println();
      System.out.println("Second edition of the composite operation");
      System.out.println();
      comp.operation();
   }
}
