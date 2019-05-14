package pattern.broker;

// Datei: ServersideTemperaturServiceProxy.java
public class ServersideTemperaturServiceProxy 
                          implements IServersideProxy 
{
   // Ein Server-side Proxy kennt den Broker und den 
   // eigentlichen Server.
   private ITemperaturService temperaturService;
   private Broker broker;
   
   public ServersideTemperaturServiceProxy (Broker broker)
   {
      System.out.println 
                ("ServersideTemperatureServiceProxy: instantiated");
      this.broker = broker;
      temperaturService = new TemperaturService();
      broker.SignIn ("askTemperature", this);
   }

   // Bearbeite eine Anfragenachricht, die vom Broker kommt.
   // Aus der Anfragenachricht wird das Argument des Aufrufs geholt
   // und anschliessend die Dienstmethode des Servers aufgerufen.
   // Das Ergebnis des Servers wird in eine Antwortnachricht
   // verpackt und an den Broker geschickt.
   public void handleRequest (byte[] request)
   {
      Day day = unpacking (request);
      Float temperatur = temperaturService.askTemperature (day);
      byte[] response = pack (request, temperatur);
      broker.responseForward (response);
   }

   // Packe aus einer Anfragenachricht das Argument des
   // Dienstaufrufs aus.
   private Day unpacking (byte[] packedMessage)
   {
      String string = new String (packedMessage);
      String[] unpackedMessage = string.split (";");
      Day tag = Day.valueOf (unpackedMessage[2]);
      return tag;
   }

   // Besorge aus der Anfragenachricht den Clientnamen und
   // verpacke diesen zusammen mit dem Ergebniswert
   // in eine Antwortnachricht.
   private byte[] pack (byte[] request, Float value)
   {
      String[] strings =  (new String (request)).split (";");
      String clientName = strings[0];
      return (clientName + ";" + value).getBytes();
   }
}
