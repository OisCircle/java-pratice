package pattern.broker;

// Datei: Client.java
public class Client
{
   // Diese Referenzen koennen sowohl auf echte Server-Objekte
   // zeigen, aber auch auf Client-side Proxys
   IWeatherService weatherServer;
   ITemperaturService temperaturServer;

   public void injectServices(IWeatherService wds, 
                              ITemperaturService tds)
   {
      weatherServer = wds;
      temperaturServer = tds;
   }

   // Diese Methode stellt die eigentliche Client-Anwendung dar.
   // Es werden Wetter- und Temperaturdaten von den Servern 
   // abgefragt und ausgegeben. 
   public void printedWeatherData()
   {
      // Request weather and temperature for today
      System.out.println();
      System.out.println ("Client: " +
              "Request weather and temperature for today:");
      String weatherToday = 
              weatherServer.askWeather (Day.Today);
      Float temperaturToday = 
              temperaturServer.askTemperature (Day.Today);
      System.out.println ("Today there are " + weatherToday 
              + " at " + temperaturToday + " Degree.");

      // Request weather and temperature for tomorrow
      System.out.println();
      System.out.println ("Client: " +
               "Request weather and temperature for tomorrow:");
      String weatherTomorrow = 
               weatherServer.askWeather(Day.Tomorrow);
      Float temperaturMorgen = 
               temperaturServer.askTemperature(Day.Tomorrow);
      System.out.println ("Tomorrow there are " + weatherTomorrow
              + " at " + temperaturMorgen+ " Degree.");
   }
}
