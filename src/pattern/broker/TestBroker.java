package pattern.broker;

// Datei: TestBroker.java
public class TestBroker
{
   public static void main(String[] args)
   {
      // Broker, Server und Server-side Proxys erzeugen
      System.out.println 
              ("TestBroker: Generate brokers and services");
      Broker broker = new Broker();
      new ServersideWeatherServiceProxy (broker);
      new ServersideTemperaturServiceProxy (broker);

      // Client-side Proxys erzeugen
      System.out.println();
      System.out.println 
              ("TestBroker: Client-side Proxys produce");
      ClientsideWeatherServiceProxy cwp = 
              new ClientsideWeatherServiceProxy (broker);
      ClientsideTemperaturServiceProxy ctp = 
              new ClientsideTemperaturServiceProxy (broker);

      // Client-Objekt erstellen und mit Referenzen 
      // auf die Dienste versorgen. Es werden die Referenzen
      // auf die Client-side Proxys uebergeben!
      Client application = new Client();
      application.injectServices (cwp, ctp);

      // Jetzt kann die Anwendung gestartet werden:
      application.printedWeatherData();
   }
}
