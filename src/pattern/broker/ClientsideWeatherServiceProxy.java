package pattern.broker;

// Datei: ClientsideWeatherServiceProxy.java
public class ClientsideWeatherServiceProxy
        implements IWeatherService, IClientsideProxy
{
   private Broker broker;
   private String response;

   public ClientsideWeatherServiceProxy (Broker broker)
   {
      this.broker = broker;
      System.out.println 
              ("ClientSideWeatherServiceProxy: instantiated");
   }

   // Nimm Dienstaufruf entgegen, erzeuge Anfragenachricht
   // und schicke sie an den Broker.
   // Die zurueckgelieferte Antwort wird als Ergebnis des Aufrufs 
   // dem Client uebergeben.
   public String askWeather (Day day)
   {
      String serviceName = "askWeather";
      byte[] inquiry = pack (serviceName, day);
      broker.requestForward (inquiry, this);
      return response;
   }

   // Hier kommt die Antwort des Servers ueber den Broker zurueck.
   // Die Nachricht wird ausgepackt und intern zwischengespeichert.
   public void returnResponse (byte[] answer)
   {
      response = unpack (answer);
   }

   // Erstelle eine Anfragenachricht in Form eines Byte-Arrays:
   // mit eigenem Namen, Namen der aufgerufenen Dienstmethode 
   // und dem Argument des Dienstaufrufs.
   private byte[] pack (String method, Day day)
   {
      String myName = "ClientsideWeatherServiceProxy";
      String inquiry = myName + ";" + method + ";" 
                       + day.toString();
      return inquiry.getBytes();
   }

   // Packe die Antwortnachricht aus dem Byte-Array aus:
   // liefere das Ergebnis des Dienstaufrufs als String zurueck.
   private String unpack (byte[] message)
   {
       String[] strings = (new String (message)).split (";");
       return strings[1];
   }
}
