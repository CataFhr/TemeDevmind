import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestList {

	private final int maxGuestsNumber;
	//Lista evenimentului.E impartita in lista de participare si lista de asteptare in functie de maxGuestsNumber.
	private List<Guest> guestList; 

	public GuestList(int maxGuestsNumber) {
		this.maxGuestsNumber = maxGuestsNumber;
		this.guestList = new ArrayList<Guest>();
	}
    
	// Metoda care adauga o persoana in lista evenimentului.
	public void addGuest(Guest guest) {
		if (this.isConfirmedGuest(guest)) {
			System.out.println("Persoana este deja inscrisa la eveniment");
			return;
		}
		this.guestList.add(guest);
		if (this.guestList.size() <= this.maxGuestsNumber) {
			System.out.println("[" + guest.getLastName() + " " + guest.getFirstName() + "]"
					+ " Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
		} else {
			int position = this.guestList.size() - this.maxGuestsNumber;
			System.out.println("[" + guest.getLastName() + " " + guest.getFirstName() + "]"
					+ " Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " + position
					+ ". Te vom notifica daca un loc devine disponibil. ");
		}
	}
	
	// Metoda auxiliara care ne spune daca o persoana se afla sa nu in lista evenimentului.
	private boolean isConfirmedGuest(Guest guest) {
		return searchGuestByName(guest.getLastName(), guest.getFirstName()) >= 0
				|| searchGuestByEmail(guest.getEmail()) >= 0 || searchGuestByPhoneNumber(guest.getPhoneNumber()) >= 0;
	}

	public int searchGuestByName(String lastName, String firstName) {
		for (int i = 0; i < this.guestList.size(); i++) {
			Guest guest = this.guestList.get(i);
			if (guest.getLastName().equalsIgnoreCase(lastName) && guest.getFirstName().equalsIgnoreCase(firstName)) {
				return i;
			}
		}
		return -1;
	}

	public int searchGuestByEmail(String email) {
		for (int i = 0; i < this.guestList.size(); i++) {
			Guest guest = this.guestList.get(i);
			if (guest.getEmail().equalsIgnoreCase(email)) {
				return i;
			}
		}
		return -1;
	}

	public int searchGuestByPhoneNumber(String number) {
		for (int i = 0; i < this.guestList.size(); i++) {
			Guest guest = this.guestList.get(i);
			if (guest.getPhoneNumber().equals(number)) {
				return i;
			}
		}
		return -1;
	}

    // Metoda care sterge o persoana aflata la o anumita pozitie in lista evenimentului.
	public void removeGuest(int foundPosition) {
		this.guestList.remove(foundPosition);
		if (this.guestList.size() >= this.maxGuestsNumber && foundPosition < this.maxGuestsNumber) {
			Guest confirmedGuest = this.guestList.get(this.maxGuestsNumber - 1);
			System.out.println("[" + confirmedGuest.getLastName() + " " + confirmedGuest.getFirstName() + "]"
					+ "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
		} else {
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
		}
	}

	// Metode care actualizeaza detaliile unei persoane aflata la o anumita pozitie in lista evenimentului.
	public void guestLastNameUpdate(int foundPosition, String lastName) {
		this.guestList.get(foundPosition).setLastName(lastName);
	}

	public void guestFirstNameUpdate(int foundPosition, String firstName) {
		this.guestList.get(foundPosition).setFirstName(firstName);
	}

	public void guestEmailUpdate(int foundPosition, String email) {
		this.guestList.get(foundPosition).setEmail(email);
	}

	public void guestPhoneUpdate(int foundPosition, String phoneNo) {
		this.guestList.get(foundPosition).setPhoneNumber(phoneNo);
	}

	public void printGuestList() {
		if (this.guestList.size() == 0) {
			System.out.println("Lista de participanti este goala");
			return;
		}
		int index = this.maxGuestsNumber;
		if (this.guestList.size() < this.maxGuestsNumber) {
			index = this.guestList.size();
		}
		for (int i = 0; i < index; i++) {
			System.out.println(i + 1 + "." + this.guestList.get(i));
		}
	}

	public void printWaitingList() {
		if (this.guestList.size() <= this.maxGuestsNumber) {
			System.out.println("Lista de asteptare este goala...");
		} else {
			int index = this.maxGuestsNumber;
			for (int i = index; i < this.guestList.size(); i++) {
				System.out.println(i + 1 - index + "." + this.guestList.get(i));
			}
		}
	}

	public void getAvailablePosition() {
		int availablePos = this.maxGuestsNumber - this.guestList.size();
		if (availablePos > 0) {
			System.out.println("Numarul de locuri ramase: " + availablePos);
		} else {
			System.out.println("Numarul de locuri ramase: 0 ");
		}
	}

	public void getGuestsNumber() {
		int guestNo = (this.guestList.size() > this.maxGuestsNumber) ? this.maxGuestsNumber : this.guestList.size();
		System.out.println("Numarul de participanti: " + guestNo);

	}

	public void getWaitingGuestsNumber() {
		int waitingGuestNo = this.guestList.size() - this.maxGuestsNumber;
		if (waitingGuestNo > 0) {
			System.out.println("Numarul de persoane aflate in asteptare: " + waitingGuestNo);
		} else {
			System.out.println("Numarul de persoane aflate in asteptare: 0");
		}
	}

	public void getSubscribeGuests() {
		System.out.println("Numarul total de persoane: " + this.guestList.size());
	}

	// Metoda de cautare a contactelor dupa un sir de caractere introdus.
	public List<Guest> partialSearch(String str) {
		List<Guest> guests = this.guestList.stream().filter(g -> g.getLastName().contains(str)
				|| g.getFirstName().contains(str) || g.getEmail().contains(str) || g.getPhoneNumber().contains(str))
				.collect(Collectors.toList());
		return guests;
	}
}
