package pattern.decorator;

// File: Equipment.java
public abstract class Equipment implements IAuto
{
   protected IAuto auto;

   public Equipment (IAuto pIAuto)
   {
      auto = pIAuto;
   }
}
