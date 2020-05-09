
public class Guest {

	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;

	public Guest(String lastName, String firstName, String email, String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		if (MyValidator.isValidName(lastName)) {
			this.lastName = lastName;
		} else {
			System.out.println("Nume incorect");
		}
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		if (MyValidator.isValidName(firstName)) {
			this.firstName = firstName;
		} else {
			System.out.println("Nume incorect");
		}
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		if (MyValidator.isValidEmail(email)) {
			this.email = email;
		} else {
			System.out.println("Email incorect");
		}
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (MyValidator.isValidPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else {
			System.out.println("Numar de telefon incorect");
		}
	}

	@Override
	public String toString() {
		return "Nume: " + this.lastName + " " + this.firstName + ", Email: " + this.email + ", Telefon: "
				+ this.phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = prime * result + ((this.phoneNumber == null) ? 0 : this.phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Guest other = (Guest) obj;

		return this.lastName.equals(other.lastName) && this.firstName.equals(other.firstName)
				&& this.email.equals(other.email) && this.phoneNumber.equals(other.phoneNumber);
	}
}
