package tema15Dictionare;

import java.util.HashMap;
import java.util.Scanner;

public class CarRentalSystem {

	private static Scanner sc = new Scanner(System.in);
	private HashMap<String, String> rentedCars = new HashMap<String, String>(100, 0.5f);

	private static String getPlateNo() {
		System.out.println("Introduceti numarul de inmatriculare:");
		return sc.nextLine();
	}

	private static String getOwnerName() {
		System.out.println("Introduceti numele proprietarului:");
		return sc.nextLine();
	}

	// search for a key in hashtable
	private boolean isCarRent(String plateNo) {
		return rentedCars.containsKey(plateNo);
	}

	// get the value associated to a key
	private String getCarRent(String plateNo) {
		return rentedCars.getOrDefault(plateNo, "Error: Masina nu este inchiriata");
	}

	// add a new (key, value) pair
	private void rentCar(String plateNo, String ownerName) {
		if (!rentedCars.containsKey(plateNo)) {
			rentedCars.put(plateNo, ownerName);
		} else {
			System.out.println("Error: Masina este deja inchiriata");
		}
	}

	// remove an existing (key, value) pair
	private void returnCar(String plateNo) {
		if (rentedCars.remove(plateNo) != null) {
			System.out.println("Masina: " + plateNo + " a fost returnata");
		} else {
			System.out.println("Error: Masina nu exista");
		}
	}

	private int getRentedCarsNo() {
		return rentedCars.size();
	}

	private static void printCommandsList() {
		System.out.println("help         - Afiseaza aceasta lista de comenzi");
		System.out.println("add          - Adauga o noua pereche (masina, sofer)");
		System.out.println("check        - Verifica daca o masina este deja luata");
		System.out.println("remove       - Sterge o masina existenta din hashtable");
		System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
		System.out.println("totalRented  - Afiseaza numarul total de masini inchiriate");
		System.out.println("quit         - Inchide aplicatia");
	}

	public void run() {
		boolean quit = false;
		while (!quit) {
			System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			String command = sc.nextLine();
			switch (command) {
			case "help":
				printCommandsList();
				break;
			case "add":
				rentCar(getPlateNo(), getOwnerName());
				break;
			case "check":
				System.out.println(isCarRent(getPlateNo()));
				break;
			case "remove":
				returnCar(getPlateNo());
				break;
			case "getOwner":
				System.out.println(getCarRent(getPlateNo()));
				break;
			case "totalRented":
				System.out.println(getRentedCarsNo());
				break;
			case "quit":
				System.out.println("Aplicatia se inchide...");
				quit = true;
				break;
			default:
				System.out.println("Unknown command. Choose from:");
				printCommandsList();
			}
		}
	}

	public static void main(String[] args) {
		// create and run an instance (for test purpose)
		new CarRentalSystem().run();
	}
}
