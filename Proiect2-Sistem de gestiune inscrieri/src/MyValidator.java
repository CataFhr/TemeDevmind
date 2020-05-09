
public class MyValidator {

	private MyValidator() {
	}

	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidEmail(String email) {
		if (email != null && email.contains("@")) {
			return true;
		}
		return false;
	}

	public static boolean isValidPhoneNumber(String number) {
		if (number == null) {
			return false;
		}
		for (int i = 0; i < number.length(); i++) {
			if (!Character.isDigit(number.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidGuest(Guest guest) {
		return isValidName(guest.getLastName()) && isValidName(guest.getFirstName()) && isValidEmail(guest.getEmail())
				&& isValidPhoneNumber(guest.getPhoneNumber());
	}

	public static void validateGuestNumber(int guestNo) {
		if (guestNo <= 0) {
			throw new IllegalArgumentException("Numarul trebuie sa fie > 0");
		}
	}
}
