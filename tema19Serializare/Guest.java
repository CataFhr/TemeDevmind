package tema19Serializare;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Guest implements Serializable {

	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	
	private static final long serialVersionUID = 1L;

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

	public static void writeToBinaryFile(List<Guest> data) throws IOException {
		try (ObjectOutputStream binaryFileOut = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("TemeDevmind/tema19Serializare/guests.dat")))) {
			binaryFileOut.writeObject(data);
		}
	}

	public static List<Guest> readFromBinaryFile() throws IOException {
		List<Guest> data = null;
		try (ObjectInputStream binaryFileIn = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("TemeDevmind/tema19Serializare/guests.dat")))) {
			data = (List<Guest>) binaryFileIn.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("A class not found exception: " + e.getMessage());
		}
		return data;
	}

	@Override
	public String toString() {
		return "Nume: " + this.lastName + " " + this.firstName + ", Email: " + this.email + ", Telefon: " + this.phoneNumber;
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

		return this.lastName.equals(other.lastName) && this.firstName.equals(other.firstName) && this.email.equals(other.email)
				&& this.phoneNumber.equals(other.phoneNumber);
	}
}
