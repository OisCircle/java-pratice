package pattern.broker;

// Datei: WeatherService.java
public class WeatherService implements IWeatherService
{
   public WeatherService()
   {
      System.out.println ("WeatherService: instantiated");
   }

   // Diese Methode stellt den Dienst des Wetter-Servers dar.
   public String askWeather (Day day)
   {
      String weather;
      switch (day)
      {
         case Today:
            weather = "Sunshine";
            break;
         case Tomorrow:
            weather = "Rain";
            break;
         default:
            weather = "No weather known";
            break;
      }
      return weather;
   }
}
