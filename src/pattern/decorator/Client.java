package pattern.decorator;

// File: Client.java
class Client {

    public static void main(String[] args) {  // Car with air conditioner
        IAuto auto = new AirConditioner(new Limousine());
        auto.showDetails();
	    printCost(auto);

	    // Dynamic extension of the saloon with equipment
        auto = new NavigationSystem(new SideAirbags(auto));
        auto.showDetails();
	    printCost(auto);

	    // Convertible variant
        auto = new NavigationSystem(new SideAirbags(new Convertible()));
        auto.showDetails();


	    printCost(auto);
    }

	private static void printCost(IAuto auto) {
		System.out.println("\nfor " + auto.getCosts()
		        + " Euro\n");
	}
}
