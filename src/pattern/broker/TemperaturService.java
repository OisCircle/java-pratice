package pattern.broker;

// Datei: TemperaturService.java
public class TemperaturService implements ITemperaturService
{
   public TemperaturService()
   {
      System.out.println ("TemperaturService��instantiated��");
   }

   // Diese Methode stellt den Dienst des Temperatur-Servers dar
   public Float askTemperature (Day tag)
   {
      Float temperatur;
      switch (tag)
      {
         case Today:
            temperatur = 25f;
            break;
         case Tomorrow:
            temperatur = 10f;
            break;
         default:
            temperatur = Float.NaN;
            break;
      }
      return temperatur;
   }
}
