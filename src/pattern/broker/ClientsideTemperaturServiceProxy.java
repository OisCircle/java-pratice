package pattern.broker;

// Datei: ClientsideTemperaturServiceProxy.java
public class ClientsideTemperaturServiceProxy 
        implements ITemperaturService, IClientsideProxy
{
   private Broker broker;
   private Float response;

   public ClientsideTemperaturServiceProxy (Broker broker)
   {
      this.broker = broker;
      System.out.println 
              ("ClientSideTemperaturServiceProxy: instantiated");
   }

   // Nimm Dienstaufruf entgegen, erzeuge Anfragenachricht
   // und schicke sie an den Broker.
   // Die zurueckgelieferte Antwort wird als Ergebnis des Aufrufs 
   // dem Client uebergeben.
   public Float askTemperature (Day day)
   {
      String serviceName = "askTemperature";
      byte[] message = pack (serviceName, day);
      broker.requestForward (message, this);
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
      String myName = "ClientsideTemperaturServiceProxy";
      String inquiry = myName + ";" + method + ";" 
                     + day.toString(); 
      return inquiry.getBytes();
   }

   // Packe die Antwortnachricht aus dem Byte-Array aus:
   // liefere das Ergebnis des Dienstaufrufs als Float zurueck.
   private Float unpack (byte[] message)
   {
      String[] strings = (new String (message)).split (";");
      return Float.valueOf (strings[1]);
   }
}
