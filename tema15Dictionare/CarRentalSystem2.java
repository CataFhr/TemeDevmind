package tema15Dictionare;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarRentalSystem2 {

	private static Scanner sc = new Scanner(System.in);
	private Map<String, String> rentedCars = new HashMap<String, String>(100, 0.5f);
	private Map<String, RentedCars> ownersCars = new HashMap<String, RentedCars>();

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
			if (!ownersCars.containsKey(ownerName)) {
				ownersCars.put(ownerName, new RentedCars(ownerName));
				ownersCars.get(ownerName).rentCar(plateNo);
			} else {
				ownersCars.get(ownerName).rentCar(plateNo);
			}
		} else {
			System.out.println("Error: Masina este deja inchiriata");
		}
	}

	// remove an existing (key, value) pair
	private void returnCar(String plateNo) {
		if (rentedCars.containsKey(plateNo)) {
			String ownerName = getCarRent(plateNo);
			ownersCars.get(ownerName).returnCar(plateNo);
			rentedCars.remove(plateNo);
			System.out.println("Masina: " + plateNo + " a fost returnata");
		} else {
			System.out.println("Error: Masina nu exista");
		}
	}

	private int getRentedCarsNo() {
		return rentedCars.size();
	}

	private int getCarsNo(String ownerName) {
		if (ownersCars.containsKey(ownerName)) {
			return ownersCars.get(ownerName).getCarsNo();
		}
		return 0;
	}

	private List<String> getCarsList(String ownerName) {
		if (ownersCars.containsKey(ownerName)) {
			return ownersCars.get(ownerName).getCars();
		}
		return Collections.emptyList();
	}

	private static void printCommandsList() {
		System.out.println("help         - Afiseaza aceasta lista de comenzi");
		System.out.println("add          - Adauga o noua pereche (masina, sofer)");
		System.out.println("check        - Verifica daca o masina este deja luata");
		System.out.println("remove       - Sterge o masina existenta din hashtable");
		System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
		System.out.println("totalRented  - Afiseaza numarul total de masini inchiriate");
		System.out.println("getCars      - Afiseaza lista masinilor inchiriate de o persoana");
		System.out.println("getCarsNo    - Afiseaza numarul masinilor inchiriate de o persoana");
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
			case "getCarsNo":
				System.out.println(getCarsNo(getOwnerName()));
				break;
			case "getCars":
				System.out.println(getCarsList(getOwnerName()));
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
		new CarRentalSystem2().run();
	}
}
