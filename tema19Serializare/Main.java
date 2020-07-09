package tema19Serializare;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

	private static GuestList guests;

	public static void main(String[] args) {
		// test.txt, testAdd.txt, testRemove.txt, testUpdateAndCheck.txt
		try (FileReader fr = new FileReader("TemeDevmind/tema19Serializare/test1.txt"); BufferedReader br = new BufferedReader(fr)) {
		
			System.out.println("Bun venit! Introduceti numarul de locuri disponibile: ");
			int maxGuestsNo = Integer.valueOf(br.readLine());
			MyValidator.validateGuestNumber(maxGuestsNo);
			Main.guests = new GuestList(maxGuestsNo);
			
			String line;
			while ((line = br.readLine()) != null && !line.equals("quit")) {
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi disponibile)");
				switch (line.toLowerCase()) {
				case "help":
					Main.printAvailableActions();
					break;
				case "add":
					Main.addGuest(br);
					break;
				case "check":
					int checkPosition = Main.searchGuestByOption(br);
					if (checkPosition >= 0) {
						String message = (checkPosition < maxGuestsNo) ? " de participanti." : "de asteptare.";
						System.out.println("Persoana se afla in lista " + message);
					}
					break;
				case "remove":
					int removePosition = Main.searchGuestByOption(br);
					if (removePosition >= 0) {
						Main.guests.removeGuest(removePosition);
					}
					break;
				case "update":
					int updatePosition = Main.searchGuestByOption(br);
					if (updatePosition >= 0) {
						updateGuestByOption(updatePosition, br);
					}
					break;
				case "guests":
					Main.guests.printGuestList();
					break;
				case "waitlist":
					Main.guests.printWaitingList();
					break;
				case "available":
					Main.guests.getAvailablePosition();
					break;
				case "guests_no":
					Main.guests.getGuestsNumber();
					break;
				case "waitlist_no":
					Main.guests.getWaitingGuestsNumber();
					break;
				case "subscribe_no":
					Main.guests.getSubscribeGuests();
					break;
				case "search":
					System.out.println("Introduceti caracterele dupa care doriti sa se faca cautarea:");
					List<Guest> list = Main.guests.partialSearch(br.readLine());
					list.forEach(System.out::println);
					break;
				case "quit":
					System.out.println("Aplicatia se inchide…");
					break;
				default:
					System.out.println("Comanda introdusa nu este valida.");
					break;
				}
			}
			Guest.writeToBinaryFile(Main.guests.getGuestList());
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

	private static void printAvailableActions() {
		System.out.println("Press:");
		System.out.println("help - Afiseaza aceasta lista de comenzi\n" + "add - Adauga o noua persoana (inscriere)\n"
				+ "check - Verifica daca o persoana este inscrisa la eveniment\n"
				+ "remove - Sterge o persoana existenta din lista\n" + "update - Actualizeaza detaliile unei persoane\n"
				+ "guests - Lista de persoane care participa la eveniment\n"
				+ "waitlist - Persoanele din lista de asteptare\n" + "available - Numarul de locuri libere\n"
				+ "guests_no - Numarul de persoane care participa la eveniment\n"
				+ "waitlist_no - Numarul de persoane din lista de asteptare\n"
				+ "subscribe_no - Numarul total de persoane inscrise\n"
				+ "search - Cauta toti invitatii conform sirului de caractere introdus\n"
				+ "quit - Inchide aplicatia\n");
	}

	private static void addGuest(BufferedReader br) throws IOException {
		System.out.println("Introduceti numele de familie:");
		String lastName = br.readLine();
		System.out.println("Introduceti prenumele:");
		String firstName = br.readLine();
		System.out.println("Introduceti email:");
		String email = br.readLine();
		System.out.println("Introduceti numar de telefon (format „+40733386463“):");
		String phoneNumber = br.readLine();
		Guest guest = new Guest(lastName, firstName, email, phoneNumber);
		if (MyValidator.isValidGuest(guest)) {
			Main.guests.addGuest(guest);
		} else {
			System.out.println("Error: Date incorecte.");
		}
	}

	private static void searchOption() {
		System.out.println("Alege modul de cautare, tastand:\n" + "\"1\" - Nume si prenume\n" + "\"2\" - Email\n"
				+ "\"3\" - Numar de telefon (format \"+40733386463\")\n");
	}

	private static void updateOption() {
		System.out.println("Alege campul de actualizat, tastand::\n" + "\"1\" - Nume\n" + "\"2\" - Prenume\n"
				+ "\"3\" - Email\n" + "\"4\" - Numar de telefon (format \"+40733386463\")\n");
	}

	private static int searchGuestByOption(BufferedReader br) throws NumberFormatException, IOException {
		searchOption();
		int option = Integer.parseInt(br.readLine());
		int foundPosition = -1;
		if (option == 1) {
			System.out.println("Introduceti numele de familie:");
			String lastName1 = br.readLine();
			System.out.println("Introduceti prenumele:");
			String firstName1 = br.readLine();
			foundPosition = Main.guests.searchGuestByName(lastName1, firstName1);
		} else if (option == 2) {
			System.out.println("Introduceti email:");
			String email1 = br.readLine();
			foundPosition = Main.guests.searchGuestByEmail(email1);
		} else if (option == 3) {
			System.out.println("Introduceti numar de telefon (format „+40733386463“):");
			String phoneNumber1 = br.readLine();
			foundPosition = Main.guests.searchGuestByPhoneNumber(phoneNumber1);
		} else {
			System.out.println("Numarul indrodus este incorect");
		}
		if (foundPosition < 0) {
			System.out.println("Persoana nu se afla in lista.");
		}
		return foundPosition;
	}

	private static void updateGuestByOption(int position, BufferedReader br) throws NumberFormatException, IOException {
		updateOption();
		int option = Integer.parseInt(br.readLine());
		if (option == 1) {
			System.out.println("Introduceti noul nume de familie: ");
			Main.guests.guestLastNameUpdate(position, br.readLine());
		} else if (option == 2) {
			System.out.println("Introduceti noul prenume: ");
			Main.guests.guestFirstNameUpdate(position, br.readLine());
		} else if (option == 3) {
			System.out.println("Introduceti noul email: ");
			Main.guests.guestEmailUpdate(position, br.readLine());
		} else if (option == 4) {
			System.out.println("Introduceti noul numar de telefon: ");
			Main.guests.guestPhoneUpdate(position, br.readLine());
		} else {
			System.out.println("Numarul indrodus este incorect");
		}
	}

}
