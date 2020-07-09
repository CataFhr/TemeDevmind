package tema19Serializare;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class CarRentalSystem {

	private static Scanner sc = new Scanner(System.in);
	private static boolean resetApp = false;
	private HashMap<String, String> rentedCars;

	public CarRentalSystem() throws IOException {
		if (Files.exists(Paths.get("TemeDevmind/tema19Serializare/cars.dat"))) {
			rentedCars = readFromBinaryFile();
		} else {
			rentedCars = new HashMap<>();
		}
	}

	public HashMap<String, String> getRentedCars() {
		return rentedCars;
	}

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
	private void rentCar(String plateNo, String ownerName) throws CarAlreadyExistException {
		if (!rentedCars.containsKey(plateNo)) {
			rentedCars.put(plateNo, ownerName);
		} else {
			throw new CarAlreadyExistException("Masina este deja inchiriata");
		}
	}

	// remove an existing (key, value) pair
	private void returnCar(String plateNo) throws CarAlreadyExistException {
		if (rentedCars.remove(plateNo) != null) {
			System.out.println("Masina: " + plateNo + " a fost returnata");
		} else {
			throw new CarAlreadyExistException("Masina nu exista");
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
		System.out.println("reset        - Reseteaza aplicatia");
		System.out.println("quit         - Inchide aplicatia");
	}

	public static void writeToBinaryFile(HashMap<String, String> map) throws IOException {
		try (ObjectOutputStream binaryFileOut = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("TemeDevmind/tema19Serializare/cars.dat")))) {
			binaryFileOut.writeObject(map);
		}
	}

	public static HashMap<String, String> readFromBinaryFile() throws IOException {
		HashMap<String, String> data = null;
		try (ObjectInputStream binaryFileIn = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("TemeDevmind/tema19Serializare/cars.dat")))) {
			data = (HashMap<String, String>) binaryFileIn.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("A class not found exception: " + e.getMessage());
		}
		return data;
	}

	public void run() throws IOException {
		boolean quit = false;
		while (!quit) {
			System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			String command = sc.nextLine();
			switch (command) {
			case "help":
				printCommandsList();
				break;
			case "add":
				try {
					rentCar(getPlateNo(), getOwnerName());
				} catch (CarAlreadyExistException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "check":
				System.out.println(isCarRent(getPlateNo()));
				break;
			case "remove":
				try {
					returnCar(getPlateNo());
				} catch (CarAlreadyExistException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "getOwner":
				System.out.println(getCarRent(getPlateNo()));
				break;
			case "totalRented":
				System.out.println(getRentedCarsNo());
				break;
			case "reset":
				Files.deleteIfExists(Paths.get("TemeDevmind/tema19Serializare/cars.dat"));
				System.out.println("Aplicatia se reseteaza...");
				resetApp = true;
				quit = true;
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
		try {
			CarRentalSystem system1 = new CarRentalSystem();
			system1.run();
			if (!resetApp) {
				writeToBinaryFile(system1.getRentedCars());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
