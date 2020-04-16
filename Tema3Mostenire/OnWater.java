package Tema3Mostenire;

public class OnWater extends Vehicle {

	private int noEngines = 2;
	private double cargoCapacity;

	public OnWater(String serialNumber, int noPersons) {
		super(serialNumber, noPersons);
	}

	public OnWater(String serialNumber, int noPersons, String name) {
		super(serialNumber, noPersons, name);
	}

	public OnWater(String serialNumber, int noPersons, String name, int noEngines) {
		this(serialNumber, noPersons, name);
		this.noEngines = noEngines;
	}

	public OnWater(String serialNumber, int noPersons, String name, int noEngines, double cargoCapacity) {
		this(serialNumber, noPersons, name, noEngines);
		this.cargoCapacity = cargoCapacity;
	}

	@Override
	public boolean goTo(double positionX, double positionY) {
		System.out.println("Sailing the vessel to coordinates: [" + positionX + " " + positionY + "]");
		return true;
	}

	@Override
	public boolean addFuel(double amount) {
		System.out.println("Adding " + amount + " l of fuel to the vessel");
		return true;
	}

	@Override
	public void printInfo() {
		System.out.println("Vehicle proprieties:" + "\n\t-serial number: " + super.serialNumber + "\n\t-capacity: "
				+ super.noPersons + " persons" + "\n\t-name: " + super.name + "\nVessel properties:"
				+ "\n\t- number of engines " + this.noEngines + "\n\t- cargo capacity " + this.cargoCapacity);
	}

}
