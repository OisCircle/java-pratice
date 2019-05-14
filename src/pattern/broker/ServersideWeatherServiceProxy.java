package pattern.broker;

// Datei: ServersideWeatherServiceProxy.java
public class ServersideWeatherServiceProxy implements IServersideProxy
{
   // Ein Server-side Proxy kennt den Broker und den 
   // eigentlichen Server.
   private IWeatherService weatherService;
   private Broker broker;

   public ServersideWeatherServiceProxy (Broker broker)
   {
      System.out.println 
               ("ServersideWeatherServiceProxy: instantiated");
      this.broker = broker;
      weatherService = new WeatherService();
      broker.SignIn ("askWeather", this);
   }

   // Bearbeite eine Anfragenachricht, die vom Broker kommt.
   // Aus der Anfragenachriask for weathercht wird das Argument des Aufrufs geholt
   // und anschliessend die Dienstmethode des Servers aufgerufen.
   // Das Ergebnis des Servers wird in eine Antwortnachricht
   // verpackt und an den Broker geschickt.
   public void handleRequest (byte[] request)
   {
      Day day = unpack (request);
      String weather = weatherService.askWeather (day);
      byte[] response = pack (request, weather);
      broker.responseForward (response);
   }

   // Packe aus einer Anfragenachricht das Argument des
   // Dienstaufrufs aus.
   private Day unpack (byte[] packedMessage)
   {
      String string = new String (packedMessage);
      String[] unpackedMessage = string.split (";");
      Day day = Day.valueOf (unpackedMessage[2]);
      return day;
   }

   // Besorge aus der Anfragenachricht den Clientnamen und
   // verpacke diesen zusammen mit dem Ergebniswert
   // in eine Antwortnachricht.
   private byte[] pack (byte[] request, String result)
   {
      String[] strings =  (new String (request)).split (";");
      String clientName = strings[0];
      return (clientName + ";" + result).getBytes();
   }
}
