package pattern.broker;// Datei: Broker.java
import java.util.HashMap;
public class Broker
{
   private HashMap<String, IClientsideProxy> clientMap;
   private HashMap<String, IServersideProxy> serverMap;

   public Broker()
   {
      clientMap = new HashMap<String, IClientsideProxy>();
      serverMap = new HashMap<String, IServersideProxy>();
      System.out.println ("Broker: instantiated");
   }

   // Ein Server-side Proxy wird angemeldet. Anforderungen fuer den
   // angegebenen Dienst, koennen an ihn weitergeleitet werden.
   public void SignIn (String serviceName, IServersideProxy proxy)
   {
      serverMap.put (serviceName, proxy);
      System.out.println ("Broker: Service \"" + serviceName + 
              "\" Registered");
   }

   // Ein Dienst wird wieder abgemeldet und aus der 
   // serverMap entfernt.
   public void signOut (String serviceName)
   {
      serverMap.remove (serviceName);
      System.out.println ("Broker: Service \"" + serviceName + 
              "\" deregistered");
   }

   // Diese Methode ruft ein Client-side Proxy auf,
   // um einen Dienst anzufragen. Der Dienst ist in der
   // Anfragenachricht enthalten ebenso wie der Clientname.
   public void requestForward (byte[] request, 
                                    IClientsideProxy proxy)
   {
      String clientName = determineClientName (request);
      String serviceName = determineServiceName (request);
      clientMap.put (clientName, proxy);
      IServersideProxy serverProxy = findeServer (serviceName);
      serverProxy.handleRequest (request);
   }

   // Diese Methode ruft ein Server-side Proxy auf, der eine
   // Antwortnachricht als Ergebnis eines Dienstaufrufs
   // an den Client schicken will. Der Clientname ist in der
   // Antwortnachricht enthalten.
   public void responseForward (byte[] response)
   {
      String clientName = determineClientName (response);
      IClientsideProxy clientProxy = findeClient (clientName);
      clientProxy.returnResponse (response);
      clientMap.remove (clientName);
   }

   // Diese Methode sucht in der serverMap nach dem Dienstnamen.
   private IServersideProxy findeServer (String service)
   {
      return serverMap.get (service);
   }

   // Diese Methode sucht in der clientMap nach dem Clientnamen.
   private IClientsideProxy findeClient (String client)
   {
      return clientMap.get (client);
   }

   // Ermittle Clientname aus Antwortnachricht
   private String determineClientName (byte[] message)
   {
      String[] strings = (new String (message)).split (";");
      return strings[0];
   }

   // Ermittelt Dienstname aus der Anfragenachricht.
   private String determineServiceName (byte[] message)
   {
      String[] strings = (new String (message)).split (";");
      return strings[1];
   }
}
